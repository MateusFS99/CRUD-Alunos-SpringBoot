package br.mfs.add.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.mfs.add.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
