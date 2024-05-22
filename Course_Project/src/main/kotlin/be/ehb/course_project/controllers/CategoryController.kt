package be.ehb.course_project.controllers

import be.ehb.course_project.dto.CreateCategoryRequest
import be.ehb.course_project.models.Category
import be.ehb.course_project.services.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("category")
class CategoryController {

    @Autowired
    lateinit var categoryService: CategoryService

    @GetMapping("")
    fun index(): List<Category>{
        return categoryService.index()
    }

    @PostMapping("")
    fun store(@RequestBody categoryRequest: CreateCategoryRequest): Category{
        return categoryService.store(categoryRequest)
    }
}