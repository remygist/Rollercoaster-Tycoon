package be.ehb.course_project.dto.attraction

import java.util.*

data class UpdateAttractionRequest(
        val name: String?,
        val capacity: Int?,
        val dateOfBuild: Date?,
        val image: String?,
        val onrideVideo: String?,
        val maintenance: String?,
        val duration: Int?,
        val minHeight: Int?,
        val speed: Int?
)
