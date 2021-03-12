package com.example.demo.service;

import com.example.demo.model.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course course);
    public Course editCourse(Course course);
    public void deleteCourse(long pareseLong);
}
