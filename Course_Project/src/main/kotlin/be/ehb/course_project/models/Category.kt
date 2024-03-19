package be.ehb.course_project.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
data class Category(
        @Id @GeneratedValue var id: Long = -1,
        var title: String
) {
    @ManyToMany
    var attractions: List<Attraction> = mutableListOf()
}