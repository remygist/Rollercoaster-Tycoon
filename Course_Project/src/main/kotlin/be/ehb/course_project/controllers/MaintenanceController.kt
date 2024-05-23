package be.ehb.course_project.controllers

import be.ehb.course_project.dto.maintenance.CreateMaintenanceRequest
import be.ehb.course_project.services.MaintenanceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/maintenance")
@CrossOrigin
class MaintenanceController {

    @Autowired lateinit var maintenanceService: MaintenanceService

    @PostMapping("/addMaintenance/{attractionName}")
    fun addMaintenanceToAttraction(@PathVariable attractionName: String,@RequestBody request: CreateMaintenanceRequest){
        return maintenanceService.addMaintenanceToAttraction(attractionName, request)
    }

    @PutMapping("/finishMaintenance/{attractionName}")
    fun finishMaintenance(@PathVariable attractionName: String){
        return maintenanceService.finishMaintenance(attractionName)
    }


}