package org.ping.proxy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.UUID;

@RestController
public class Entrypoint {
    @Autowired
    ProxyService service;
    private static final Logger logger = LoggerFactory.getLogger(Entrypoint.class);

    @RequestMapping("/**")
    public ResponseEntity<String> entrypoint(@RequestBody(required = false) String body, HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        String originalURL = request.getRequestURL().toString();
        logger.info(originalURL);
        return service.processProxyRequest(body,method,request,response, UUID.randomUUID().toString());
    }
}
