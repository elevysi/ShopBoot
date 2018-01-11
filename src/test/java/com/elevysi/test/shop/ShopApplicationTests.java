package com.elevysi.test.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.elevysi.shop.ShopApplication;
import com.elevysi.shop.config.AppConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ShopApplication.class, AppConfig.class})
public class ShopApplicationTests {

	@Test
	public void contextLoads() {
	}

}

