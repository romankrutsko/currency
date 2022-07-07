package com.example.currency.dao;

import com.example.currency.model.Account;
import com.example.currency.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final Connection connection;

    @Autowired
    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createUser(User user) {
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into user (userName, email) values (?,?)"
        )) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserById(Integer id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user where id = " + id);
        User user = new User();
        if (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("userName"));
            user.setEmail(resultSet.getString("email"));
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        List<User> result = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("userName"));
            user.setEmail(resultSet.getString("email"));
            result.add(user);
        }
        return result;
    }

    @Override
    public void updateUserName(Integer id, String name) {
        try (PreparedStatement statement = connection.prepareStatement(
                "update user set userName = ? where id = ?"
        )) {
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserEmail(Integer id, String email) {
        try (PreparedStatement statement = connection.prepareStatement(
                "update user set email = ? where id = ?"
        )) {
            statement.setString(1, email);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int id) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("delete from account where user_id = " + id);
            statement.execute("delete from user where id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> getUserAccounts(Integer userId) throws SQLException {
        return getAccounts(userId);
    }

    @Override
    public Account getUserAccountByCurrency(Integer userId, String currencyName) throws SQLException {
        List<Account> accountList = getAccounts(userId);

        return accountList.stream().filter(acc -> acc.getCurrentCurrency().equals(currencyName)).findAny().get();
    }

    private List<Account> getAccounts(Integer userId) throws SQLException {
        List<Account> result = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from account where user_id = " + userId);

        while (resultSet.next()) {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setUserId(resultSet.getInt("user_id"));
            account.setBalance(resultSet.getDouble("balance"));
            account.setCurrentCurrency(resultSet.getString("currentCurrency"));
            result.add(account);
        }

        return result;
    }
}
