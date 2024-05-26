package be.ehb.course_project.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handleGenericException(exception: Exception): ResponseEntity<GenericErrorResponse>{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericErrorResponse(message = exception.message));
    }

    @ExceptionHandler
    fun handleAttractionNotFoundException(exception: AttractionNotFoundException): ResponseEntity<GenericErrorResponse>{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericErrorResponse(message = exception.message, timeStamp = System.currentTimeMillis()))
    }

    @ExceptionHandler
    fun handleCategoryNotFoundException(exception: CategoryNotFoundException): ResponseEntity<GenericErrorResponse>{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericErrorResponse(message = exception.message, timeStamp = System.currentTimeMillis()))
    }
}