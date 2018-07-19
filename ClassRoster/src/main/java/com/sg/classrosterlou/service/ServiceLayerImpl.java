package com.sg.classrosterlou.service;

import com.sg.classrosterlou.dao.ClassRosterAuditDao;
import com.sg.classrosterlou.dao.ClassRosterDao;
import com.sg.classrosterlou.dao.ClassRosterPersistenceException;
import com.sg.classrosterlou.dto.Student;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class ServiceLayerImpl implements ServiceLayer {

    ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;

    public ServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                    + student.getStudentId()
                    + " already exists");
        }

        // Now validate all the fields on the given Student object.  
        // This method will throw an
        // exception if any of the validation rules are violated.
        validateStudentData(student);

        // We passed all our business rules checks so go ahead 
        // and persist the Student object
        dao.addStudent(student.getStudentId(), student);

        // The student was successfully created, now write to the audit log
     //   auditDao.writeAuditEntry(
       //         "Student " + student.getStudentId() + " CREATED.");
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        //this is a pass through method
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        //Also pass through
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        // Write to audit log
       // auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }

    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {

        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
}
