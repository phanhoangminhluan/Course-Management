package com.luanphm.CourseManagement.exception_handling;

import com.luanphm.CourseManagement.exception_handling.CustomExceptions.RecordNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

//    private String pattern = "yyyy.mm.dd - hh:mm:ss";
//    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity handleAllExceptions(Exception exception, WebRequest webRequest) {
//        List<String> details = new ArrayList<>();
//        details.add(exception.getLocalizedMessage());
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .details(details)
//                .exceptionName(exception.getClass().getName())
//                .date(simpleDateFormat.format(new Date()))
//                .message("ERROR FROM SERVER")
//                .build();
//        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(RecordNotFoundException.class)
//    public final ResponseEntity handleNotFoundException(RecordNotFoundException exception, WebRequest webRequest) {
//        List<String> details = new ArrayList<>();
//        details.add(exception.getLocalizedMessage());
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .details(details)
//                .date(simpleDateFormat.format(new Date()))
//                .exceptionName(exception.getClass().getName())
//                .message("CAN'T FIND")
//                .build();
//        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        List<String> details = new ArrayList<>();
//        exception.getBindingResult().getAllErrors().forEach(objectError -> details.add(objectError.getDefaultMessage()));
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .details(details)
//                .date(simpleDateFormat.format(new Date()))
//                .exceptionName(exception.getClass().getName())
//                .message("VALIDATION FAILED")
//                .stackTraceElements(exception.getStackTrace())
//                .build();
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }

}
