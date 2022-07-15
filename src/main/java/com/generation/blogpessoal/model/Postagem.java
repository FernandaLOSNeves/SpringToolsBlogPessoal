package com.generation.blogpessoal.model;

import java.time.LocalDateTime;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// transforma o objeto de postagem em uma tabela no banco de dados - o entity

@Entity

//Esse comando table nomeia a minha tabela 
@Table(name ="tb_postagem")

public class Postagem {
	
	// esse @id é pra criar uma chave primária, nenhuma tabela no banco de dados funciona sem 
	@Id
	//essa linha aqui embaixo é o auto_increment do mysql pro id, o generation n tem nada a ver com a Gen, é o comando.
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	//notnull não aceita titulos nulos
	@NotNull
	@Size(min =5, max=100)
	private String titulo;
	
	@NotNull
	@Size(min = 10, max =500)
	private String texto;
	
	//posso fazer assim a data:
	@UpdateTimestamp
	private LocalDateTime data;
	
	
	//@Temporal (TemporalType.TIMESTAMP)
	//private Date date = new java.sql.Date(System.currentTimeMillis()); 
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
		
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}

