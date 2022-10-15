package com.pedrodamasceno.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pedrodamasceno.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	Users findByNome(String nome);

	Page<Users> findByNomeContainingAllIgnoringCase(@Param("nome") String nome,Pageable pageable);

	Users findByNomeAllIgnoringCase(@Param("nome") String nome);

	

}
