package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }
    public Object addNewStudent(Student student){

        Optional<Student> studentOptional=studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent())
            System.out.println(student);
        else{
            Student st1 =new Student(
                    student.getName(),
                    student.getEmail(),
                    LocalDate.of(2004, Month.JANUARY,5)

            );
            studentRepository.save(st1);
            System.out.println("student added ");
            return "STUDENT ADDED" ;
        }
        return student;
    }
}
