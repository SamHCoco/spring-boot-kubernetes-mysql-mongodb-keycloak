package com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.service;

import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    User create(User user);

    User update(User user);

    void deleteById(Long id);

    List<User> listAll();

}
