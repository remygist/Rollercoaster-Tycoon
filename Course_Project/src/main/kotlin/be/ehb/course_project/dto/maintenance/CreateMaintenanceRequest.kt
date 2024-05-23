package be.ehb.course_project.dto.maintenance

import java.util.*

data class CreateMaintenanceRequest(
        var reason: String,
        var startDate: Date,
        var endDate: Date? = null
)
