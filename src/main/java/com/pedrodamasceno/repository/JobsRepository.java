package com.pedrodamasceno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrodamasceno.domain.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,Long> {

}
