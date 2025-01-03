package be.ehb.course_project.repositories

import be.ehb.course_project.models.Attraction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AttractionRepository: JpaRepository<Attraction, Long> {

    @Query("select a from Attraction a where a.name = :name")
    fun findByName(@Param("name") name: String): Optional<Attraction>
}