package br.mfs.add.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.mfs.add.model.Turma;
import br.mfs.add.service.EscolaService;
import br.mfs.add.service.TurmaService;

@Controller
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	@Autowired
	private EscolaService escolaService;
	
	@GetMapping("/novaTurma")
	public String novaTurma(Model model) {
		
		Turma turma = new Turma();
		
		model.addAttribute("turma", turma);
		model.addAttribute("escolas", escolaService.getAll());
		
		return "novaTurma";
	}
	
	@PostMapping("/saveTurma")
	public String saveTurma(@ModelAttribute("turma") Turma turma) {
		
		turmaService.create(turma);
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteTurma/{id}")
	public String deleteTurma(@PathVariable (value = "id") int id) {
		
		this.turmaService.remove(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/updateTurma/{id}")
	public String updateTurma(@PathVariable (value = "id") int id, Model model) {
		
		Turma turma = turmaService.getById(id);
		
		model.addAttribute("turma", turma);
		model.addAttribute("escolas", escolaService.getAll());
		
		return "atualizarAluno";
	}
}
