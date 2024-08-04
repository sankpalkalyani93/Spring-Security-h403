package com.example.security_demo1_h403;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	List<Role> findByUsername(String username);
}
