package br.mfs.add.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.mfs.add.model.Escola;
import br.mfs.add.service.EnderecoService;
import br.mfs.add.service.EscolaService;

@Controller
public class EscolaController {

	@Autowired
	private EscolaService escolaService;
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/novaEscola")
	public String novaEscola(Model model) {
		
		Escola escola = new Escola();
		
		model.addAttribute("escola", escola);
		model.addAttribute("enderecos", enderecoService.getAll());
		
		return "novaEscola";
	}
	
	@PostMapping("/saveEscola")
	public String saveEscola(@ModelAttribute("escola") Escola escola) {
		
		escolaService.create(escola);
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteEscola/{id}")
	public String deleteEscola(@PathVariable (value = "id") int id) {
		
		this.escolaService.remove(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/updateEscola/{id}")
	public String updateEscola(@PathVariable (value = "id") int id, Model model) {
		
		Escola escola = escolaService.getById(id);

		model.addAttribute("escola", escola);
		model.addAttribute("enderecos", enderecoService.getAll());
		
		return "atualizarEscola";
	}
}
