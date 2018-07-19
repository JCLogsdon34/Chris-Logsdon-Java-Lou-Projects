package com.mycompany.dvdlibrarylou.advice;

import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouAuditDao;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouPersistenceException;
import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author JCLog
 */
public class LoggingAdvice {
    
    DvdLibraryLouAuditDao auditDao;
 
    public LoggingAdvice(DvdLibraryLouAuditDao auditDao) {
        this.auditDao = auditDao;
    }
 
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        LocalDateTime timestamp = LocalDateTime.now();

        String auditEntry = jp.getSignature().getName() + ": " + timestamp.toString() ;
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (DvdLibraryLouPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
}
