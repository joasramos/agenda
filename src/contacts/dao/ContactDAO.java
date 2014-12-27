/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contacts.dao;

import contacts.dao.GenericDAO;
import contacts.model.Contact;
import javax.persistence.EntityManager;

public class ContactDAO extends GenericDAO<Long, Contact> {
    public ContactDAO(EntityManager entityManager) {
        super(entityManager);
    }
}