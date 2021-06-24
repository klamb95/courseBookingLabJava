package com.example.codeclan.courseBooking.controllers;

import com.example.codeclan.courseBooking.models.Course;
import com.example.codeclan.courseBooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @return <List<Course>>

//    @GetMapping(value = "/courses")
//    public ResponseEntity<List<Course>> getAllCourses(){
//        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/courses")
    public ResponseEntity getCourseByRating(
            @RequestParam(required = false, name = "rating") Integer rating
    ){
        if (rating != null){
            return new ResponseEntity(courseRepository.findRating(rating), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);

    }


}
