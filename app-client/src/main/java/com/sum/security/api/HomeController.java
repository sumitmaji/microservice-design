package com.sum.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@RestController
public class HomeController {

    /**
     * This api is used by kubernetes for health check monitoring.
     * @return
     */
    @GetMapping("/healthz")
    public String healthz(){
        return "OK";
    }

    /**
     * A sample api that send response of the header information it has received.
     * @param request
     * @param response
     */
    @GetMapping(value = "/echo")
    public void echo(HttpServletRequest request, HttpServletResponse response) {
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                response.setHeader(String.format("x-echo-%s", headerName.toLowerCase()), request.getHeader(headerName));
            }
        }
    }

    @Autowired
    WebClient webClient;

    /**
     * The api call a resource server to fetch details. The resource server
     * api is protected with oauth. The api passes the access token to the
     * resource server to get access to the api in the resource server.
     * @param res
     * @return
     */
    @GetMapping(value = "/welcome")
    public String welcome(HttpServletResponse res){
        String url = "http://localhost:44291/users/api/welcome";
        String block = "";
        try{
            block = webClient.get().uri(url).retrieve().bodyToMono(String.class).block();
        }catch (Exception e){
            return "{\"error\": \"Error while fetching data\", \"error_description\": \"" + e.getMessage() + "\"}";
        }
        return block;
    }
}
