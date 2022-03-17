package br.mfs.add.service;

import java.util.List;

import br.mfs.add.model.Aluno;

public interface AlunoService {

	void create(Aluno aluno);
	void remove(int id);
	Aluno getById(int id);
	List<Aluno> getAll();
}
