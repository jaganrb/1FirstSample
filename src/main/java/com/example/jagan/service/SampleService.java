package com.example.jagan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jagan.bean.Sample;
import com.example.jagan.repo.SampleRepository;

@Service
public class SampleService {

	@Autowired
	private SampleRepository repository;
	
	public void save(Sample sample) {
		repository.save(sample);
	}
	public List<Sample> count() {
		return (List<Sample>)repository.findAll();
	}
}
