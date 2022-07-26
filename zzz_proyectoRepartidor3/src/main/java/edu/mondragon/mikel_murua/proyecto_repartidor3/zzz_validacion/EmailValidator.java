package edu.mondragon.mikel_murua.proyecto_repartidor3.zzz_validacion;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.springframework.core.io.buffer.DataBufferUtils.Matcher;



public class EmailValidator 
implements ConstraintValidator<ValidEmail, String> {
  
  private Pattern pattern;
  private java.util.regex.Matcher matcher;
  private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"; 
  @Override
  public void initialize(ValidEmail constraintAnnotation) {
  }

  private boolean validateEmail(String email) {
      pattern = Pattern.compile(EMAIL_PATTERN);
      matcher = pattern.matcher(email);
      return matcher.matches();
  }
@Override
public boolean isValid(String value, ConstraintValidatorContext context) {
	  return (validateEmail(value));
}
}
