package com.mycompany.dvdlibrarylou.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author JCLog
 */
public class DvdLibraryLouAuditDaoImpl implements DvdLibraryLouAuditDao {
 
    public static final String AUDIT_FILE = "audit.txt";
   
    @Override
    public void writeAuditEntry(String entry) throws DvdLibraryLouPersistenceException {
        PrintWriter out;
       
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new DvdLibraryLouPersistenceException("Could not persist audit information.", e);
        }
 
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
}
