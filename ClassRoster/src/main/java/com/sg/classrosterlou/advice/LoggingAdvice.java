package com.sg.classrosterlou.advice;

import com.sg.classrosterlou.dao.ClassRosterAuditDao;
import com.sg.classrosterlou.dao.ClassRosterPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author JCLog
 */
public class LoggingAdvice {
    
    ClassRosterAuditDao auditDao;
 
    public LoggingAdvice(ClassRosterAuditDao auditDao) {
        this.auditDao = auditDao;
    }
 
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (ClassRosterPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
}
