package rahul_microservices.department_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import rahul_microservices.department_service.client.EmployeeClient;

@Configuration
public class WebClientConfig { // It should point to EmployeeClient

    @Autowired
    private LoadBalancedExchangeFilterFunction loadBalancedExchangeFilterFunction;

    @Bean
    public WebClient employeeWebClient() {
        return WebClient.builder()
                .baseUrl("http://employee-service") // there can be multiple instances of employee-service
                .filter(loadBalancedExchangeFilterFunction)
                .build();
    }

    // Now using this above WebClient, I want to connect to my employee-service and get the employees of a department
    @Bean
    public EmployeeClient employeeClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory
                        .builderFor(WebClientAdapter.create(employeeWebClient()))
                        .build();

        return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }

}
