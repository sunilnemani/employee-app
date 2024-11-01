/*
*
*N Sunil 
*
*/

package com.sunil.employee.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeBeanInitializer
{
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeBeanInitializer.class);
	
	@Value("${GET_ADDRESS_APP_BASE_URL}") 
	private String getAddressAppBaseUrl;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		log.info("initializing RestTemplate");
		return new RestTemplate();
	}
	
	@Bean
	public WebClient getWebClient()
	{
		log.info("initializing WebClient");
		return WebClient.builder().baseUrl(getAddressAppBaseUrl).build();
	}

}
