package com.renanpalmeira.spring.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.renanpalmeira.spring.model.User;
import com.renanpalmeira.spring.resource.UserResource;
import com.renanpalmeira.spring.controller.UserController;

public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {

    public UserResourceAssembler() {
        super(UserController.class, UserResource.class);
    }

    @Override
    public UserResource toResource(User user) {
        UserResource resource = instantiateResource(user);
        resource.setName(user.getName());
        resource.add(new Link(user.getReposUrl()));

        return resource;
    }
}