package br.mfs.add.service;

import java.util.List;

import br.mfs.add.model.Turma;

public interface TurmaService {

	void create(Turma turma);
	void remove(int id);
	Turma getById(int id);
	List<Turma> getAll();
}
