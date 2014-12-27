package contact.controle;


import contact.frame.HomePage;
import contact.listagem.ModeloListaContatos;
import contact.services.ContactService;
import contacts.dao.SimpleEntityManager;
import contacts.model.Contact;
import java.util.List;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Joas Ramos
 */
public class ControleContato {

    private HomePage hp;
    private ContactService cs;
    private SimpleEntityManager em;

    public ControleContato() {
        init();        
        hp = new HomePage(this);
        hp.setVisible(true); 
        carregaContatos();
        
    }

    private void init() {
        String persistenceUnitName = "contactsPU";
        em = new SimpleEntityManager(persistenceUnitName);
        cs = new ContactService(em);
    }

    private void carregaContatos() {
        /*
         * Carregamos lista de contatos
         */
        List<Contact> l = cs.findALL();
        hp.setList(l);
        
        /*
         * Carregamos modelo de lista com a lista de contatos
         */
        ModeloListaContatos ml = new ModeloListaContatos(l);
        
        /**
         * Ajustamos tabela de contatos
         */
        
        hp.setTable(ml);
        
        /*
         * Fechamos conexão
         */
//        em.close();
    }
    
    public void salvarContato(Contact c){
        cs.saveContact(c); 
//        em.close();
        this.carregaContatos();
    }
}
