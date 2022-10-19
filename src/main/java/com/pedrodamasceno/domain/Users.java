package com.pedrodamasceno.domain;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Users {

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

	public Users(Long id,String nome,String email,String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.data = new Date();
		this.data2 = new Date();
	}

	public Date getData2() {
		return data2;
	}

	public void setData2(Date data2) {
		this.data2 = data2;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Users() {}

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
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", data=" + data
				+ ", data2=" + data2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( (id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}	