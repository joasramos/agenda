/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import contact.controle.ControleContato;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Joas Ramos
 */
public class Executar {

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            ControleContato cc = new ControleContato();           
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
    }
}
