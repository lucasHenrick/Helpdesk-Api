package com.help.desk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.help.desk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
