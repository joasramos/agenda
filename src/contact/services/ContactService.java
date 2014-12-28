/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.services;

import contacts.dao.ContactDAO;
import contacts.dao.SimpleEntityManager;
import contacts.model.Contact;
import java.util.List;
import javax.persistence.Query;

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

    public void dropContact(Contact c){
        simpleEntityManager.beginTransaction();
        dao.delete(c);
        simpleEntityManager.commit();
    }
    public List<Contact> findALL() {
        return this.dao.findAll();
    }

    public List<Contact> findAllByName(String nome) {
        Query q = simpleEntityManager.getEntityManager().createQuery("FROM Contact c WHERE c.nome LIKE '%" + nome + "%'");
        return q.getResultList();
    }
}
