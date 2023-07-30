package com.bookCatalog.bookcatalog.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookCatalog.bookcatalog.dto.CategoryDTO;
import com.bookCatalog.bookcatalog.services.CategoryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    /**
     * Obter todas as categorias com opções de paginação e ordenação.
     *
     * @param page         O número da página a ser recuperada (o padrão é 0).
     * @param linesPerPage O número de categorias por página (o padrão é 12).
     * @param direction    A direção da ordenação (o padrão é ASC).
     * @param orderBy      O campo a ser usado para a ordenação (o padrão é name).
     * @return ResponseEntity contendo uma Página de objetos CategoryDTO.
     */
    @GetMapping("/all")
    public ResponseEntity<Page<CategoryDTO>> findAll(
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value="direction", defaultValue = "ASC") String direction,
            @RequestParam(value="orderBy", defaultValue = "name") String orderBy
        ){

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<CategoryDTO> list = service.findAllPaged(pageRequest);
        return ResponseEntity.ok().body(list);
    }
    
    /**
     * Obter uma categoria específica pelo seu ID.
     *
     * @param id O ID da categoria a ser recuperada.
     * @return ResponseEntity contendo o objeto CategoryDTO.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        CategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    /**
     * Criar uma nova categoria.
     *
     * @param dto O objeto CategoryDTO contendo as informações da categoria.
     * @return ResponseEntity contendo o objeto CategoryDTO criado e a URI do novo recurso criado.
     */
    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    /**
     * Atualizar uma categoria existente.
     *
     * @param id  O ID da categoria a ser atualizada.
     * @param dto O objeto CategoryDTO atualizado.
     * @return ResponseEntity contendo o objeto CategoryDTO atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto){
        dto = service.update(id,dto);
        return ResponseEntity.ok().body(dto);
    }

    /**
     * Excluir uma categoria pelo seu ID.
     *
     * @param id O ID da categoria a ser excluída.
     * @return ResponseEntity sem conteúdo (204 No Content).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
