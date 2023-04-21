package com.viet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viet.converter.courseConverter;
import com.viet.converter.newConverter;
import com.viet.dto.NewDTO;
import com.viet.dto.courseDTO;
import com.viet.repository.courseRepository;
import com.viet.repository.coursesGroupRepository;
import com.viet.services.IcourseService;
import com.viet.services.coursesGroupService;
import com.viet.entity.coursesGroupEntity;
import com.viet.entity.courseEntity;
@Service
public class courseService implements IcourseService{
	@Autowired 
	private courseRepository cR;
	@Autowired
	private courseConverter cC;
	
	@Override
	public courseDTO save(courseDTO coursedto) {
		courseEntity cE = new courseEntity();
		cE = cC.toEntity(coursedto);
		cR.save(cE);
		
		return cC.toDTO(cE);
	}
	public courseDTO update(courseDTO coursedto) {
		courseEntity cE = cR.findOne(coursedto.getId());
		courseEntity cE1 = cC.toEntity(coursedto, cE);
		cR.save(cE1);
		return cC.toDTO(cE1);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cR.delete(id);
		
	}
	public List<courseEntity> getAll() {
		// TODO Auto-generated method stub
		return cR.findAll();
		
	}
	
	
}
