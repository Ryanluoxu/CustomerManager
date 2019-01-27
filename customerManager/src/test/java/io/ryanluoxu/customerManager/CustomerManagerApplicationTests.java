package io.ryanluoxu.customerManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.ryanluoxu.customerManager.entity.CustomerInfo;
import io.ryanluoxu.customerManager.service.CustomerInfoService;
import io.ryanluoxu.customerManager.service.impl.CustomerInfoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerManagerApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAdd() {
		CustomerInfoService customerInfoService = new CustomerInfoServiceImpl();
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCustomerName("test 1");
		customerInfoService.addCustomerInfo(customerInfo);
	}

}

