package com.labs.clinica.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Date data;

 
    public Usuario() {
  
    }
 
    public Usuario(String nomeUsuario, String cpfUsuario, String telefoneUsuario, Date dataUsuario) {
         this.nome = nomeUsuario;
         this.cpf = cpfUsuario;
         this.telefone = telefoneUsuario;
         this.data = dataUsuario;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "NOME", nullable = false)
    public String getnome() {
        return nome;
    }
    public void setnome(String nomeUsuario) {
        this.nome = nomeUsuario;
    }
 
    @Column(name = "CPF", nullable = false)
    public String getcpf() {
        return cpf;
    }
    public void setcpf(String cpfUsuario) {
        this.cpf = cpfUsuario;
    }
 
    @Column(name = "TELEFONE", nullable = false)
    public String gettelefone() {
        return telefone;
    }
    public void settelefone(String telefoneUsuario) {
        this.telefone = telefoneUsuario;
    }
    @Column(name = "DATA_CONSULTA", nullable = false)
    public Date getdata() {
		return data;
	}
    public void setData(Date dataUsuario) {
		this.data = dataUsuario;
	}    

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", cpfUsuario=" + cpf + ", telefoneUsuario=" + telefone + ",dataUsuario=" + data
       + "]";
    }
 
}