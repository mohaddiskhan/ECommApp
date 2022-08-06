package com.examlpe.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.example.demo.entities.ContactsMasterEntity;
import com.example.demo.repositories.ContactsMasterRepo;

@SpringBootApplication(scanBasePackages={"com.*"})
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataJpaApplication.class, args);
		ContactsMasterRepo repoBean=ctx.getBean(ContactsMasterRepo.class);
		System.out.println("Proxy class generated for CrudRepo Interface --"
		+repoBean.getClass().getName());
		
		String[] allBeanNames = ctx.getBeanDefinitionNames();
		for(String name: allBeanNames) {
			System.out.println(name);
		}
		
		ContactsMasterEntity entity=new ContactsMasterEntity()	;
		entity.setContactId(101);
		entity.setContactName("mohaddis");
		entity.setContactNumber(9907360608L);
		
		repoBean.save(entity);
		ctx.close();
	}

}
