package com.mercadolivro.config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*


@Configuration
class MessageConfig : WebMvcConfigurer {

    @Bean(name = ["messageSource"])
    fun messageSource(): MessageSource {
        val source = ReloadableResourceBundleMessageSource()
        source.setBasename("classpath:messages");
        source.setDefaultEncoding("ISO-8859-1")
        source.setUseCodeAsDefaultMessage(true)
        source.setCacheSeconds(60)
        return source
    }

    @Bean
    override fun getValidator(): LocalValidatorFactoryBean? {
        val bean = LocalValidatorFactoryBean()
        bean.setValidationMessageSource(messageSource())
        return bean
    }

    @Bean
    fun localeResolver(): AcceptHeaderLocaleResolver {
        val slr = AcceptHeaderLocaleResolver()
        slr.defaultLocale = Locale("en", "US")
        return slr
    }
}