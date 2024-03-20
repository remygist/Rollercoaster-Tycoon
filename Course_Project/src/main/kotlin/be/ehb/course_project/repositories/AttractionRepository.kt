package be.ehb.course_project.repositories

import be.ehb.course_project.models.Attraction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AttractionRepository: JpaRepository<Attraction, Long> {
}