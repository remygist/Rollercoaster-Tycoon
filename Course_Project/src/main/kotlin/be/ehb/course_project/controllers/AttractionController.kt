package be.ehb.course_project.controllers

import be.ehb.course_project.dto.attraction.AddCategoryToAttractionRequest
import be.ehb.course_project.dto.attraction.AttractionResponse
import be.ehb.course_project.dto.attraction.CreateAttractionRequest
import be.ehb.course_project.dto.category.CategoryResponse
import be.ehb.course_project.models.Attraction
import be.ehb.course_project.models.Category
import be.ehb.course_project.services.AttractionService
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
        var attractionResponseList = mutableListOf<AttractionResponse>()
        for (a in list){
            attractionResponseList.add(
                    AttractionResponse(
                            name = a.name,
                            capacity = a.capacity,
                            dateOfBuild = a.dateOfBuild,
                            image = a.image,
                            onrideVideo = a.onrideVideo,
                            maintenance = a.maintenance,
                            duration = a.duration,
                            minHeight = a.minHeight,
                            speed = a.speed,
                            categories = convertCategoryList(a.categories)
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

    @PostMapping("")
    fun store(@RequestBody attractionRequest: CreateAttractionRequest):Attraction{
        return attractionService.store(attractionRequest)
    }

    @PostMapping("/addCategory")
    fun addCategory(@RequestBody request: AddCategoryToAttractionRequest): Attraction{
        return attractionService.addCategory(request)
    }


}