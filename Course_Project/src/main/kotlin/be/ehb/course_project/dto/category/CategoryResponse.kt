package be.ehb.course_project.dto.category

import be.ehb.course_project.dto.attraction.AttractionResponse

data class CategoryResponse(
        var title: String,
        var attraction: List<AttractionResponse>? = null
)
