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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.fabrick.demo.dto.BonificoRequest;
import it.fabrick.demo.dto.Creditor;
import it.fabrick.demo.dto.ResponseAccount;
import it.fabrick.demo.util.ConstantUtil;


@RestController
@RequestMapping(path = "/bonifico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BonificoController implements DemoController {

	private RestTemplate restTemplate;

	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	public BonificoController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	@ApiOperation(value = "Effettuo Bonifico")
	@RequestMapping(path = "/{accountId}/payments/money-transfers", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postBonifico(
			@ApiParam(value = "The user id", required = true)
			@PathVariable String accountId,
			@RequestParam String receiverName,
			@RequestParam String description,
			@RequestParam String currency,
			@RequestParam String amount,
			@RequestParam String executionDate) throws JsonMappingException, JsonProcessingException {

		String url = ConstantUtil.BASE_URL + "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";

		HttpHeaders headers = new HttpHeaders();

		headers.set("Auth-Schema", ConstantUtil.AUTH_SCHEMA);
		headers.set( "apikey", ConstantUtil.API_KEY);

		BonificoRequest bonificoRequest = new BonificoRequest();
		Creditor creditor = new Creditor();
		creditor.setName(receiverName);
		bonificoRequest.setDescription(description);
		bonificoRequest.setCurrency(currency);
		bonificoRequest.setCurrency(amount);
		bonificoRequest.setExecutionDate(executionDate);
		bonificoRequest.setCreditor(creditor);
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, bonificoRequest );       
		
		@SuppressWarnings("unused")
		ResponseAccount respobj = objectMapper.readValue(response.getBody(), ResponseAccount.class);

		HttpStatus status = response.getStatusCode();
		
		if(response.getStatusCode() == HttpStatus.OK) {
			return "STATO OPERAZIONE" + status.toString();
		} else {
			return accountId;
		}
	}

}