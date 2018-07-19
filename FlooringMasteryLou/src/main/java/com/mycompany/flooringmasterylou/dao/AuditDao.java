package com.mycompany.flooringmasterylou.dao;

/**
 *
 * @author JCLog
 */
public interface AuditDao {
    
    public void writeAuditEntry(String entry)
            throws FlooringPersistenceException;
    
}
