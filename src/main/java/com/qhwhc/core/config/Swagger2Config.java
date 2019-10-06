package com.qhwhc.core.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.qhwhc.core.constant.DefContants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cyb
 * @since: 2019/10/2
 **/
@Slf4j
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config implements WebMvcConfigurer {

	/**
	 * 显示swagger-ui.html文档展示页，还必须注入swagger资源：
	 * doc.html： swagger增强版文档
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	/***
	 * oauth2配置
	 * 需要增加swagger授权回调地址
	 * http://localhost:8888/webjars/springfox-swagger-ui/o2c.html
	 * @return
	 */
	@Bean
	public SecurityScheme securityScheme() {
		return new ApiKey(DefContants.X_ACCESS_TOKEN, DefContants.X_ACCESS_TOKEN, "header");
	}
	/**
	 * JWT token
	 * @return
	 */
	private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name(DefContants.X_ACCESS_TOKEN).description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

	/**
	 * api文档的详细信息函数,注意这里的注解引用的是哪个
	 *
	 * @return
	 */
	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// //大标题
				.title("Dijar后台服务API接口文档")
				// 版本号
				.version("1.0")
//				.termsOfServiceUrl("NO terms of service")
				// 描述
				.description("后台API接口")
				// 作者
				.contact(new Contact("cyb","","304136830@qq.com"))
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.build();
	}

	/**
     * 接口扩展
	 * @author: cyb
	 * @since: 2019/10/2
	 **/
//    @Bean("baseApi")
//    public Docket baseApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("基础接口")
//                .apiInfo(apiInfo())
//                .select()
//                //此包路径下的类，才生成接口文档
//                .apis(RequestHandlerSelectors.basePackage("com.dijar.core"))
//                //加了ApiOperation注解的类，才生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build()
//                .securitySchemes(Collections.singletonList(securityScheme()));
//        //.globalOperationParameters(setHeaderToken());
//    }
}
