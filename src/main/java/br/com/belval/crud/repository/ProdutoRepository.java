package br.com.belval.crud.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.belval.crud.model.Curso;

	public interface ProdutoRepository extends CrudRepository<Curso, Integer> {
	
		List<Curso> findByDescricao(String descricao);

		Curso findById(int id);
	}
