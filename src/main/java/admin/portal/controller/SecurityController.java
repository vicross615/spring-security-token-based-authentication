package admin.portal.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static admin.portal.constant.AppConstants.RESPONSE_MESSAGE_KEY;

@RestController
@RequestMapping(value="/", produces = "application/json")
public class SecurityController {


    @GetMapping("/anon")
    @PreAuthorize("isAnonymous()")
    public Map<String, Object> anonAction() {
        return new HashMap<String, Object>() {
            {
                put(RESPONSE_MESSAGE_KEY, "you are anonymous");
            }
        };
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Map<String, Object> adminAction() {
        return new HashMap<String, Object>() {
            {
                put(RESPONSE_MESSAGE_KEY, "you are admin");
            }
        };
    }

    @GetMapping("/logged")
    @PreAuthorize("isFullyAuthenticated()")
    public Map<String, Object> loggedAction() {
        return new HashMap<String, Object>() {
            {
                put(RESPONSE_MESSAGE_KEY, "you are logged");
            }
        };
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Map<String, Object> error() {
        return new HashMap<String, Object>() {
            {
                put(RESPONSE_MESSAGE_KEY, "you are not allowed to get here");
            }
        };
    }
}
