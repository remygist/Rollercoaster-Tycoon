package be.ehb.course_project.dto.maintenance

import java.util.*

data class MaintenanceResponse(
        var reason: String,
        var startDate: Date,
        var endDate: Date
)
