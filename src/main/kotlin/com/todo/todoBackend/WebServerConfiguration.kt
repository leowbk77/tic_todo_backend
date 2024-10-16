package com.todo.todoBackend

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/* 
    Classe de configuracão para liberar o CORS e poder testar localmente;
    Permite que a aplicação local rodando na porta 5173 faça requisições;
*/

@Configuration
class WebServerConfiguration {

    private val corsOriginPatterns: String = "http://localhost:5173" //atentar a porta que roda o react

    @Bean
    fun addCorsConfig(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                val allowedOrigins = corsOriginPatterns.split(",").toTypedArray()
                registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOriginPatterns(*allowedOrigins)
                    .allowCredentials(true)
            }
        }
    }
}