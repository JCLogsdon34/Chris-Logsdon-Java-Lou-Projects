/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrarylou.dao;

/**
 *
 * @author JCLog
 */
public interface DvdLibraryLouAuditDao {
     public void writeAuditEntry(String entry) throws DvdLibraryLouPersistenceException;
}
