package be.ehb.course_project.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.Date

@Entity
data class Maintenance(
        @Id @GeneratedValue var id: Long = -1,
        var reason: String,
        var startDate: Date,
        var endDate: Date? = null

) {
    @ManyToOne
    lateinit var attraction: Attraction
}