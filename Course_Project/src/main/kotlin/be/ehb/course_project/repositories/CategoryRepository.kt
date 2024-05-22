package be.ehb.course_project.repositories

import be.ehb.course_project.models.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository: JpaRepository<Category, Long> {
    @Query("select c from Category c where c.title = :title")
    fun findByName(@Param("title") title: String): Optional<Category>
}