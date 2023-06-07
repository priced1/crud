package br.com.belval.crud.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.belval.crud.model.Produto;

	public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
	
		List<Produto> findByDescricao(String descricao);

		Produto findById(int id);
	}
