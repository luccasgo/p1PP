package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Prato;
@Repository
public interface PratoDAO extends JpaRepository<Prato, Long> {

	
	

}
