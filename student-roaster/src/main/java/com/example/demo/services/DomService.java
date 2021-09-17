package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Dorm;
import com.example.demo.repositories.DomRepository;

@Service
public class DomService {
	private DomRepository DomRepo;
	
	public DomService(DomRepository domrepository) {
		this.DomRepo = domrepository;
	}
	
	public List<Dorm> getAllDom(){
		return this.DomRepo.findAll();
	}
	
	public Dorm getSingleDorm(Long id) {
		return this.DomRepo.findById(id).orElse(null);
	}
	
	public Dorm createDorm(Dorm newDorm) {
		return this.DomRepo.save(newDorm);
	}
	
	
	public void deleteDorm(long id) {
		this.DomRepo.deleteById(id);
	}
	
}
