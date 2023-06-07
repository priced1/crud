package br.com.belval.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.belval.crud.model.Produto;
import br.com.belval.crud.repository.ProdutoRepository;

	

@Controller
public class ProdutoController {

	private static List<Produto> listaProdutos = new ArrayList<Produto>();
	private static int proxId = 1;

	@GetMapping("/produto/novo")
	public ModelAndView novo() {
		//return "novo-produto";
		ModelAndView modelAndView = new ModelAndView("novo-produto");
		modelAndView.addObject("produto", new Produto());
		return modelAndView;
	}
	

	@PostMapping("/produto/novo")
	public ModelAndView novo(Produto produto, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/produto/list");
		String msg = "";
		//Identifica se é um novo produto sendo criado ou
		//um produto já existente sendo atualizado
		if (produto.getId() == 0) {
			msg = "Novo produto criado!";
		} else {
			msg = "Produto atualizado!";
		}
		redirectAttributes.addFlashAttribute("msg", msg);
		repository.save(produto);
		return modelAndView;
	}

	@GetMapping("/produto/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("lista-produtos");
		//modelAndView.addObject("produtos", listaProdutos);
		modelAndView.addObject("produtos", repository.findAll());
		return modelAndView;
	}
	//private static List<Produto> listaProdutos = new ArrayList<Produto>();
		//private static int proxId = 1;
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/produto/{id}")
	public String detalhe(@PathVariable("id") int id, Model model) {
		Produto p = repository.findById(id);
		if (p == null) {
			return "produto-nao-encontrado";
		}
		model.addAttribute("produto", p);
		return "detalhe-produto";
	}
	@GetMapping("/produto/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		Produto p = repository.findById(id);
		if (p == null) {
			return "produto-nao-encontrado";
		}
		model.addAttribute("produto", p);
		return "novo-produto";
	}
	
	
}
