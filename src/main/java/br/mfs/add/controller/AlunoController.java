package br.mfs.add.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.mfs.add.model.Aluno;
import br.mfs.add.service.AlunoService;
import br.mfs.add.service.TurmaService;

@Controller
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("listaAlunos", alunoService.getAll());
		
		return "index";
	}
	
	@GetMapping("/novoAluno")
	public String novoAluno(Model model) {
		
		Aluno aluno = new Aluno();
		
		model.addAttribute("aluno", aluno);
		model.addAttribute("turmas", turmaService.getAll());
		
		return "novoAluno";
	}
	
	@PostMapping("/saveAluno")
	public String saveAluno(@ModelAttribute("aluno") Aluno aluno) throws ParseException {
		
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		Date data = df2.parse(aluno.getDatanasc());
		
		aluno.setDatanasc(df1.format(data));
		alunoService.create(aluno);
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteAluno/{id}")
	public String deleteAluno(@PathVariable (value = "id") int id) {
		
		this.alunoService.remove(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/updateAluno/{id}")
	public String updateAluno(@PathVariable (value = "id") int id, Model model) throws ParseException {
		
		Aluno aluno = alunoService.getById(id);
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		Date data = df1.parse(aluno.getDatanasc());
		
		aluno.setDatanasc(df2.format(data));
		model.addAttribute("aluno", aluno);
		model.addAttribute("turmas", turmaService.getAll());
		
		return "atualizarAluno";
	}
}
