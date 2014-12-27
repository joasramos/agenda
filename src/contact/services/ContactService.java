/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.services;

import contacts.dao.SimpleEntityManager;
import contacts.model.Contact;
import contacts.dao.ContactDAO;
import java.util.List;

/**
 *
 * @author Joas Ramos
 */
public class ContactService {

    private SimpleEntityManager simpleEntityManager;
    private ContactDAO dao;

    public ContactService(SimpleEntityManager em) {
        this.simpleEntityManager = em;
        this.dao = new ContactDAO(em.getEntityManager());
    }

    public void saveContact(Contact c) {
        simpleEntityManager.beginTransaction();
        dao.save(c);
        simpleEntityManager.commit();
    }

    public List<Contact> findALL() {
        return this.dao.findAll();
    }
}
