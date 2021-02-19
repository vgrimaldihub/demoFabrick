package it.fabrick.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import it.fabrick.demo.dto.ResponseAccount;
import it.fabrick.demo.dto.AccountDto;
import it.fabrick.demo.util.ConstantUtil;



@RestController
@RequestMapping(path = "/account")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController implements DemoController {

	private RestTemplate restTemplate;

	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	public AccountController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	@ApiOperation(value = "Get Account info by accountId")
	@RequestMapping(path = "/{accountId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public AccountDto getSaldoByIdAccount(@PathVariable String accountId) throws JsonMappingException, JsonProcessingException{

		String url = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}";

		HttpHeaders headers = new HttpHeaders();

		headers.set("Auth-Schema", ConstantUtil.AUTH_SCHEMA);
		headers.set( "apikey", ConstantUtil.API_KEY);

		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, accountId);        

		System.out.println(response);
		ResponseAccount respobj = objectMapper.readValue(response.getBody(), ResponseAccount.class);

		if(response.getStatusCode() == HttpStatus.OK) {
			return respobj.getPayload();
		} else {
			return null;
		}

	}

}