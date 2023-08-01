package com.bookCatalog.bookcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookCatalog.bookcatalog.entities.Category;

/**
 * Repositório para a entidade Category.
 * Utiliza o Spring Data JPA para realizar operações de CRUD no banco de dados.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    // Os métodos básicos de CRUD (create, read, update, delete) são herdados
    // automaticamente do JpaRepository e não requerem documentação adicional.
}
