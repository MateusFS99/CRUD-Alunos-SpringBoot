package br.mfs.add.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.mfs.add.model.Endereco;
import br.mfs.add.service.EnderecoService;

@Controller
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/novoEndereco")
	public String novoEndereco(Model model) {
		
		Endereco endereco = new Endereco();
		
		model.addAttribute("endereco", endereco);
		
		return "novoEndereco";
	}
	
	@PostMapping("/saveEndereco")
	public String saveEndereco(@ModelAttribute("endereco") Endereco endereco) {
		
		enderecoService.create(endereco);
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteEndereco/{id}")
	public String deleteEndereco(@PathVariable (value = "id") int id) {
		
		this.enderecoService.remove(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/updateEndereco/{id}")
	public String updateEndereco(@PathVariable (value = "id") int id, Model model) {
		
		Endereco endereco = enderecoService.getById(id);
		
		model.addAttribute("endereco", endereco);
		
		return "atualizarEndereco";
	}
}
