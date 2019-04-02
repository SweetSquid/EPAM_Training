package com.finalproject.controller.filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.Locale;

public class LangFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

    }
}
