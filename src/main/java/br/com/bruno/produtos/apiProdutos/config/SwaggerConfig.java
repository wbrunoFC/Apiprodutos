package br.com.bruno.produtos.apiProdutos.config;
import java.util.ArrayList;
import org.springframework.context.annotation.*;

import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiPradutos() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.bruno.apiProdutos"))
				.paths(regex("/produtos.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private Object metaInfo() {
		ApiInfo apiInfo = new ApiInfo("API REST Produtos"
				, "Endpoints para api rest produtos"
				, "0.0"
				, "Termos de serviço "
				, new Contact("Wallison Bruno"
						,"https://www.linkedin.com/in/wallison-bruno-15a738123/"
						, "wbruno.costa@gmail.com")
				, "Apache License Version 4.0"
				, "https://www.apache.org", new ArrayList<VendorExtension>());
		
		return apiInfo;
	}

}
