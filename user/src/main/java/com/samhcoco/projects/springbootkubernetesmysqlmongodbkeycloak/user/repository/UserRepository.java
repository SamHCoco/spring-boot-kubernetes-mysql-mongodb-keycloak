package com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.repository;

import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
}
