package com.pedrodamasceno.carga;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pedrodamasceno.domain.Users;
import com.pedrodamasceno.repository.UsersRepository;

@Component
@Transactional
public class RepositoryTest implements CommandLineRunner{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public void run(String... Args) throws Exception{
		
		Users u1 = new Users("Pedro Damasceno");
		u1.setNome("Pedro Damasceno");
		u1.setEmail("pedrodamasceno@email.com");
		u1.setSenha("310300");
		
		Users u2 = new Users("Davi Diniz");
		u2.setNome("Davi Diniz");
		u2.setEmail("davidiniz@email.com");
		u2.setSenha("1458300");
		
		usersRepository.save(u1);
		usersRepository.save(u2);
	
		
	}
	
	
}
