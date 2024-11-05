package hemburgueria.resources;

import hemburgueria.domain.DTO.pedidoDTO;
import hemburgueria.services.pedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pedidos")
public class pedidoResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private pedidoService service;


    @PostMapping
    public ResponseEntity<pedidoDTO> seve(@RequestBody pedidoDTO dto) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service.create(dto).getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<pedidoDTO>> find(){
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
                                           @RequestBody pedidoDTO dto) {
        return ResponseEntity.ok().body(mapper.map(service.update(id, dto), pedidoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
