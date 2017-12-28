package com.standard.ssh.TransicationPoc.service;



import com.standard.ssh.TransicationPoc.dto.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.query.Query;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;


@Service
public class TeacherService implements ApplicationContextAware {


    private ApplicationContext context;

//    public void addTeacher(){
//        ComboPooledDataSource source=(ComboPooledDataSource)context.getBean("dataSource");
//        Connection conn = null;
//        PreparedStatement statement = null;
//        try {
//            conn =source.getConnection();
//            String sql = "insert into teacher (id,name) values(?,?)";
//            statement= conn.prepareStatement(sql);
//            statement.setString(1,"55");
//            statement.setString(2,"flora");
//            statement.executeUpdate();
//            conn.commit();
//        } catch (SQLException e) {
//            try {
//                conn.rollback();
//            } catch (SQLException e1) {
//
//            }
//        }finally {
//            try {
//                statement.close();
//                conn.close();
//            } catch (SQLException e) {
//
//            }
//
//        }
//    }

    public void addTeacher(String id,String name){
        SessionFactoryImpl sessionFactory = (SessionFactoryImpl)context.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Teacher teacher = new Teacher(id,name);
        session.save(teacher);
        transaction.commit();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
