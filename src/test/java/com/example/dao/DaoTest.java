package com.example.dao;

import com.example.entity.RedPacket;
import com.example.registry.RedPacketRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;


@WebAppConfiguration()
@Rollback(value = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/spring-context.xml",
        "file:src/main/webapp/WEB-INF/spring/spring-mybatis.xml"})
public class DaoTest  extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private RedPacketRegistry redPacketRegistry;

    @Test
    public void test(){
        final RedPacket map = redPacketRegistry.getOne(1);
        System.out.println(map);
    }
}
