package id.co.indivara.jdt12.miniprojectbank.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

    // localhost:8080/swagger-ui/#/ cara manggil swagger

@Configuration
@EnableSwagger2
public class SwaggerSet {
@Bean
public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2)
         .select()
         .apis(RequestHandlerSelectors.basePackage("id.co.indivara.jdt12.miniprojectbank.controller"))
         .paths(PathSelectors.any())
         .build();
    }
}