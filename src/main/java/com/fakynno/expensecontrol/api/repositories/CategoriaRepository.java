package com.fakynno.expensecontrol.api.repositories;

import com.fakynno.expensecontrol.api.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
