package com.fakynno.expensecontrol.api.repositories;

import com.fakynno.expensecontrol.api.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
