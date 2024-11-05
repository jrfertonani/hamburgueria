package hemburgueria.resources;

import hemburgueria.domain.entity.Clientes;
import hemburgueria.domain.DTO.clienteDTO;
import hemburgueria.services.clienteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/clientes")
public class clienteResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private clienteService service;

    @PostMapping
    private ResponseEntity<clienteDTO> create(@Valid @RequestBody clienteDTO dto) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        service.create(dto).getId()
                ).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    private ResponseEntity<List<clienteDTO>> findAll() {
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream().map(x -> mapper.map(x, clienteDTO.class))
                        .toList()
        );
    }

    @GetMapping("/{id}")
    private ResponseEntity<clienteDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(
                mapper.map(service.findById(id), clienteDTO.class));
    }

    @PutMapping("/{id}")
    private ResponseEntity<clienteDTO> update(@PathVariable Integer id,
                                           @RequestBody clienteDTO dto) {
        dto.setId(id);
        Clientes obj = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
