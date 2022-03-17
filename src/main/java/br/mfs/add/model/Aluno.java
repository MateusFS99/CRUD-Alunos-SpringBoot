package br.mfs.add.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "aluno_nome")
	private String nome;
	
	@Column(name = "aluno_datanasc")
	private String datanasc;
	
	@ManyToOne
	@JoinColumn
	private Turma turma;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
