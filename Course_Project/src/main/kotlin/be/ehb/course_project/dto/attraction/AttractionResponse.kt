package be.ehb.course_project.dto.attraction

import be.ehb.course_project.dto.category.CategoryResponse
import be.ehb.course_project.dto.maintenance.MaintenanceResponse
import be.ehb.course_project.models.Maintenance
import java.util.*

data class AttractionResponse(
        var name: String,
        var capacity: Int,
        var dateOfBuild: Date,
        var image: String,
        var onrideVideo: String,
        var maintenanceFrequency: String,
        var duration: Int,
        var minHeight: Int,
        var speed: Int,
        var inMaintenance: Boolean,
        var categories: List<CategoryResponse>,
        var maintenances: List<MaintenanceResponse>
)
