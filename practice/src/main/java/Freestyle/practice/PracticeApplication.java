package Freestyle.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {

		//Note that the Application context extends the Bean Factory
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		//SpringApplication.run(PracticeApplication.class, args);
//		Doctor doctor = new Doctor(); instead of this old fashioned way,we can use xml like
		 //We use xml to get the beans in the doctor class
		Doctor staff = context.getBean(Doctor.class);
		staff.assist();
		System.out.println(staff.getQualification());
	}

}
