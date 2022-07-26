package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_validacion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordMatchesValidator
implements ConstraintValidator<PasswordMatches, Object> {
  
  @Override
  public void initialize(PasswordMatches constraintAnnotation) {
  }
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){
      /*
	  CredencialDto user = (CredencialDto) obj;
      return user.getPassword().equals(user.getMatchingPassword());
  */
	  return false;
  }
}