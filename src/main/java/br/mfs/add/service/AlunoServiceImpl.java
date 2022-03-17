package br.mfs.add.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.mfs.add.model.Aluno;
import br.mfs.add.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public void create(Aluno aluno) {
		this.alunoRepository.save(aluno);
	}

	@Override
	public void remove(int id) {
		this.alunoRepository.deleteById(id);
	}

	@Override
	public Aluno getById(int id) {
		
		Optional<Aluno> optional = alunoRepository.findById(id);
		Aluno aluno = null;
		
		if(optional.isPresent())
			aluno = optional.get();
		else
			throw new RuntimeException("Aluno não encontrado!");
		
		return aluno;
	}

	@Override
	public List<Aluno> getAll() {
		return alunoRepository.findAll();
	}
}
