package com.pedrodamasceno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrodamasceno.domain.Resumes;

@Repository
public interface ResumesRepository extends JpaRepository<Resumes, Long> {

}
