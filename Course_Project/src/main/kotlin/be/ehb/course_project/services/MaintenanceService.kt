package be.ehb.course_project.services

import be.ehb.course_project.dto.maintenance.CreateMaintenanceRequest
import be.ehb.course_project.models.Maintenance
import be.ehb.course_project.repositories.AttractionRepository
import be.ehb.course_project.repositories.MaintenanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Date

@Service
class MaintenanceService {

    @Autowired lateinit var maintenanceRepository: MaintenanceRepository
    @Autowired lateinit var attractionRepository: AttractionRepository

    fun addMaintenanceToAttraction(attractionName: String, request: CreateMaintenanceRequest){
        val attraction = attractionRepository.findByName(attractionName).orElseThrow{
            RuntimeException("Attraction not found")
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
            RuntimeException("Attraction not found")
        }

        if (attraction.inMaintenance == false){
            throw RuntimeException("The attraction is not under maintenance.")
        } else{
            val currentDate = Date()
            val maintenance = attraction.maintenances.last()
            maintenance.endDate = currentDate
            maintenanceRepository.save(maintenance)

            attraction.inMaintenance = false
            attractionRepository.save(attraction)
        }
    }
}