/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.frame;

import contact.controle.ControleContato;
import contacts.model.Contact;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 *
 * @author Joas Ramos
 */
public class DetailContato extends JDialog {

    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7;
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
    private JButton bt1, bt2, bt3;
    private Contact contact;
    
    private ControleContato controle;

    public DetailContato(Contact c, ControleContato cc) {
        this.setTitle("Detalhes do contato");
        this.setSize(600, 550);
        this.setLayout(new FlowLayout(20, 140, 25));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.contact = c;
        this.controle = cc;
        init();
        setValues();
        addElements();
        eventos();
    }

    private void init() {
        lb1 = new JLabel("Nome.:");
        lb2 = new JLabel("Telefone Fixo.:");
        lb3 = new JLabel("Celular.:");
        lb4 = new JLabel("Endereço.:");
        lb5 = new JLabel("Bairro.:");
        lb6 = new JLabel("Cidade.:");
        lb7 = new JLabel("Nascimento.:");
        bt1 = new JButton("Excluir Contato?");
    }

    private void addElements() {
        ajustaFonte(lb1);
        ajustaFonte(lb2);
        ajustaFonte(lb3);
        ajustaFonte(lb4);
        ajustaFonte(lb5);
        ajustaFonte(lb6);
        ajustaFonte(lb7);

        this.add(lb1);
        this.add(lb2);
        this.add(lb3);
        this.add(lb4);
        this.add(lb5);
        this.add(lb6);
        this.add(lb7);
        this.add(bt1);
    }

    private void setValues() {
        lb1.setText(lb1.getText() + ": " + contact.getNome());
        lb2.setText(lb2.getText() + ": " + contact.getTelefoneFixo());
        lb3.setText(lb3.getText() + ": " + contact.getCelular());
        lb4.setText(lb4.getText() + ": " + contact.getEndereco());
        lb5.setText(lb5.getText() + ": " + contact.getBairro());
        lb6.setText(lb6.getText() + ": " + contact.getCidade());
        lb7.setText(lb7.getText() + ": " + new SimpleDateFormat("dd/MM/yyyy").format(contact.getNascimento()));
    }

    private void ajustaFonte(JLabel lb) {
        lb.setFont(new Font("Serif", Font.BOLD, 24));
    }

    private void eventos() {
        bt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              controle.deletarContato(contact); 
              fecharDialogo();
              JOptionPane.showMessageDialog(null,"Contato deletado com sucesso!");
            }
        });
    }
    
    private void fecharDialogo(){
        this.dispose();
    }
}
