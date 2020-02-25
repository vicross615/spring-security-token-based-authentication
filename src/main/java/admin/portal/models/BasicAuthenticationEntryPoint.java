package admin.portal.models;

import com.google.gson.Gson;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static admin.portal.constant.AppConstants.RESPONSE_MESSAGE_KEY;

public class BasicAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private Gson gson;

    public BasicAuthenticationEntryPoint(Gson gson) {
        this.gson = gson;
    }



    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.addHeader("Content-type", "Application/json");

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS, PUT, POST, HEAD,DELETE, PATCH");
        httpServletResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, X-Auth-Token, X-Csrf-Token, WWW-Authenticate, Authorization");


        httpServletResponse.getWriter().println(this.gson.toJson(new HashMap<String, String>() {{
            put(RESPONSE_MESSAGE_KEY, "invalid credential");
        }}));
    }








}
