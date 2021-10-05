package com.nelito.signup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelito.signup.model.Login;

@Repository
public interface loginRepo extends JpaRepository<Login, Long> {
	
	public List<Login>  findByUsername(String username);

}
