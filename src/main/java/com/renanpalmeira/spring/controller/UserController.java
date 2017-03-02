package com.renanpalmeira.spring.controller;

import java.util.List;
import java.io.IOException;

import org.springframework.hateoas.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;

import com.renanpalmeira.spring.model.User;
import com.renanpalmeira.spring.service.UserService;
import com.renanpalmeira.spring.resource.UserResource;
import com.renanpalmeira.spring.resource.UserResourceAssembler;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private UserResourceAssembler assembler = new UserResourceAssembler();

    @RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<UserResource> getUser() throws IOException {

        /**
         * @see http://docs.spring.io/autorepo/docs/spring-hateoas/0.20.x/reference/html/#fundamentals.resource-assembler
         */
        User user = this.userService.findAll();

        UserResource resource = this.assembler.toResource(user);

        return new ResponseEntity(resource, HttpStatus.OK);
    }
}
