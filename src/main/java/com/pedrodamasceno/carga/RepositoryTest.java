package com.pedrodamasceno.carga;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.pedrodamasceno.domain.Users;
import com.pedrodamasceno.repository.UsersRepository;

@Component
public class RepositoryTest implements ApplicationRunner{
	
	private static final long ID_USER_PEDRO = 11l;
	private static final long ID_USER_DAVI = 22l;
	
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	 public void run(ApplicationArguments applicationArguments) throws Exception{
		
		Users u1 = new Users(ID_USER_PEDRO,"Pedro Leite","pedrodamasceno@email.com");
		
	    Users u2 = new Users(ID_USER_DAVI,"Davi Leite","davidiniz@gmail.com");
		
		
		usersRepository.saveAndFlush(u1);
		usersRepository.saveAndFlush(u2);
	
		System.out.println(">>> Gravado usuario 1: "+u1);
		System.out.println(">>> Gravado usuario 2: "+u2);
	}
	
	
}

