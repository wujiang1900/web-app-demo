package com.myapp.springController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriTemplate;

import com.myapp.service.UserService;
import com.myapp.domain.User;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/users")
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable("userName") String userName) {
        return userService.getUser(userName);
    }

}
