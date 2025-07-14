//package com.lavs.model.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.lavs.model.Model.EmpModel;
//import com.lavs.model.dto.EmpDTO;
//import com.lavs.model.service.EmpService;
//
//@RestController
//
//public class EmpController {
//
//	@Autowired
//	private EmpService service;
//	
//	@PostMapping("post")
//	public EmpDTO createEmp(@RequestBody EmpModel emp) {
//		EmpDTO saveEmp = service.saveEmp(emp);
//		return saveEmp;
//		//return ResponseEntity.status(HttpStatus.OK).body(saveEmp);
//	}
//	
//	@GetMapping("gets")
//	public ResponseEntity getAllEmps() {
//		List<EmpDTO> allEmps = service.getAllEmps();
//		return ResponseEntity.status(HttpStatus.OK).body(allEmps);
//	}
//}


package com.lavs.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lavs.model.Model.ApiResponse;
import com.lavs.model.Model.EmpModel;
import com.lavs.model.dto.EmpDTO;
import com.lavs.model.service.EmpService;

@RestController

public class EmpController {

	@Autowired
	private EmpService service;
	
//	@PostMapping("/save")
//	public ResponseEntity<Map<String,Object>> saveEmp(@RequestBody EmpModel model) {
//		 EmpDTO saveEmp = service.saveEmp(model);
//		 Map<String, Object> map=new HashMap<String, Object>();
//		 map.put("status", 200);
//		 map.put("message", "Employee saved successfully");
//		 map.put("body",saveEmp);
//		 return ResponseEntity.ok(map);
//	}
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse<EmpDTO>> saveEmp(@RequestBody EmpModel model) {
		EmpDTO saveEmp = service.saveEmp(model);
		ApiResponse<EmpDTO> response=new ApiResponse<EmpDTO>(200,"Employee saved successfully",saveEmp);
		return ResponseEntity.ok(response);
		 
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity getAll(){
		 List<EmpDTO> allEmps = service.getAllEmps();
		 return ResponseEntity.ok(allEmps);
	}
	
}
