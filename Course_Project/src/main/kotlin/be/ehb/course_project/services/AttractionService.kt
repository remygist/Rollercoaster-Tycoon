package be.ehb.course_project.services

import be.ehb.course_project.dto.attraction.AddCategoryToAttractionRequest
import be.ehb.course_project.dto.attraction.CreateAttractionRequest
import be.ehb.course_project.dto.attraction.UpdateAttractionRequest
import be.ehb.course_project.models.Attraction
import be.ehb.course_project.repositories.AttractionRepository
import be.ehb.course_project.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Calendar

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
        val attractionWithName = attractionRepository.findByName(attraction.name)
        if (attractionWithName.isPresent){
            throw RuntimeException("Attraction name `${attraction.name}` is already taken.")
        }

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, attraction.maintenanceFrequency)
        val nextMaintenanceDate = calendar.time

        val a = Attraction(
                name = attraction.name,
                capacity = attraction.capacity,
                dateOfBuild = attraction.dateOfBuild,
                duration = attraction.duration,
                image = attraction.image,
                onrideVideo = attraction.onrideVideo,
                maintenanceFrequency = attraction.maintenanceFrequency,
                minHeight = attraction.minHeight,
                speed = attraction.speed,
                inMaintenance = attraction.inMaintenance,
                nextMaintenance = nextMaintenanceDate
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

    fun update(attractionName: String, updateAttractionRequest: UpdateAttractionRequest): Attraction{
        val attraction = attractionRepository.findByName(attractionName).orElseThrow{
            throw RuntimeException("Attraction not found")
        }

        updateAttractionRequest.name?.let { attraction.name = it }
        updateAttractionRequest.capacity?.let { attraction.capacity = it }
        updateAttractionRequest.dateOfBuild?.let { attraction.dateOfBuild = it }
        updateAttractionRequest.image?.let { attraction.image = it }
        updateAttractionRequest.onrideVideo?.let { attraction.onrideVideo = it }
        updateAttractionRequest.maintenanceFrequency?.let { attraction.maintenanceFrequency = it }
        updateAttractionRequest.duration?.let { attraction.duration = it }
        updateAttractionRequest.minHeight?.let { attraction.minHeight = it }
        updateAttractionRequest.speed?.let { attraction.speed = it }
        updateAttractionRequest.inMaintenance?.let { attraction.inMaintenance = it }

        return attractionRepository.save(attraction)
    }

    fun delete(attractionName: String){
        val attraction = attractionRepository.findByName(attractionName).orElseThrow{
            throw RuntimeException("Attraction not found")
        }
        attractionRepository.delete(attraction)
    }
}