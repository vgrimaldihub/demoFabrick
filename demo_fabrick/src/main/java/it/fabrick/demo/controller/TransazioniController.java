package it.fabrick.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import it.fabrick.demo.dto.ResponseTransazioniObj;
import it.fabrick.demo.dto.TransazioneDto;
import it.fabrick.demo.service.TransazioniService;
import it.fabrick.demo.util.ConstantUtil;


@RestController
@RequestMapping(path = "/transazioni")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransazioniController implements DemoController {


	private RestTemplate restTemplate;

	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private TransazioniService transazioniService;

	@Autowired
	public TransazioniController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	@ApiOperation(value = "Get Transazioni")
	@RequestMapping(path = "/{accountId}/transactions", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<TransazioneDto> getTransazioniByPeriod(
			@PathVariable String accountId,
			@RequestParam String fromAccountingDate,
			@RequestParam String toAccountingDate) throws JsonMappingException, JsonProcessingException{

		String uri = ConstantUtil.BASE_URL + "/api/gbs/banking/v4.0/accounts/14537780/transactions";

		Map<String, String> uriParam = new HashMap<>();
		uriParam.put("account", accountId);

		UriComponents builder = UriComponentsBuilder.fromHttpUrl(uri)
				.queryParam("fromAccountingDate",fromAccountingDate)
				.queryParam("toAccountingDate",toAccountingDate)
				.build();

		HttpHeaders headers = new HttpHeaders();

		headers.set("Auth-Schema", ConstantUtil.AUTH_SCHEMA);
		headers.set( "apikey", ConstantUtil.API_KEY);

		System.out.println("uriParam :  " +  uriParam);
		System.out.println("builder :  " +   builder.toUriString());
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class, uriParam);        

		ResponseTransazioniObj respobj = objectMapper.readValue(response.getBody(), ResponseTransazioniObj.class);
		System.out.println("payload list to string :  " +   respobj.getPayload());
		if(response.getStatusCode() == HttpStatus.OK) {
			return respobj.getPayload().getList();
		} else {
			return null;
		}
	}
	
	@ApiOperation(value = "Save Transazioni")
	@RequestMapping(path = "/{accountId}/saveByPeriod", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void postTransazioniByPeriod(
			@PathVariable String accountId,
			@RequestParam String fromAccountingDate,
			@RequestParam String toAccountingDate) throws JsonMappingException, JsonProcessingException{

		String uri = ConstantUtil.BASE_URL + "/api/gbs/banking/v4.0/accounts/14537780/transactions";

		Map<String, String> uriParam = new HashMap<>();
		uriParam.put("account", accountId);

		UriComponents builder = UriComponentsBuilder.fromHttpUrl(uri)
				.queryParam("fromAccountingDate",fromAccountingDate)
				.queryParam("toAccountingDate",toAccountingDate)
				.build();

		HttpHeaders headers = new HttpHeaders();

		headers.set("Auth-Schema", ConstantUtil.AUTH_SCHEMA);
		headers.set( "apikey", ConstantUtil.API_KEY);

		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class, uriParam);        

		ResponseTransazioniObj respobj = objectMapper.readValue(response.getBody(), ResponseTransazioniObj.class);
		
		respobj.getPayload().getList().forEach(transazione -> transazioniService.insertTransazioni(transazione));
		
	}
	
	
}