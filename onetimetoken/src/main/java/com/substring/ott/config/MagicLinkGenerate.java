package com.substring.ott.config;

import java.io.IOException;

import org.springframework.security.authentication.ott.OneTimeToken;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MagicLinkGenerate implements OneTimeTokenGenerationSuccessHandler{

   private OneTimeTokenGenerationSuccessHandler successHandler = new RedirectOneTimeTokenGenerationSuccessHandler("/ott/sent"); 

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, OneTimeToken oneTimeToken)
            throws IOException, ServletException {
       String token = oneTimeToken.getTokenValue();

       //magic link bna ke user ke email per send kr sakte hai

       UriComponentsBuilder uriComponentsBuilder=UriComponentsBuilder.fromHttpUrl(UrlUtils.buildFullRequestUrl(request)); 
       uriComponentsBuilder.replacePath(request.getContextPath());
       uriComponentsBuilder.path("/login/ott");
       uriComponentsBuilder.queryParam("token", token);

       System.out.println("magic link {} : "+ uriComponentsBuilder.toUriString());

       successHandler.handle(request, response, oneTimeToken);
    }
    
}
