package br.mfs.add.service;

import java.util.List;

import br.mfs.add.model.Escola;

public interface EscolaService {

	void create(Escola escola);
	void remove(int id);
	Escola getById(int id);
	List<Escola> getAll();
}
