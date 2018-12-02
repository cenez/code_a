package br.unifor.tecnicas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.unifor.tecnicas.dao.AlunoDao;
import br.unifor.tecnicas.model.Aluno;
import br.unifor.tecnicas.model.Diploma;
import br.unifor.tecnicas.model.DocumentoTipo;
import br.unifor.tecnicas.validation.AlunoValidation;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	private AlunoDao alunoDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new AlunoValidation());
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Aluno aluno) {
		System.out.println("aluno/form acessado!!!");
		ModelAndView modelAndView = new ModelAndView("aluno/form");
		modelAndView.addObject("tipos", DocumentoTipo.values());
		modelAndView.addObject("alunos", alunoDao.listar());
		return modelAndView;
	}
	@RequestMapping("/form/{id}")
	public ModelAndView form(Aluno aluno, @PathVariable("id") long id) {
		System.out.println("aluno/form/"+id+" acessado!!!");
		List<Diploma> diplomas = alunoDao.diplomasOf(id);
		
		diplomas.forEach(dip->{
			 System.out.println(dip.getRegistro() + " : " + dip.getAluno().getNome());
		 });
		
		ModelAndView modelAndView = new ModelAndView("aluno/form");
		modelAndView.addObject("tipos", DocumentoTipo.values());
		modelAndView.addObject("alunos", alunoDao.listar());
		modelAndView.addObject("diplomas", diplomas);
		return modelAndView;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Aluno aluno, BindingResult result, RedirectAttributes redirectAttributes) {
		System.out.println(aluno);
		
		if(result.hasErrors()) {
			return form(aluno);
		}
		
		alunoDao.gravar(aluno);
		redirectAttributes.addFlashAttribute("sucesso", "Aluno cadastrado com sucesso!");
		return new ModelAndView("redirect:aluno/form");
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
	@RequestMapping(value="/remove")
	public ModelAndView remove(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
		try {
			Aluno aluno = alunoDao.load(Integer.parseInt(id));
			if(aluno!=null) {
				alunoDao.remove(aluno);
				redirectAttributes.addFlashAttribute("sucesso", "Aluno removido com sucesso!");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("sucesso", "Falho remover aluno! Chave estrangeira documentos.");
		}
		return new ModelAndView("redirect:form");
	}
}
