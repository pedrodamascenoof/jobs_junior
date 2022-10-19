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
public class Resumes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long id;
	
	@NotNull
    @Length(min=2, max=30,message="O tamanho do link deve ser entre {min} e {max} caracteres")
	private String resume;
	
	
	 @DateTimeFormat(pattern = "dd-MM-yyyy")
	 private Date data;
	    
	 @DateTimeFormat(pattern = "dd-MM-yyyy")
	 private Date data2;
	
	public Resumes() {}
	
	public Resumes(Long id,String resume,Users users) {
		super();
		this.id = id;
		this.resume = resume;
		this.data = new Date();
		this.data2 = new Date();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
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
		Resumes other = (Resumes) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Resumes [id=" + id + ", resume=" + resume + ", data=" + data + ", data2=" + data2
				+ "]";
	}
	
	

	
}
