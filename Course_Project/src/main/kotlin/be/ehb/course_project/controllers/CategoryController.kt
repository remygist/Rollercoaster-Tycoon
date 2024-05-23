package be.ehb.course_project.controllers

import be.ehb.course_project.dto.attraction.AttractionResponse
import be.ehb.course_project.dto.category.CategoryResponse
import be.ehb.course_project.dto.category.CreateCategoryRequest
import be.ehb.course_project.dto.category.UpdateCategoryRequest
import be.ehb.course_project.models.Attraction
import be.ehb.course_project.models.Category
import be.ehb.course_project.services.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @PutMapping("/editCategory/{categoryName}")
    fun update(@PathVariable categoryName: String, @RequestBody request: UpdateCategoryRequest): Category{
        return categoryService.update(categoryName, request)
    }

    @DeleteMapping("/deleteCategory/{categoryName}")
    fun delete(@PathVariable categoryName: String): String {
        categoryService.delete(categoryName)
        return "Category Deleted"
    }

}