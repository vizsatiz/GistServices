package com.gist.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {WebMVCConfig.class, HibernateConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
