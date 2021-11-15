package com.example.todolist.dao;

import com.example.todolist.model.User;
import com.example.todolist.utils.JDBCUtlis;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {

    public int registerEmployee(User employee) {
        int res=0;
        try {
            Connection con= JDBCUtlis.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO users (first_name, last_name, username, password) VALUES (?, ?, ?, ?)") ;

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            res = preparedStatement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    return res;
    }
}
