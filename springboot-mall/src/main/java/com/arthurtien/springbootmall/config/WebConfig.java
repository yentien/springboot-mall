//package com.arthurtien.springbootmall.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:3000") // 允許的網頁前端域名
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允許的HTTP方法
//                .allowedHeaders("*") // 允許的標頭信息
//                .allowCredentials(true); // 允許携帶認證信息（例如Cookie）
//    }
//}
