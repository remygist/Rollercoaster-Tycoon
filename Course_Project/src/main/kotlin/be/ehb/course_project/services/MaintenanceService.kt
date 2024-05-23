package be.ehb.course_project.services

import be.ehb.course_project.dto.maintenance.CreateMaintenanceRequest
import be.ehb.course_project.models.Maintenance
import be.ehb.course_project.repositories.AttractionRepository
import be.ehb.course_project.repositories.MaintenanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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
                endDate = request.endDate,
        )

        maintenance.attraction = attraction

        val savedMaintenance = maintenanceRepository.save(maintenance)

        attraction.maintenances.add(savedMaintenance)
        attraction.inMaintenance = true
        attractionRepository.save(attraction)
    }
}