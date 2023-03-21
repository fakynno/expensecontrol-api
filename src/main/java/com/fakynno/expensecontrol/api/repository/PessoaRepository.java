package com.fakynno.expensecontrol.api.repository;

import com.fakynno.expensecontrol.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
