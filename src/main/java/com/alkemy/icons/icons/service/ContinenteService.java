package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.ContinenteDTO;

import java.util.*;

public interface ContinenteService {

	ContinenteDTO save(ContinenteDTO dto);
	List<ContinenteDTO> getAllContinentes();
	void delete(Long id);
	
}
				