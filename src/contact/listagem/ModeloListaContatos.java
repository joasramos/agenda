/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.listagem;

import contacts.model.Contact;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joas Ramos
 */
public class ModeloListaContatos extends AbstractTableModel {

    private List<Contact> list = null;

    public ModeloListaContatos(List<Contact> list) {
        this.list = list;
    }

    public List<Contact> getList() {
        return list;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        if (this.list != null) {
            return this.list.size();
        } else {
            return 0;
        }
    }

    @Override
    public String getColumnName(int column) {
        String s = "";
        if (column == 0) {
            s = "ID";
        } else if (column == 1) {
            s = "NOME";
        } else if (column == 2) {
            s = "TELEFONE";
        } else if (column == 3) {
            s = "CELULAR";
        }
        return s;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object o = null;
        if (column == 0) {
            o = this.list.get(row).getIdcontact();
        } else if (column == 1) {
            o = this.list.get(row).getNome();
        } else if (column == 2) {
            o = this.list.get(row).getTelefoneFixo();
        } else if (column == 3) {
            o = this.list.get(row).getCelular();
        }
        return o;
    }
}
