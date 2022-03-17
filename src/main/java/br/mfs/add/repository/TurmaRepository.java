package br.mfs.add.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.mfs.add.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

}
