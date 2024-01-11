package gateway.service.project.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import gateway.service.project.Exceptions.MissingAuthorizationHeaderException;
import gateway.service.project.Util.JwtUtil;

@Component
public class AuthenticationFilter  extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{

	
	    @Autowired
	    private RouteValidator validator;
        @Autowired
	    private JwtUtil jwtUtil;
        
        

	    public AuthenticationFilter() {
	        super(Config.class);
	    }

	    @Override
	    public GatewayFilter apply(Config config) {
	        return ((exchange, chain) -> {
	        	ServerHttpRequest request = null;
	            if (validator.isSecured.test(exchange.getRequest())) {
	                //header contains token or not
	                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
	                    throw new MissingAuthorizationHeaderException("Missing authorization header");

	                }

	                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
	                if (authHeader != null && authHeader.startsWith("Bearer ")) {
	                    authHeader = authHeader.substring(7);
	                }
	                try {
	                    jwtUtil.validateToken(authHeader);
	                    
	                    request = exchange.getRequest()
	                    .mutate()
	                    .header("Token", authHeader)
	                    .build();

	                } catch (Exception e) {
	                    System.out.println("invalid access...!");
	                    throw new RuntimeException("unauthorized access to application "+ e.getMessage());
//	                    throw new UnauthorizedAccessException(HttpStatus.UNAUTHORIZED, "Not Authorised from Gateway");
	                }
	            }
	            return chain.filter(exchange.mutate().request(request).build());
	        });
	    }

	    public static class Config {

	    }
}
