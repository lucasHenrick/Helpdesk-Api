package com.help.desk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.desk.domain.Chamado;
import com.help.desk.repository.ChamadoRepository;
import com.help.desk.services.exception.ObjectnotFoundException;

@Service
public class ChamadoService {

	
	@Autowired
	private ChamadoRepository repository;
	
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado com esse Id"));
	}
	
	
	public List<Chamado> findByAll() {
		return repository.findAll();
	}
}
