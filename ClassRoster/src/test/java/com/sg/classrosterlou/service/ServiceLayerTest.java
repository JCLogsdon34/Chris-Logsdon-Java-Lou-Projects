package com.sg.classrosterlou.service;

import com.sg.classrosterlou.dao.ClassRosterAuditDao;
import com.sg.classrosterlou.dao.ClassRosterAuditDaoStubImpl;
import com.sg.classrosterlou.dao.ClassRosterDao;
import com.sg.classrosterlou.dao.ClassRosterDaoStubImpl;
import com.sg.classrosterlou.dto.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author JCLog
 */
public class ServiceLayerTest {

    private ServiceLayer service;
    
    public ServiceLayerTest() {
        /*  ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();

        service = new ServiceLayerImpl(dao, auditDao);
         */
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        service
                = ctx.getBean("serviceLayer", ServiceLayerImpl.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createStudent method, of class ServiceLayerImpl.
     */
    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student("0002");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");
        service.createStudent(student);
    }

    /**
     * Test of getAllStudents method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        assertEquals(1, service.getAllStudents().size());
    }

    @Test
    public void testCreateStudentDuplicateId() throws Exception {
        Student student = new Student("0001");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");

        try {
            service.createStudent(student);
            fail("Expected ClassRosterDuplicateIdException was not thrown.");
        } catch (ClassRosterDuplicateIdException e) {
            return;
        }

    }

    @Test
    public void testCreateStudentInvalidData() throws Exception {
        Student student = new Student("0002");
        student.setFirstName("");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");

        try {
            service.createStudent(student);
            fail("Expected ClassRosterDataValidationException was not thrown.");
        } catch (ClassRosterDataValidationException e) {
            return;
        }

    }

    /**
     * Test of getStudent method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetStudent() throws Exception {
        Student student = service.getStudent("0001");
        assertNotNull(student);
        student = service.getStudent("9999");
        assertNull(student);
    }

    /**
     * Test of removeStudent method, of class ServiceLayerImpl.
     */
    @Test
    public void testRemoveStudent() throws Exception {
        Student student = service.removeStudent("0001");
        assertNotNull(student);
        student = service.removeStudent("9999");
        assertNull(student);
    }

}
