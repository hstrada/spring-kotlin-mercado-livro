package com.mercadolivro.config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*

@Configuration
class MessageConfig {

    @Bean(name = ["messageSource"])
    fun messageSource(): MessageSource {
        val source = ReloadableResourceBundleMessageSource()
        source.setBasename("classpath:messages");
        source.setDefaultEncoding("UTF-8")
        source.setUseCodeAsDefaultMessage(true)
        source.setCacheSeconds(60)
        return source
    }

    @Bean
    fun getValidator(): LocalValidatorFactoryBean? {
        val bean = LocalValidatorFactoryBean()
        bean.setValidationMessageSource(messageSource())
        return bean
    }

    @Bean
    fun localeResolver(): SessionLocaleResolver {
        val slr = SessionLocaleResolver()
        slr.setDefaultLocale(Locale.ENGLISH)
        return slr
    }
}