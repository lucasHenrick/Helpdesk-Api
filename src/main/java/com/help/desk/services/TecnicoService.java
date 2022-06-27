package com.help.desk.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.help.desk.domain.Pessoa;
import com.help.desk.domain.Tecnico;
import com.help.desk.domain.dtos.TecnicoDTO;
import com.help.desk.repository.PessoaRepository;
import com.help.desk.repository.TecnicoRepository;
import java.util.List;

import com.help.desk.services.exception.DataIntegrityVioolationException;
import com.help.desk.services.exception.ObjectnotFoundException;

@Service
public class TecnicoService {

	
	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto com esse Id não encontrado"));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}
	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldObj = findById(id);
		validaPorCpfEmail(objDTO);
		oldObj = new Tecnico(objDTO);
		return repository.save(oldObj);
	}
	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityVioolationException("Tecnico Possui ordens de serviço e não pode ser deletado!");
		}
		repository.deleteById(id);
	}
	private void validaPorCpfEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());		
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityVioolationException("CPF já Cadastrado no sistema");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		
		if (obj.isPresent() && obj.get().getId() != objDTO.getId() ) {
			throw new DataIntegrityVioolationException("E-mail já Cadastrado no sistema");
		}
				
	}


	
}


