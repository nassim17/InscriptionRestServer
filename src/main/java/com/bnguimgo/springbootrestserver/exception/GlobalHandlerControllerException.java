package com.bnguimgo.springbootrestserver.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = {"com.bnguimgo.springbootrestserver"})//Spring 3.2 And Above
public class GlobalHandlerControllerException extends ResponseEntityExceptionHandler{
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		//Vous ouvez initialiser toute autre donnee ici
	}
	
	@ModelAttribute //la variable "technicalError" pourra etre exploite n'importe ou dans l'application
	public void globalAttributes(Model model) {
		model.addAttribute("technicalError", "une erreur technique est survenue");
	}
	
	@ExceptionHandler(TechnicalErrorException.class)
	public ModelAndView technicalErrorException(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception.getMessage());
		mav.setViewName("error");
		return mav;
	}
	
	@ExceptionHandler(Exception.class) //toutes les autres erreurs non gerees sont intercpetees ici
	public ResponseEntity<BusinessResourceExceptionResponse> unknowError (HttpServletRequest req, Exception ex){
		BusinessResourceExceptionResponse response = new BusinessResourceExceptionResponse();
		response.setErrorCode("Technical Error");
        response.setErrorMessage(ex.getMessage());
        response.setRequestURL(req.getRequestURL().toString()); 
        return new ResponseEntity<BusinessResourceExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(BusinessResourceException.class)
    public ResponseEntity<BusinessResourceExceptionResponse> resourceNotFound(HttpServletRequest req, BusinessResourceException ex) {
        BusinessResourceExceptionResponse response = new BusinessResourceExceptionResponse();
        response.setStatus(ex.getStatus());
        response.setErrorCode(ex.getErrorCode());
        response.setErrorMessage(ex.getMessage());
        response.setRequestURL(req.getRequestURL().toString()); 
        return new ResponseEntity<BusinessResourceExceptionResponse>(response, ex.getStatus());
    }

}
