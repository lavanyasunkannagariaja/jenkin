//  package com.lavs.model.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.lavs.model.Model.EmpModel;
//import com.lavs.model.dto.EmpDTO;
//import com.lavs.model.repo.EmpRepo;
//
//@Service
//public class EmpService {
//
//	@Autowired
//	private EmpRepo emprepo;
//	
//	@Autowired
//	private ModelMapper mapper;
//	
//	public EmpDTO saveEmp(EmpModel emp) {
//		/*
//		 * EmpModel map = mapper.map(empDto, EmpModel.class); return
//		 * mapper.map(emprepo.save(map), EmpDTO.class);
//		 */
//		
//		EmpModel empmodel = emprepo.save(emp);
//		EmpDTO map = mapper.map(empmodel, EmpDTO.class);
//		return map;
//	
//		
//	}
//		public List<EmpDTO> getAllEmps(){
//			List<EmpModel> emplist=emprepo.findAll();
//			return emplist.stream().map(emp->mapper.map(emp,EmpDTO.class)).collect(Collectors.toList());
//		}
//}




  package com.lavs.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavs.model.Model.EmpModel;
import com.lavs.model.dto.EmpDTO;
import com.lavs.model.repo.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;
	@Autowired
	private ModelMapper mapper;
	
	public EmpDTO saveEmp(EmpModel model) {
		 EmpModel save = repo.save(model);
//		 EmpDTO dto=new EmpDTO();
//		 dto.setName(save.getName());
//		 return dto;
		 EmpDTO map = mapper.map(save, EmpDTO.class);
		 return map;
	}
	
	public List<EmpDTO> getAllEmps(){
		List<EmpModel> all = repo.findAll();
		return all.stream().map(i->mapper.map(i, EmpDTO.class)).collect(Collectors.toList());	
	}
}

