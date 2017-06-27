package com.spring.data.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * <p>Title: com.spring.data.util.JdbcUtil</P>
 * author yl
 * date 2017/6/22 20:30
 * <p>Company: UBill</p>
 */
public class JdbcUtil {

    public static Connection getConnection() {
       /* String url = "jdbc:mysql://127.0.0.1:3306/spring_data";
        String username = "root";
        String pwd = "root";
        String driverClass = "com.mysql.jdbc.Driver";*/
        InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        Connection connection = null;
        try {
            properties.load(inputStream);
            String url = properties.getProperty("jdbc.url");
            String driverClass = properties.getProperty("jdbc.driver");
            String username = properties.getProperty("jdbc.username");
            String pwd = properties.getProperty("jdbc.pwd");
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet){
            try {
              if(resultSet!=null)
                resultSet.close();
              if(statement!=null)
                  statement.close();
              if(connection!=null)
                  connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


}
