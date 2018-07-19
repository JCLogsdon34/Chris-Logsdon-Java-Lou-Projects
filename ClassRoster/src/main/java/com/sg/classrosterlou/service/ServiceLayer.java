package com.sg.classrosterlou.service;

import com.sg.classrosterlou.dao.ClassRosterPersistenceException;
import com.sg.classrosterlou.dto.Student;
import java.util.List;

/**
 *
 * @author JCLog
 */
public interface ServiceLayer {

    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;

    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    Student getStudent(String studentId) throws
    ClassRosterPersistenceException;
    
    Student removeStudent(String studentId) throws
    ClassRosterPersistenceException;
}
