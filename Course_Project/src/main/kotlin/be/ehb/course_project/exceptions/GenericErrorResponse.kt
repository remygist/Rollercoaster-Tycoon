package be.ehb.course_project.exceptions

class GenericErrorResponse ( var status : Int? = null,
                             var message : String? = null,
                             var timeStamp : Long? = null)