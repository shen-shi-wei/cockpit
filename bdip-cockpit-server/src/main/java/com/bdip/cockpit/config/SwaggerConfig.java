package com.bdip.cockpit.config;

import com.bdip.cockpit.controller.TokenController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ssw
 * @Date: 2021/07/08/16:31
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("authentication-x").description("认证token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数

        return new Docket(DocumentationType.SWAGGER_2)
                //页面展示信息设置
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.bdip.cockpit.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .ignoredParameterTypes(TokenController.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("cockpit 在线文档")
                .description("cockpit API")
                //版本号
                .version("1.0")
                .build();
    }

    public List<ApiKey> securitySchemes(){
        List<ApiKey> apiKeys=new ArrayList<>();
        apiKeys.add(new ApiKey("oauth2 认证","Authorization","header"));
        return apiKeys;
    }

    public List<SecurityContext> securityContexts(){
        List<SecurityContext> securityContexts=new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(securityReferences())
                .forPaths(PathSelectors.any()).build());
        return securityContexts;
    }

    public List<SecurityReference> securityReferences(){
        AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
        authorizationScopes[0]=new AuthorizationScope("global","accessEverything");
        List<SecurityReference> securityReferences=new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization",authorizationScopes));
        return securityReferences;
    }

}


