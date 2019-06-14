package tyfanch.electivehelper.servlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharsetFilter", urlPatterns = {"/*"})
public class CharsetFilter implements Filter {
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws ServletException, IOException {
        System.out.println("---- CharsetFilter Start: ");

        request.setCharacterEncoding("utf-8");
        //response.setContentType("text/plain; charset=utf-8");

        chain.doFilter(request, response);

        System.out.println("---- CharsetFilter End.");
    }

    @Override
    public void init(FilterConfig config) {}
}
