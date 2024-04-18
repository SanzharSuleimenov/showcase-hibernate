package com.example.demo.web;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @PostMapping
  public Student save(@RequestBody Student student) {
    return studentService.save(student);
  }

  @GetMapping
  public List<Student> findAll() {
    return studentService.findAll();
  }

  @GetMapping("/{id}")
  public Student findById(@PathVariable Long id) {
    return studentService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    studentService.deleteById(id);
  }
}
