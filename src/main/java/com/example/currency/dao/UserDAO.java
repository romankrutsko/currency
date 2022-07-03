package com.example.currency.dao;

import com.example.currency.model.Account;
import com.example.currency.model.User;

import java.util.List;

public interface UserDAO {

    void createUser(User user);

    User getUserById(Integer id);

    List<User> getAllUsers();

    void updateStudent(Integer id, User user);

    void deleteUser(User user);

    List<Account> getUserAccount(Integer id);

}
