package com.alkemy.icons.icons.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;


@Service
public class ContinenteServiceImpl implements ContinenteService {

	@Autowired
	private ContinenteMapper continenteMapper;
	@Autowired
	private ContinenteRepository continenteRepository;

	public ContinenteDTO save(ContinenteDTO dto) {
		ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
		ContinenteEntity entitySave = continenteRepository.save(entity);
		ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySave);
		System.out.println("GUARDAR CONTINENTE");
		return result;
	}

		public List<ContinenteDTO> getAllContinentes() {
		List<ContinenteEntity> entities =continenteRepository.findAll();
		List<ContinenteDTO>result=continenteMapper.continenteEntityList2DTOList(entities);
		return result;
	}
		
	public void delete(Long id) {
		continenteRepository.deleteById(id);
	}

}
