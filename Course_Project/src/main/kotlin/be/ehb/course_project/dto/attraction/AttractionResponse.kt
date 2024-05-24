package be.ehb.course_project.dto.attraction

import be.ehb.course_project.dto.category.CategoryResponse
import be.ehb.course_project.dto.maintenance.MaintenanceResponse
import be.ehb.course_project.models.Maintenance
import java.util.*

data class AttractionResponse(
        var name: String,
        var capacity: Int? = null,
        var dateOfBuild: Date? = null,
        var image: String? = null,
        var onrideVideo: String? = null,
        var maintenanceFrequency: Int? = null,
        var duration: Int? = null,
        var minHeight: Int? = null,
        var speed: Int? = null,
        var inMaintenance: Boolean? = null,
        var nextMaintenance: Date? = null,
        var categories: List<CategoryResponse>? = null,
        var maintenances: List<MaintenanceResponse>? = null
)
