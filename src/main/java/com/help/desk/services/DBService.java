package com.help.desk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.help.desk.domain.Chamado;
import com.help.desk.domain.Cliente;
import com.help.desk.domain.Tecnico;
import com.help.desk.enums.Perfil;
import com.help.desk.enums.Prioridade;
import com.help.desk.enums.Status;
import com.help.desk.repository.ChamadoRepository;
import com.help.desk.repository.ClienteRepository;
import com.help.desk.repository.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		Tecnico  tec1 = new Tecnico(null, "Valdir Cesar", "11696397049", "valdir@mail.com", encoder.encode("123"));
		tec1.addPerfis(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "07618493006","linus@mail.com",  encoder.encode("123"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));	
	}
}
