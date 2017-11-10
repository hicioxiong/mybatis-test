package com.suning;

import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.suning.dao.UserDao;
import com.suning.domain.User;

/**
 * Hello world!
 * 
 */
public class App {
    
    public static void main(String[] args) {
//        addUser();
//        findUserById();
        findAllUser();
        
    }
    
    public static void findUserById() {
        SqlSession sqlSession = getSessionFactory().openSession();  
        UserDao userMapper = sqlSession.getMapper(UserDao.class);  
        User user = userMapper.findUserById(4);  
        System.out.println(user.getName());
    }
    
    public static void findAllUser() {
        SqlSession sqlSession = getSessionFactory().openSession();  
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = userMapper.findAllUsers();
        System.out.println(userList.size());
    }
    
    
    public static void addUser() {
        
        User user = new User();
        user.setName("hicio");
        user.setPassword("123456");
        user.setAge(22);
        SqlSession sqlSession = getSessionFactory().openSession();  
        UserDao userMapper = sqlSession.getMapper(UserDao.class); 
        int num = userMapper.insert(user);
        sqlSession.commit();
        System.out.println(num);
    }
    
    //Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {  
        SqlSessionFactory sessionFactory = null;  
        String resource = "configuration.xml";  
        try {  
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return sessionFactory;  
    }  
}
