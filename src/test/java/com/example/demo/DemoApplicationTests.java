package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ResourceBundle;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

		System.out.println("nihao");
	}
	public void test(){
		System.out.println("nihao");
	}

	@Test
	public void test2(){
		ResourceBundle resource= ResourceBundle.getBundle("download");
		String url =resource.getString("sanxi.url");
		System.out.println(url);

	}

}
