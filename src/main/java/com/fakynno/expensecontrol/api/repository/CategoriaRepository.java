package com.fakynno.expensecontrol.api.repository;

import com.fakynno.expensecontrol.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
