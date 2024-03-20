package be.ehb.course_project.controllers

import be.ehb.course_project.models.Attraction
import be.ehb.course_project.services.AttractionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("index")
class AttractionController {
    @Autowired
    lateinit var attractionService: AttractionService

    @GetMapping("")
    fun index(): List<Attraction>{
        return attractionService.index()
    }

    @PostMapping("")
    fun store(@RequestBody attraction: Attraction):Attraction{
        return attractionService.store(attraction)
    }
}