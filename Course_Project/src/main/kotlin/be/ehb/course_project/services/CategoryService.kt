package be.ehb.course_project.services

import be.ehb.course_project.dto.category.CreateCategoryRequest
import be.ehb.course_project.dto.category.UpdateCategoryRequest
import be.ehb.course_project.exceptions.CategoryNotFoundException
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
        val categoryWithName = categoryRepository.findByName(c.title)
        if (categoryWithName.isPresent){
            throw RuntimeException("Category name `${c.title}` has already been taken.")
        }

        val newCategory = Category(title = c.title)
        return categoryRepository.save(newCategory)
    }

    fun update(categoryName: String, updateCategoryRequest: UpdateCategoryRequest):Category{
        val category = categoryRepository.findByName(categoryName).orElseThrow{
            CategoryNotFoundException("Category '$categoryName' not found")
        }

        updateCategoryRequest.title?.let { category.title = it }

        return categoryRepository.save(category)
    }

    fun delete(categoryName: String): Category? {
        val category = categoryRepository.findByName(categoryName).orElseThrow {
            CategoryNotFoundException("Category '$categoryName' not found")
        }

        if (category.attractions.isNotEmpty()) {
            throw RuntimeException("Cannot delete category '$categoryName'. Attractions are still connected to this category.")
        } else {
            categoryRepository.delete(category)
        }

        return category
    }


}