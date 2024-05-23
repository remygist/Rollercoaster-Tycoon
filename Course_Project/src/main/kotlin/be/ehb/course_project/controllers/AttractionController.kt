package be.ehb.course_project.controllers

import be.ehb.course_project.dto.attraction.AddCategoryToAttractionRequest
import be.ehb.course_project.dto.attraction.AttractionResponse
import be.ehb.course_project.dto.attraction.CreateAttractionRequest
import be.ehb.course_project.dto.attraction.UpdateAttractionRequest
import be.ehb.course_project.dto.category.CategoryResponse
import be.ehb.course_project.dto.maintenance.MaintenanceResponse
import be.ehb.course_project.models.Attraction
import be.ehb.course_project.models.Category
import be.ehb.course_project.models.Maintenance
import be.ehb.course_project.services.AttractionService
import com.sun.tools.javac.Main
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("index")
@CrossOrigin
class AttractionController {
    @Autowired
    lateinit var attractionService: AttractionService

    @GetMapping("")
    fun index(): List<AttractionResponse>{
         var tempList = attractionService.index()
        return convertAttractionList(tempList)
    }

    fun convertAttractionList(list: List<Attraction>): List<AttractionResponse>{
        val attractionResponseList = mutableListOf<AttractionResponse>()
        for (a in list){
            attractionResponseList.add(
                    AttractionResponse(
                            name = a.name,
                            capacity = a.capacity,
                            dateOfBuild = a.dateOfBuild,
                            image = a.image,
                            onrideVideo = a.onrideVideo,
                            maintenanceFrequency = a.maintenanceFrequency,
                            duration = a.duration,
                            minHeight = a.minHeight,
                            speed = a.speed,
                            inMaintenance = a.inMaintenance,
                            nextMaintenance = a.nextMaintenance,
                            categories = convertCategoryList(a.categories),
                            maintenances = convertMaintenanceList(a.maintenances)
                    )
            )
        }
        return attractionResponseList
    }

    fun convertCategoryList(list: List<Category>): List<CategoryResponse> {
        val categoryResponseList = mutableListOf<CategoryResponse>()
        for (c in list) {
            categoryResponseList.add(
                    CategoryResponse(
                            title = c.title
                    )
            )
        }
        return categoryResponseList.toList()
    }

    fun convertMaintenanceList(list: List<Maintenance>): List<MaintenanceResponse>{
        val maintenanceResponseList = mutableListOf<MaintenanceResponse>()
        for (m in list){
            maintenanceResponseList.add(
                    MaintenanceResponse(
                            reason = m.reason,
                            startDate = m.startDate,
                            endDate = m.endDate
                    )
            )
        }
        return maintenanceResponseList
    }

    @PostMapping("")
    fun store(@RequestBody attractionRequest: CreateAttractionRequest):Attraction{
        return attractionService.store(attractionRequest)
    }

    @PostMapping("/addCategory")
    fun addCategory(@RequestBody request: AddCategoryToAttractionRequest): Attraction{
        return attractionService.addCategory(request)
    }

    @PutMapping("/editAttraction/{attractionName}")
    fun update(@PathVariable attractionName: String, @RequestBody request: UpdateAttractionRequest): Attraction {
        return attractionService.update(attractionName, request)
    }

    @DeleteMapping("/deleteAttraction/{attractionName}")
    fun delete(@PathVariable attractionName: String): String{
        attractionService.delete(attractionName)
        return "Attraction Deleted"
    }


}