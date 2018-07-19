package com.sg.classrosterlou.dao;

/**
 *
 * @author JCLog
 */
public class ClassRosterPersistenceException extends Exception {

    //// use this ex ception when something is wrong in the application, 
    /// but that is not another excption like Data Validation
    // create new ClassRosterCDaoException, an d describe the problem
    public ClassRosterPersistenceException(String message) {
        super(message);
    }
    /*
    Use this exception when something is wrong in the application 
    that is caused by anopther exception. In such a case,
    catch the Implementation specific exception 
    create a new ClassRosterDaoException, and pass in a 
    new message witht he exception that caused the problem
    */
    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /// from the JavaDoc 
    /// public class Exception extends Throwable

}
