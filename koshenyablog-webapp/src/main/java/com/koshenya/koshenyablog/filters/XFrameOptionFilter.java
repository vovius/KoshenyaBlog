package com.koshenya.koshenyablog.filters;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * Created by sony on 2/4/2017.
 */
public class XFrameOptionFilter extends OncePerRequestFilter {

    private final static Logger LOG = Logger.getLogger(XFrameOptionFilter.class);

    private static final String XFRAMEHEADER = "X-Frame-Options";
    private static final String XFRAMEHEADERVALUE = "ALLOW-FROM http://www.koshenya.com/";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        /*if (httpServletResponse.containsHeader(XFRAMEHEADER))
            LOG.info("Found header " + XFRAMEHEADER + ": " + httpServletResponse.getHeader(XFRAMEHEADER));
        httpServletResponse.setHeader(XFRAMEHEADER, XFRAMEHEADERVALUE);*/

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
