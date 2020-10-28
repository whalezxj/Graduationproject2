package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2020/8/31
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {


        @Bean
        public Docket createDefaultApi() {
            ParameterBuilder parameterBuilder = new ParameterBuilder();
            List<Parameter> parameters = new ArrayList<Parameter>();
            parameterBuilder.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
            parameters.add(parameterBuilder.build());
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build()
                    .globalOperationParameters(parameters);
        }
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    //标题
                    .title("Spring Boot中使用Swagger2构建RESTful APIs")
                    //简介
                    .description("")
                    //服务条款
                    .termsOfServiceUrl("")
                    //作者个人信息
                    .contact(new Contact("zxj", "", "1157821253@qq.com"))
                    //版本
                    .version("1.0")
                    .build();
        }

}
