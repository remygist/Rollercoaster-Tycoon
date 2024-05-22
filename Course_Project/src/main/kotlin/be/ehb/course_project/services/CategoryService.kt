package be.ehb.course_project.services

import be.ehb.course_project.dto.CreateCategoryRequest
import be.ehb.course_project.models.Category
import be.ehb.course_project.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService {

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    fun index():List<Category>{
        return categoryRepository.findAll()
    }

    fun store(c: CreateCategoryRequest): Category{
        val newCategory = Category(title = c.title)
        return categoryRepository.save(newCategory)
    }



}