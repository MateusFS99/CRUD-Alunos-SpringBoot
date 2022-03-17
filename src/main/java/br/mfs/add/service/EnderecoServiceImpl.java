package br.mfs.add.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.mfs.add.model.Endereco;
import br.mfs.add.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService{

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void create(Endereco endereco) {
		this.enderecoRepository.save(endereco);
	}

	@Override
	public void remove(int id) {
		this.enderecoRepository.deleteById(id);
	}

	@Override
	public Endereco getById(int id) {
		
		Optional<Endereco> optional = enderecoRepository.findById(id);
		Endereco endereco = null;
		
		if(optional.isPresent())
			endereco = optional.get();
		else
			throw new RuntimeException("Endereço não encontrado!");
		
		return endereco;
	}

	@Override
	public List<Endereco> getAll() {
		return enderecoRepository.findAll();
	}

}
