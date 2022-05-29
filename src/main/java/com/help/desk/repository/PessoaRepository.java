package com.help.desk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.help.desk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
