package com.hzq.crud;

import com.hzq.springbootweb.CrudApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest(classes = CrudApplication.class)
class CrudApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        System.out.println("1111111111111111111"+dataSource.getClass()+"1111111111111111111");
        Connection connection=dataSource.getConnection();
        System.out.println("1111111111111111111"+connection+"1111111111111111111");
        connection.close();
    }

}
