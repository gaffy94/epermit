package com.project.epermit;

import com.project.epermit.Model.Gender;
import com.project.epermit.Model.GenderDistribution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EPermitApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void contextLoads() {
	}
	@Test
	public void getGender(){
		ResponseEntity<?> responseEntity = restTemplate.getForEntity("/management/gender",String.class);
//		Gender gender = responseEntity.getBody();
//		assertEquals("TEST PASSED",HttpStatus.OK,responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
	}
	

}
