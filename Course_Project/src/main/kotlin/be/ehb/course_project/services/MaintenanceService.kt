package be.ehb.course_project.services

import be.ehb.course_project.dto.maintenance.CreateMaintenanceRequest
import be.ehb.course_project.exceptions.AttractionNotFoundException
import be.ehb.course_project.models.Maintenance
import be.ehb.course_project.repositories.AttractionRepository
import be.ehb.course_project.repositories.MaintenanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MaintenanceService {

    @Autowired lateinit var maintenanceRepository: MaintenanceRepository
    @Autowired lateinit var attractionRepository: AttractionRepository

    fun addMaintenanceToAttraction(attractionName: String, request: CreateMaintenanceRequest){
        val attraction = attractionRepository.findByName(attractionName).orElseThrow{
            AttractionNotFoundException("Attraction '$attractionName' not found")
        }

        val maintenance = Maintenance(
                reason = request.reason,
                startDate = request.startDate,
                endDate = null,
        )

        maintenance.attraction = attraction

        val savedMaintenance = maintenanceRepository.save(maintenance)

        attraction.maintenances.add(savedMaintenance)
        attraction.inMaintenance = true
        attractionRepository.save(attraction)
    }

    fun finishMaintenance(attractionName: String){
        val attraction = attractionRepository.findByName(attractionName).orElseThrow{
            AttractionNotFoundException("Attraction '$attractionName' not found")
        }

        if (!attraction.inMaintenance){
            throw RuntimeException("The attraction '$attractionName' is not under maintenance.")
        } else{
            val currentDate = Date()
            val maintenance = attraction.maintenances.last()
            maintenance.endDate = currentDate
            maintenanceRepository.save(maintenance)

            val calendar = Calendar.getInstance()
            calendar.time = currentDate
            calendar.add(Calendar.DAY_OF_YEAR, attraction.maintenanceFrequency)
            val nextMaintenanceDate = calendar.time

            attraction.inMaintenance = false
            attraction.nextMaintenance = nextMaintenanceDate
            attractionRepository.save(attraction)
        }
    }
}