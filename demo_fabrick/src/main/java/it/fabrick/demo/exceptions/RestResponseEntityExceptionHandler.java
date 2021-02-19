package it.fabrick.demo.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.fabrick.demo.exceptions.errors.ErrorRepsonse;
import it.fabrick.demo.util.ConstantUtil;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Forbidden.class})
	protected ResponseEntity<ErrorRepsonse> handleException(Exception ex, HttpServletRequest request) {

		String accountId = getAccountIdParam(request.getRequestURI().toString());
		
		ErrorRepsonse response = new ErrorRepsonse();
		response.setCode(ConstantUtil.ERROR_CODE);
		response.setDescription(ConstantUtil.ERROR_DESCRIPTION + accountId);
		 
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}
	
	private String getAccountIdParam(String uri) {
		
			String[] parts = uri.split("/");
			return parts[2];
	}

	@SuppressWarnings("unused")
	@ExceptionHandler(value = { BadRequest.class})
	protected ResponseEntity<ErrorRepsonse> handleBadReq(Exception ex, HttpServletRequest request) {

		String accountId = getAccountIdParam(request.getRequestURI().toString());
		
		ErrorRepsonse response = new ErrorRepsonse();
		response.setCode(ConstantUtil.ERROR_CODE_BAD_REQUEST);
		response.setDescription(ConstantUtil.BAD_REQUEST);
		 
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}

}
