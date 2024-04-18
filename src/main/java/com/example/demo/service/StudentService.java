package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j // Simple logging framework for java
@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public Student save(Student student) {
    return studentRepository.save(student);
  }

  public Student findById(Long id) {
    Optional<Student> studentOptional = studentRepository.findById(id);
    if (studentOptional.isEmpty()) {
      log.warn("Student %d not found!".formatted(id));
      return null;
    }
    return studentOptional.get();
  }

  public List<Student> findAll() {
    List<Student> studentLinkedList = new LinkedList<>();
    studentRepository.findAll()
        .forEach(studentLinkedList::add);
    return studentLinkedList;
  }

  public void deleteById(Long id) {
    studentRepository.deleteById(id);
  }
}
