package hemburgueria.resources;

import hemburgueria.domain.entity.DTO.lancheDTO;
import hemburgueria.domain.entity.DTO.pedidoDTO;
import hemburgueria.domain.entity.Pedidos;
import hemburgueria.services.pedidoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/pedidos")
public class pedidoResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private pedidoService service;


    @PostMapping
    public ResponseEntity<pedidoDTO> create(@RequestBody pedidoDTO dto) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service.create(dto))
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<pedidoDTO>> find() {
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream().map(x -> mapper.map(x, pedidoDTO.class))
                        .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<pedidoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(service.findById(id), pedidoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<pedidoDTO> update(@PathVariable Integer id,
                                            @RequestBody lancheDTO dto) {
        return ResponseEntity.ok().body(mapper.map(service.update(id, dto), pedidoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
