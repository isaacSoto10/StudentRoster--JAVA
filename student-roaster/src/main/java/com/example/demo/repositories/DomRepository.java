package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Dorm;

@Repository
public interface DomRepository extends CrudRepository<Dorm, Long>{
	//SELECT * FROM DLs
	List<Dorm> findAll();
}