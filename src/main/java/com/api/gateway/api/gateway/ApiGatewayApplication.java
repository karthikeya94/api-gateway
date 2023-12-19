package com.api.gateway.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@GetMapping("/fallback")
	public String getFallback(){
		return "server error";
	}
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer(){
		return factory->factory.configureDefault(id->new Resilience4JConfigBuilder(id)
		.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
		.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofMillis(200))
		.build())
		.build());
	}
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizerSliding(){
		return factory->factory.configureDefault(id->new Resilience4JConfigBuilder(id)
		.circuitBreakerConfig(CircuitBreakerConfig.custom()
			.slidingWindowSize(10)
			.build())
		.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofMillis(200))
		.build())
		.build());
	}

}
