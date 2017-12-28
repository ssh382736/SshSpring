package com.standard.ssh.TransicationPoc.service;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class TeacherService implements ApplicationContextAware {


    private ApplicationContext context;

    public void addTeacher(){
        ComboPooledDataSource source=(ComboPooledDataSource)context.getBean("dataSource");
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn =source.getConnection();
            String sql = "insert into teacher (id,name) values(?,?)";
            statement= conn.prepareStatement(sql);
            statement.setString(1,"55");
            statement.setString(2,"flora");
            statement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {

        }finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {

            }

        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
