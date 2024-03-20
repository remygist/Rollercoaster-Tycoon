package be.ehb.course_project.services

import be.ehb.course_project.models.Attraction
import be.ehb.course_project.repositories.AttractionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AttractionService {
    @Autowired
    lateinit var attractionRepository: AttractionRepository

    fun index(): List<Attraction>{
        return attractionRepository.findAll()
    }

    fun store(attraction: Attraction): Attraction{
        return attractionRepository.save(attraction)
    }
}