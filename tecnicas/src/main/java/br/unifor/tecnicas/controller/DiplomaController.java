package br.unifor.tecnicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.unifor.tecnicas.dao.DiplomaDao;
import br.unifor.tecnicas.model.Diploma;

@Controller
@RequestMapping("/diploma")
public class DiplomaController {
	@Autowired
	private DiplomaDao diplomaDao;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravarDiploma(Diploma diploma, RedirectAttributes redirectAttributes) {
		System.out.println(diploma);
		diplomaDao.gravar(diploma);
		redirectAttributes.addFlashAttribute("sucesso", "Diploma cadastrado com sucesso!");
		return new ModelAndView("redirect:/diploma");
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarDiplomas() {
		List<Diploma> diplomas = diplomaDao.listar();
		ModelAndView modelAndView = new ModelAndView("diploma/listarDiplomas");
		modelAndView.addObject("diplomas", diplomas);
		return modelAndView;
	}
}
