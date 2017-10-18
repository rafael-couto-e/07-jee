package br.edu.ifrs.canoas.jee.webapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco extends BaseEntity<Long> implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull
	private String logradouro;
	
	private int numero;
	
	@NotNull
	private String cep;
	
	@NotNull
	private String cidade;
	
	@NotNull
	private String estado;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEndereco(){
		return (numero > 0)
				? logradouro+", nº "+numero+" - "+cidade+"/"+estado
						: logradouro+", s/n - "+cidade+"/"+estado;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", cep=" + cep + ", cidade=" + cidade
				+ ", estado=" + estado + "]";
	}
}
