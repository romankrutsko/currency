package com.example.currency.dao;

import com.example.currency.model.Account;
import com.example.currency.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    void createUser(User user);

    User getUserById(Integer id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void updateUserName(Integer id, String name);

    void updateUserEmail(Integer id, String email);

    void deleteUser(int id);

    List<Account> getUserAccounts(Integer userId) throws SQLException;

    Account getUserAccountByCurrency(Integer userId, String currencyName) throws SQLException;
}
