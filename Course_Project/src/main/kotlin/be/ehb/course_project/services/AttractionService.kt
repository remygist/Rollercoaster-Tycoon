package be.ehb.course_project.services

import be.ehb.course_project.dto.attraction.AddCategoryToAttractionRequest
import be.ehb.course_project.dto.attraction.CreateAttractionRequest
import be.ehb.course_project.models.Attraction
import be.ehb.course_project.repositories.AttractionRepository
import be.ehb.course_project.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AttractionService {
    @Autowired
    lateinit var attractionRepository: AttractionRepository

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    fun index(): List<Attraction> {
        return attractionRepository.findAll()
    }

    fun store(attraction: CreateAttractionRequest): Attraction {
        val a = Attraction(
                name = attraction.name, capacity = attraction.capacity, dateOfBuild = attraction.dateOfBuild, duration = attraction.duration, image = attraction.image, onrideVideo = attraction.onrideVideo, maintenance = attraction.maintenance, minHeight = attraction.minHeight, speed = attraction.speed
        )

        return attractionRepository.save(a)
    }

    fun addCategory(c: AddCategoryToAttractionRequest): Attraction {
        val attractionOptional = attractionRepository.findByName(c.attractionName)
        val categoryOptional = categoryRepository.findByName(c.categoryName)

        val attraction = attractionOptional.orElseThrow { RuntimeException("Attraction not found") }
        val category = categoryOptional.orElseThrow { RuntimeException("Category not found") }

        attraction.categories.add(category)
        return attractionRepository.save(attraction)
    }

}