package be.ehb.course_project.services

import be.ehb.course_project.dto.CreateAttractionRequest
import be.ehb.course_project.models.Attraction
import be.ehb.course_project.repositories.AttractionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AttractionService {
    @Autowired
    lateinit var attractionRepository: AttractionRepository

    fun index(): List<Attraction> {
        return attractionRepository.findAll()
    }

    fun store(attraction: CreateAttractionRequest): Attraction {
        val a = Attraction(
                name = attraction.name, capacity = attraction.capacity, dateOfBuild = attraction.dateOfBuild, duration = attraction.duration, image = attraction.image, onrideVideo = attraction.onrideVideo, maintenance = attraction.maintenance, minHeight = attraction.minHeight, speed = attraction.speed
        )

        return attractionRepository.save(a)
    }
}