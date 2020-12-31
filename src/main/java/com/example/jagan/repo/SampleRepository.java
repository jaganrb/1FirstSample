package com.example.jagan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jagan.bean.Sample;

@Repository
public interface SampleRepository extends  CrudRepository<Sample, Long>{

}
