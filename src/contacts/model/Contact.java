/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contacts.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Joas Ramos
 */
@Entity
@Table(name = "contact")

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontact")
    private Integer idcontact;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "telefone_fixo")
    private String telefoneFixo;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Lob
    @Column(name = "imagem")
    private String imagem;

    public Contact() {
    }

    public Contact(Integer idcontact) {
        this.idcontact = idcontact;
    }

    public Contact(String nome, String telefoneFixo, String celular) {
//        this.idcontact = idcontact;
        this.nome = nome;
        this.telefoneFixo = telefoneFixo;
        this.celular = celular;
    }

    public Integer getIdcontact() {
        return idcontact;
    }

    public void setIdcontact(Integer idcontact) {
        this.idcontact = idcontact;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontact != null ? idcontact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.idcontact == null && other.idcontact != null) || (this.idcontact != null && !this.idcontact.equals(other.idcontact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
