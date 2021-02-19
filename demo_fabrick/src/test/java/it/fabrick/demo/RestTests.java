package it.fabrick.demo;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public class RestTests {


	ObjectMapper objectMapper = new ObjectMapper();
	
	@SuppressWarnings("deprecation")
	@Test
	public void noHeadersRandomId_then403IsReceived() throws ClientProtocolException, IOException {
		// Given
		final String accountId = randomAlphabetic(8);
		final HttpUriRequest request = new HttpGet("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/" + accountId);

		// When
		final HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_FORBIDDEN));
	}

}
