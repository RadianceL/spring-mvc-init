package com.example.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/spring-context.xml",
        "file:src/main/webapp/WEB-INF/spring/spring-mybatis.xml"})
public class DaoTest {



}
