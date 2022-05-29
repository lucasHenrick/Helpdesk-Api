package com.help.desk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.help.desk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
