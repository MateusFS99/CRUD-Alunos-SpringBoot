package br.mfs.add.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.mfs.add.model.Turma;
import br.mfs.add.repository.TurmaRepository;

@Service
public class TurmaServiceImpl implements TurmaService{

	@Autowired
	private TurmaRepository turmaRepository;
	
	@Override
	public void create(Turma turma) {
		this.turmaRepository.save(turma);
	}

	@Override
	public void remove(int id) {
		this.turmaRepository.deleteById(id);
	}

	@Override
	public Turma getById(int id) {
		
		Optional<Turma> optional = turmaRepository.findById(id);
		Turma turma = null;
		
		if(optional.isPresent())
			turma = optional.get();
		else
			throw new RuntimeException("Turma não encontrada!");
		
		return turma;
	}

	@Override
	public List<Turma> getAll() {
		return turmaRepository.findAll();
	}
}
