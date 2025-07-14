package com.lavs.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavs.model.Model.EmpModel;

@Repository
public interface EmpRepo extends JpaRepository<EmpModel,Long>{

}
