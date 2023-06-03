package br.com.belval.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.belval.crud.model.Produto;

@Controller
public class ProdutoController {

	private static List<Produto> listaProdutos = new ArrayList<Produto>();
	private static int proxId = 1;

	@GetMapping("/produto/novo")
	public String novo() {
		return "novo-produto";
	}

	@PostMapping("/produto/novo")
	public ModelAndView novo(Produto produto, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/produto/list");
		redirectAttributes.addFlashAttribute("msg", "Novo produto criado!");
		produto.setId(proxId++);
		listaProdutos.add(produto);
		return modelAndView;
	}

	@GetMapping("/produto/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("lista-produtos");
		modelAndView.addObject("produtos", listaProdutos);
		return modelAndView;
	}
}
