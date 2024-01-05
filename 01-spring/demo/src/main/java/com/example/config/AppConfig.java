package com.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Specify {@code @Configuration} and/or {@code @Component} classes for the
     * {@linkplain #createRootApplicationContext() root application context}.
     *
     * @return the configuration for the root application context, or {@code null}
     * if creation and registration of a root context is not desired
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }


    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
