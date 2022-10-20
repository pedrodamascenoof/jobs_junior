package com.pedrodamasceno.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Recruiter {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotNull
    @Length(min=2, max=30,message="O tamanho do nome deve ser entre {min} e {max} caracteres")
	private String nome;

    @NotNull
    @Length(min=2, max=30,message="O tamanho do endereço deve ser entre {min} e {max} caracteres")
	private String email;
    
    @NotNull
    @Length(min=2, max=30,message="O tamanho da senha deve ser entre {min} e {max} caracteres")
	private String senha;
	
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date data;
    
    @DateTimeFormat(pattern = "dd-MM-yyyy")
   	private Date data2;
    
    public Recruiter() {}
    
	public Recruiter(Long id,String nome,String email,String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.data = new Date();
		this.data2 = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getData2() {
		return data2;
	}

	public void setData2(Date data2) {
		this.data2 = data2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recruiter other = (Recruiter) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", data=" + data
				+ ", data2=" + data2 + "]";
	}
	
	
}
