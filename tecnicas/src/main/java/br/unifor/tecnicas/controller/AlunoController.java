package br.unifor.tecnicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.unifor.tecnicas.dao.AlunoDao;
import br.unifor.tecnicas.model.Aluno;
import br.unifor.tecnicas.model.DocumentoTipo;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	private AlunoDao alunoDao;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		System.out.println("aluno/form acessado!!!");
		ModelAndView modelAndView = new ModelAndView("aluno/form");
		modelAndView.addObject("tipos", DocumentoTipo.values());
		return modelAndView;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(Aluno aluno, RedirectAttributes redirectAttributes) {
		System.out.println(aluno);
		alunoDao.gravar(aluno);
		redirectAttributes.addFlashAttribute("sucesso", "Aluno cadastrado com sucesso!");
		return new ModelAndView("redirect:/aluno");
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Aluno> alunos = alunoDao.listar();
		ModelAndView modelAndView = new ModelAndView("aluno/listar");
		modelAndView.addObject("alunos", alunos);
		return modelAndView;
	}
	@RequestMapping("{id}")
	public ModelAndView addDiploma(@PathVariable("id") long id){
		Aluno aluno = alunoDao.load(id);
		System.out.println("Entrou em /id: "+aluno.getId()+" aluno.nome: "+aluno.getNome());
		ModelAndView mv = new ModelAndView("/diploma/addDiploma");
		mv.addObject("aluno", aluno);
		return mv;
	}
}
