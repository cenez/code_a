package br.unifor.tecnicas.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.unifor.tecnicas.model.Aluno;

public class AlunoValidation implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Aluno.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "endereco", "field.required");
		
//		Aluno aluno = (Aluno) target;
//		if(aluno.getId()<=0) {
//			errors.rejectValue("id", "field.required");
//		}
	}
}
