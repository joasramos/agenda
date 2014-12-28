/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.frame;

import contact.controle.ControleContato;
import contacts.model.Contact;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Joas Ramos
 */
public class HomePage extends JFrame {

    private JPanel pn1, pn2;
    private JLabel lb1;
    private JTextField tf1;
    private JButton jb1, jb2;
    private JTable tbl1;
    private JScrollPane sp1;
    /**
     * Menu
     */
    private JMenuBar mb1;
    private JMenu mi1;
    /**
     * Lista de contatos
     */
    private List<Contact> list;
    private ControleContato controle;

    public HomePage(ControleContato c) {
        this.init();
        this.addElements();
        this.eventos();
        this.controle = c;
    }

    private void init() {
        this.setTitle("Home Page");
        this.setSize(600, 550);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(0, 50, 10));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        pn1 = new JPanel();
        pn2 = new JPanel();

        pn2.setBackground(Color.orange);

        lb1 = new JLabel("Nome: ");

        tf1 = new JTextField(20);

        jb1 = new JButton("Buscar");
        jb2 = new JButton("Novo+");

        tbl1 = new JTable();

        sp1 = new JScrollPane(tbl1);

        mb1 = new JMenuBar();

        mi1 = new JMenu("Contatos");

    }

    private void addElements() {
        /*
         * adicionando elementos ao painel 1
         */
        pn1.add(lb1);
        pn1.add(tf1);
        pn1.add(jb1);

        /*
         * adicionando elementos ao painel 2
         */
        pn2.add(sp1);

        this.add(pn1);
        this.add(pn2);
        this.add(jb2);
    }

    /**
     *
     * @param dtm representa o modelo da tabela
     */
    public void setTable(AbstractTableModel dtm) {
        this.tbl1.setModel(dtm);
    }

    public void setList(List<Contact> list) {
        this.list = list;
    }

    /*
     * Seta lista de contatos
     */
    private void eventos() {
        jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ManagerContato(controle).setVisible(true);
            }
        });

        tbl1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tbl1.getSelectedRow();
                Contact c = list.get(i);
                new DetailContato(c, controle).setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controle.carregaContatos(tf1.getText()); 
            }
        });
    }
}
