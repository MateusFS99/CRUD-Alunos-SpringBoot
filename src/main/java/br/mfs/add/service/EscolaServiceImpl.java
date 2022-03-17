package br.mfs.add.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.mfs.add.model.Escola;
import br.mfs.add.repository.EscolaRepository;

@Service
public class EscolaServiceImpl implements EscolaService{

	@Autowired
	private EscolaRepository escolaRepository;
	
	@Override
	public void create(Escola escola) {
		this.escolaRepository.save(escola);
	}

	@Override
	public void remove(int id) {
		this.escolaRepository.deleteById(id);
	}

	@Override
	public Escola getById(int id) {
		
		Optional<Escola> optional = escolaRepository.findById(id);
		Escola escola = null;
		
		if(optional.isPresent())
			escola = optional.get();
		else
			throw new RuntimeException("Escola não encontrada!");
		
		return escola;
	}

	@Override
	public List<Escola> getAll() {
		return escolaRepository.findAll();
	}

}
