package com.example.demo.controller;


import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value= "/Course", tags=" Different Courses are available ")
public class MainController {

    @Autowired
    private CourseService courseService;

    // Get API
    @GetMapping("/courses")
    @ApiOperation(value="Get Courses",notes = "Get Courses",tags={"Courses Management"})
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "courses shown successfully"),
            @ApiResponse(code = 404,message = "invalid data"),
            @ApiResponse(code = 500,message = "internal server error"),
    })
    public ResponseEntity<HttpStatus> getCourses() {
        try{
             this.courseService.getCourses();
            return new ResponseEntity<>(HttpStatus.OK);

        }
         catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get API for particular content
    @GetMapping("/courses/{courseId}")
    @ApiOperation(value="Get Course",notes = "Get Course",tags={"Courses Management"})
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "course shown successfully"),
            @ApiResponse(code = 404,message = "invalid data"),
            @ApiResponse(code = 500,message = "internal server error"),
    })
    public ResponseEntity<HttpStatus> getCourse(@Valid @PathVariable String courseId) {
        try {
            this.courseService.getCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Post API
    @PostMapping("/courses")
    @ApiOperation(value="add Courses",notes = "add Courses",tags={"Courses Management"})
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "courses added successfully"),
            @ApiResponse(code = 404,message = "invalid data"),
            @ApiResponse(code = 500,message = "internal server error"),
    })
    public ResponseEntity<HttpStatus> addCourses(@Valid @RequestBody Course course) {
        try {
            this.courseService.addCourse(course);
            return new ResponseEntity<>(HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Put API
    @PutMapping("/courses")
    @ApiOperation(value="edit Course",notes = "edit Course",tags={"Courses Management"})
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "courses updated successfully"),
            @ApiResponse(code = 404,message = "invalid data"),
            @ApiResponse(code = 500,message = "internal server error"),
    })
    public ResponseEntity<HttpStatus> editCourses(@Valid @RequestBody Course course) {
        try {
             this.courseService.editCourse(course);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete API
    @DeleteMapping("/courses/{courseId}")
    @ApiOperation(value="delete Courses",notes = "delete Courses",tags={"Courses Management"})
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "courses deleted successfully"),
            @ApiResponse(code = 404,message = "invalid data"),
            @ApiResponse(code = 500,message = "internal server error"),
    })
    public ResponseEntity<HttpStatus> deleteCourse(@Valid @PathVariable String courseId)
     {
         try {
              this.courseService.deleteCourse(Long.parseLong(courseId));
              return new ResponseEntity<>(HttpStatus.OK);

            } catch (Exception e)
            {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
}