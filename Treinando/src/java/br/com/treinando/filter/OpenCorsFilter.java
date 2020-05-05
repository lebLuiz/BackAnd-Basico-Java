package br.com.treinando.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = "/*") // Coloque só os padrões que você quer abrir o CORS.
public class OpenCorsFilter implements Filter {

    public OpenCorsFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        authorizeCrossDomain((HttpServletResponse) response);
        chain.doFilter(request, response);
    }

    public static void authorizeCrossDomain(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        resp.setHeader("Access-Control-Allow-Headers", "Authentication, Content-Type, X-Requested-With, X-Codingpedia");
        resp.setHeader("Access-Control-Max-Age", "86400");
    }
}
