package br.mfs.add.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.mfs.add.model.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer>{

}
