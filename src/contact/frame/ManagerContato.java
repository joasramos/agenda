/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.frame;

import contact.controle.ControleContato;
import contacts.model.Contact;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Joas Ramos
 */
public class ManagerContato extends JDialog {

    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7;
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
    private JButton bt1, bt2, bt3;
    private Contact c;
    private ControleContato controle;

    public ManagerContato(ControleContato controle) {
        this.setTitle("Detalhes do contato");
        this.setSize(600, 550);
        this.setLayout(new FlowLayout(10, 150, 15));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.controle = controle;
        init();
        addElements();
        eventos();
    }

    private void init() {
        lb1 = new JLabel("Nome.:");
        tf1 = new JTextField(30);
        lb2 = new JLabel("Telefone Fixo.:");
        tf2 = new JTextField(30);
        lb3 = new JLabel("Celular.:");
        tf3 = new JTextField(30);
        lb4 = new JLabel("Endereço.:");
        tf4 = new JTextField(30);
        lb5 = new JLabel("Bairro.:");
        tf5 = new JTextField(30);
        lb6 = new JLabel("Cidade.:");
        tf6 = new JTextField(30);
        lb7 = new JLabel("Nascimento.:");
        tf7 = new JTextField(30);

        bt1 = new JButton("Salvar");
    }

    private void addElements() {
        this.add(lb1);
        this.add(tf1);
        this.add(lb2);
        this.add(tf2);
        this.add(lb3);
        this.add(tf3);
        this.add(lb4);
        this.add(tf4);
        this.add(lb5);
        this.add(tf5);
        this.add(lb6);
        this.add(tf6);
        this.add(lb7);
        this.add(tf7);
        this.add(bt1);
    }

    private void eventos() {
        bt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setObject();
                controle.salvarContato(c);
                closeDialog();
            }
        });
    }

    private void setObject() {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date date = null;

        try {
            date = (Date) formatter.parse(tf7.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ManagerContato.class.getName()).log(Level.SEVERE, null, ex);
        }

        c = new Contact();
        c.setNome(tf1.getText());
        c.setTelefoneFixo(tf2.getText());
        c.setCelular(tf3.getText());
        c.setEndereco(tf4.getText());
        c.setBairro(tf5.getText());
        c.setCidade(tf6.getText());
        c.setNascimento(date);

    }

    private void closeDialog() {
       dispose();
    } 
}
