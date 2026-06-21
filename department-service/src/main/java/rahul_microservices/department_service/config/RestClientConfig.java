package rahul_microservices.department_service.config;

//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestClient;
//import org.springframework.web.client.support.RestClientAdapter;
//import org.springframework.web.service.invoker.HttpServiceProxyFactory;
//import rahul_microservices.department_service.client.EmployeeClient;

@Configuration
public class RestClientConfig {
/*
    @Bean
    @LoadBalanced
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    public EmployeeClient employeeClient(RestClient.Builder builder) {
        RestClient restClient = builder.baseUrl("http://EMPLOYEE-SERVICE").build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();
        return factory.createClient(EmployeeClient.class);
    }
*/
}