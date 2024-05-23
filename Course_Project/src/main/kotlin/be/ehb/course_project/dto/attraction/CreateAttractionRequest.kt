package be.ehb.course_project.dto.attraction

import java.util.*

data class CreateAttractionRequest(
        var name: String,
        var capacity: Int,
        var dateOfBuild: Date,
        var image: String,
        var onrideVideo: String,
        var maintenanceFrequency: String,
        var duration: Int,
        var minHeight: Int,
        var speed: Int,
        var inMaintenance: Boolean
)
