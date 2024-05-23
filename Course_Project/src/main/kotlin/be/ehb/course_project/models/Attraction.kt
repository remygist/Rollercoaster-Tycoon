package be.ehb.course_project.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.sql.Time
import java.util.Date

@Entity
//@Table(name = "Attractions")
data class Attraction(
        @Id @GeneratedValue var id: Long = -1,
        var name: String,
        var capacity: Int,
        var dateOfBuild: Date,
        var image: String,
        var onrideVideo: String,
        var maintenanceFrequency: Int,
        var duration: Int,
        var minHeight: Int,
        var speed: Int,
        var inMaintenance: Boolean,
        var nextMaintenance: Date? = null
) {
    @ManyToMany
    var categories: MutableList<Category> = mutableListOf()

    @OneToMany
    var maintenances: MutableList<Maintenance> = mutableListOf()
}