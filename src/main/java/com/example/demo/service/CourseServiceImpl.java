package com.example.demo.service;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
@Autowired
    private CourseDao courseDao;
   // List<Course> list;
    public CourseServiceImpl()
    {
       // list = new ArrayList<>();
       // list.add(new Course(101L,"core java","This course contains basics of java"));
       // list.add(new Course(102L,"core C#","This course contains basics of C#"));

    }


     @Override
    public List<Course> getCourses()
     {
         return  courseDao.findAll();
        //return list;
    }

    @Override
    public Course getCourse(long courseId) {
        //Course c=null;
       /* for (Course course: list)
        {
            if(course.getId()==courseId){
                c=course;
                break;
            }
        }*/
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        //list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course editCourse(Course course) {
       /* list.forEach(e -> {
            if(e.getId()==course.getId())
            {
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });*/
        courseDao.save(course);
        return course;
    }
    @Override
    public void deleteCourse(long pareseLong)
    {
      // list=this.list.stream().filter(e->e.getId()!=pareseLong).collect(Collectors.toList());
       Course entity= courseDao.getOne(pareseLong);
       courseDao.delete(entity);
    }
}
