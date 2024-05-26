package be.ehb.course_project.models

import jakarta.persistence.*
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

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var maintenances: MutableList<Maintenance> = mutableListOf()
}