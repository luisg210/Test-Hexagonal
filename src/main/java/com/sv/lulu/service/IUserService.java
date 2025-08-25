package com.sv.lulu.service;

import com.sv.lulu.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void save(User user);

    void delete(Long id);

    User findById(Long id);

    boolean existsByUser(String username);

}
