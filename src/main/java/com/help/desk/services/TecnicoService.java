package com.help.desk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.desk.domain.Tecnico;
import com.help.desk.repository.TecnicoRepository;

@Service
public class TecnicoService {

	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
