package br.edu.ifrs.canoas.jee.webapp.model;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 6262524988798723388L;

	@NotNull @Email 
	private String email;
	
	@NotNull @Length(min=6, max=8)
	@Pattern(regexp="^[A-Za-z0-9]+$", message="A senha deve ter apenas letras e números")
	private String senha;
	
	@NotNull
	private String nome;
	
	private String sobrenome;
	
	private String telefone;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	
	@PostConstruct
	public void init(){
		endereco = new Endereco();
	}
	
	public Usuario() {
	}
		
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Endereco getEndereco(){
		return endereco;
	}
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", senha=" + senha + ", nome=" + nome + ", sobrenome=" + sobrenome
				+ ", telefone=" + telefone + ", endereco=" + endereco + "]";
	}
}
