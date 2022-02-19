package com.mercadolivro.config

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Configuration
class MessageConfig : WebMvcConfigurer {

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