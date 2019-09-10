package com.xadmin.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${app.swagger.enable}")
    private boolean swaggerEnable;

    @Bean
    public Docket createRestApi() {
        List<Parameter> pars = new ArrayList<Parameter>();

//        ParameterBuilder userTokenTypeParam = new ParameterBuilder();
//        userTokenTypeParam
//                .name(WebConstants.HEADER_TOKEN_TYPE)
//                .description("bd-user-token-type")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false)
//                .build();
//
//        pars.add(userTokenTypeParam.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xadmin"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("APIs")
                .description("RESTful APIs")
                .termsOfServiceUrl("localhost")
                .version("1.0.0")
                .build();
    }
}
