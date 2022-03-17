package br.mfs.add.service;

import java.util.List;

import br.mfs.add.model.Endereco;

public interface EnderecoService {

	void create(Endereco endereco);
	void remove(int id);
	Endereco getById(int id);
	List<Endereco> getAll();
}
