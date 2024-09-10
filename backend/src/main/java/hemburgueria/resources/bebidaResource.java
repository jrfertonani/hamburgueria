package hemburgueria.resources;

import hemburgueria.domain.entity.Bebidas;
import hemburgueria.domain.entity.DTO.bebidaDTO;
import hemburgueria.services.bebidaService;
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
@RequestMapping("/bebidas")
public class bebidaResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private bebidaService service;


    @PostMapping
    public ResponseEntity<bebidaDTO> create(@Valid @RequestBody bebidaDTO dto) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service.create(dto).getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<bebidaDTO>> findAll(){
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream().map(
                                x -> mapper.map(x, bebidaDTO.class)
                        ).toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<bebidaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<bebidaDTO> update(@PathVariable Integer id,
                                           @Valid @RequestBody bebidaDTO dto) {
        dto.setId(id);
        Bebidas obj = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
