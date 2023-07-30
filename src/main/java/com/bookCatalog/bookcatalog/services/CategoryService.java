/*
 * Esta classe representa a camada de serviço para gerenciar entidades de Categoria (Category).
 * Ela fornece métodos para operações CRUD (Criar, Ler, Atualizar, Deletar) em objetos de Categoria.
 */
package com.bookCatalog.bookcatalog.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookCatalog.bookcatalog.dto.CategoryDTO;
import com.bookCatalog.bookcatalog.entities.Category;
import com.bookCatalog.bookcatalog.repositories.CategoryRepository;
import com.bookCatalog.bookcatalog.services.exceptions.DatabaseException;
import com.bookCatalog.bookcatalog.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;
    
    /*
     * Recupera todas as categorias com suporte a paginação.
     *
     * @param pageRequest O objeto PageRequest contendo o número da página, tamanho da página e critérios de ordenação.
     * @return Uma Página de objetos CategoryDTO.
     */
    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {
        Page<Category> list = repository.findAll(pageRequest);
        return list.map(x -> new CategoryDTO(x));
    }
    
    /*
     * Recupera uma categoria específica pelo seu ID.
     *
     * @param id O ID da categoria a ser recuperada.
     * @return O objeto CategoryDTO representando a categoria encontrada.
     * @throws ResourceNotFoundException se nenhuma categoria com o ID fornecido for encontrada.
     */
    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new CategoryDTO(entity);
    }
    
    /*
     * Cria uma nova categoria.
     *
     * @param dto O objeto CategoryDTO contendo os dados da nova categoria.
     * @return O objeto CategoryDTO representando a categoria recém-criada.
     */
    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }
    
    /*
     * Atualiza uma categoria existente.
     *
     * @param id O ID da categoria a ser atualizada.
     * @param dto O objeto CategoryDTO contendo os dados atualizados.
     * @return O objeto CategoryDTO representando a categoria atualizada.
     * @throws ResourceNotFoundException se nenhuma categoria com o ID fornecido for encontrada.
     */
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {
            Category entity = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("ID não encontrado: " + id));
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("ID não encontrado: " + id);
        }
    }
    
    /*
     * Exclui uma categoria pelo seu ID.
     *
     * @param id O ID da categoria a ser excluída.
     * @throws ResourceNotFoundException se nenhuma categoria com o ID fornecido for encontrada.
     * @throws DatabaseException se a categoria tiver entidades relacionadas e não puder ser excluída devido a restrições de integridade do banco de dados.
     */
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("ID não encontrado: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade do banco de dados");
        }
    }
}
