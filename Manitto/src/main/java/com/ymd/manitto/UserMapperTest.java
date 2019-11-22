package com.ymd.manitto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ymd.manitto.utils.StringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class UserMapperTest {
	@Autowired
	StringUtils su;
	
	@Test
	public void test() {
		 User user = su.userSelectByKakao("1200777565");
		 System.out.println(user);
	}

}
