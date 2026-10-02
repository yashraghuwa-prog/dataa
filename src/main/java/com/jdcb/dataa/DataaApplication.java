package com.jdcb.dataa;

import com.jdcb.dataa.model.student;
import com.jdcb.dataa.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DataaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DataaApplication.class, args);

		student student=context.getBean(student.class);

		student.setId(1);
		student.setName("hushh");
		student.setTech("c");

		StudentRepo repo=context.getBean(StudentRepo.class);
		repo.save(student);

		System.out.println(repo.findAll());
	}

}
