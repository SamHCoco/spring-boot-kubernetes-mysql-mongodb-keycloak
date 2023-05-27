package com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.service.impl;

import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.model.User;
import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.repository.UserRepository;
import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(@NonNull Long id) {
        return userRepository.findById((long) id);
    }

    @Override
    public User create(@NonNull User user) {
        if (!userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User update(@NonNull User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteById(@NonNull Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }
}
