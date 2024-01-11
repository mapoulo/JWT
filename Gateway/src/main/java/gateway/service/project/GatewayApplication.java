package gateway.service.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import reactor.core.publisher.Mono;

@SpringBootApplication
@OpenAPIDefinition
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	////Group requests by remote IP address
//	@Bean
//	public KeyResolver keyResolver() {
//		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
//	}
	
	
	
	//Group requests by userId
//	@Bean
//	public KeyResolver keyResolver() {
//	    return exchange -> Mono.just(exchange.getRequest().getHeaders().getFirst("Id"));
//	}
	
	
	//Checking all info in the request header
//	  @Bean
//	    public KeyResolver keyResolver() {
//	        return exchange -> {
//	            StringBuilder headerInfo = new StringBuilder();
//
//	            // Get all the headers from the incoming request
//	            exchange.getRequest().getHeaders().forEach((key, value) ->
//	                    headerInfo.append(key).append(": ").append(value).append("\n"));
//                System.out.println(headerInfo.toString());
//	            return Mono.just(headerInfo.toString());
//	        };
//	    }
	  
	  
	  
	  
	  @Bean
	    public KeyResolver userTokenKeyResolver() {
	        return exchange -> {
	            String userToken = exchange.getRequest().getHeaders().getFirst("Token");

	            if (userToken != null && !userToken.isEmpty()) {
	                return Mono.just(userToken);
	            }

	            // If the user token is not found or empty, return a default key
	            return Mono.just("defaultKey");
	        };
	    }
	  
	  
	 

}



