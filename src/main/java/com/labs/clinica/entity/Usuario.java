package com.labs.clinica.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

	private long id;
	private String nome;
	private String cpf;
	private String residencial;
	private String whatsApp;
	private String comercial;
	private String celular1;
	private String celular2;
	private String celular3;
	private String celular4;
	private Date data;
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	private String complemento;
	private String numero;
	private String email;
	private Boolean isManterContato;
//	private String email;

	public Usuario() {

	}

	public Usuario(String nome, String cpf, String residencial, String whatsapp,
			String comercial, String celular1, String celular2, String celular3,
			String celular4, Date data, String cep, String logradouro,
			String complemento, String bairro, String localidade, String uf,
			String numero, String email, Boolean isManterContato) {
		this.nome = nome;
		this.cpf = cpf;
		this.residencial = residencial;
		this.whatsApp = whatsapp;
		this.comercial = comercial;
		this.celular1 = celular1;
		this.celular2 = celular2;
		this.celular3 = celular3;
		this.celular4 = celular4;
		this.data = data;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.numero = numero;
		this.email = email;
		this.isManterContato = isManterContato;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NOME", nullable = false, length = 50)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "CPF", nullable = false, length = 11)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "RESIDENCIAL", nullable = false, length = 11)
	public String getResidencial() {
		return residencial;
	}

	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}

	@Column(name = "WHATSAPP", nullable = true, length = 11)
	public String getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	@Column(name = "COMERCIAL", nullable = true, length = 11)
	public String getComercial() {
		return comercial;
	}

	public void setComercial(String comercial) {
		this.comercial = comercial;
	}

	@Column(name = "CELULAR_1", nullable = true, length = 11)
	public String getCelular1() {
		return celular1;
	}

	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}

	@Column(name = "CELULAR_2", nullable = true, length = 11)
	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	@Column(name = "CELULAR_3", nullable = true, length = 11)
	public String getCelular3() {
		return celular3;
	}

	public void setCelular3(String celular3) {
		this.celular3 = celular3;
	}

	@Column(name = "CELULAR_4", nullable = true, length = 11)
	public String getCelular4() {
		return celular4;
	}

	public void setCelular4(String celular4) {
		this.celular4 = celular4;
	}

	@Column(name = "DATA")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "CEP", nullable = true, length = 8)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "LOGRADOURO", nullable = true, length = 35)
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(name = "BAIRRO", nullable = true, length = 25)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "LOCALIDADE", nullable = true, length = 15)
	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	@Column(name = "UF", nullable = true, length = 10)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Column(name = "COMPLEMENTO", nullable = true, length = 15)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name = "NUMERO", nullable = true, length = 10)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEmail() {
	return email;
	}
	
	@Column(name = "EMAIL", nullable = false, length = 80)
	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsManterContato() {
		return isManterContato;
	}

	public void setIsManterContato(Boolean isManterContato) {
		this.isManterContato = isManterContato;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpfUsuario=" + cpf + ", residencialUsuario=" + residencial 
				+ ",whatsAppUsuario=" + whatsApp + ",comercialUsuario=" + comercial + ",celular1Usuario=" + celular1
				+"celular2Usuario=" + celular2 + ",celular3Usuario=" + celular3 + "celular4Usuario=" + celular4
				+ ",dataUsuario=" + data + "cepUsuario=" + cep + "logradouroUsuario=" + logradouro
				+ "complementoUsuario=" + complemento + "bairroUsuario=" + bairro + "localidadeUsuario=" + localidade
				+ "ufUsuario=" + uf + "numeroUsuario=" + numero + "]";
	}


}