package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi //开启swagger3
public class SwaggerConfig {

    //配置swagger的Bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors，配置要扫描接口的方式
                //basePackage：指定要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .build();
    }

    //配置swagger信息=apiInfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact DEFAULT_CONTACT = new Contact("JXT", "https://space.bilibili.com/48050324?spm_id_from=333.1007.0.0", "512374086@qq.com");

        return new ApiInfo("SereinXxxIN的SwaggerAPI文档",
                "一人须尽欢", "1.0",
                "https://www.cnblogs.com/", DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());

    }
}
