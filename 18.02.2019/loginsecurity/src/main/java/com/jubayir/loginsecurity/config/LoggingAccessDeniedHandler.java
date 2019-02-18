package com.jubayir.loginsecurity.config;

import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpExchange;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public abstract class LoggingAccessDeniedHandler implements AccessDeniedHandler {

    private static Logger log = (Logger) LoggerFactory.getLogger(LoggingAccessDeniedHandler.class);



    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpServletResponse httpServletResponse, AccessDeniedException ex) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){

            log.info(auth.getName()
            + "was trying to access protected resource: "
            + request.getRequestURI());
        }
        response.sendRedirect(request.getContextPath() + "/access-denied");
    }


}
