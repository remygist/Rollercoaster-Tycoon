package be.ehb.course_project.controllers

import be.ehb.course_project.dto.AddCategoryToAttractionRequest
import be.ehb.course_project.dto.CreateAttractionRequest
import be.ehb.course_project.models.Attraction
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
    fun index(): List<Attraction>{
        return attractionService.index()
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