package com.pedrodamasceno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrodamasceno.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	

}
