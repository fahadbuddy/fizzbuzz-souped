package uk.co.emiratesfinancial.fizzbuzzsouped;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select().apis(RequestHandlerSelectors.basePackage("uk.co.emiratesfinancial.fizzbuzzsouped.controller"))
            .paths(regex("/fizzBuzz.*"))
            .build()
            .apiInfo(apiInfo());

  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("SOUP-ed up FizzBuzz Application's REST API")
            .description("\"A fancy FizzBuzz app using Strategy and Factory design patterns to provide extensible mechanism to define FizzBuzz Rules\"")
            .build();
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addRedirectViewController("/", "/swagger-ui.html");
  }
}