package br.mfs.add.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.mfs.add.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
