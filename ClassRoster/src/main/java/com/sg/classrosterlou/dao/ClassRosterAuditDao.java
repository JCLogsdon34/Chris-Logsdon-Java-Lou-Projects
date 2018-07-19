package com.sg.classrosterlou.dao;
/**
 *
 * @author JCLog
 */
public interface ClassRosterAuditDao {
    
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;

}
