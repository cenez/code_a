package br.unifor.tecnicas.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.unifor.tecnicas.controller.IndexController;
import br.unifor.tecnicas.dao.DiplomaDao;
import br.unifor.tecnicas.dao.AlunoDao;

@EnableWebMvc
@ComponentScan(basePackageClasses={IndexController.class, AlunoDao.class, DiplomaDao.class})
public class AppWebConfiguration {
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
