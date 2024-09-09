package hemburgueria.resources;

import hemburgueria.domain.entity.DTO.lancheDTO;
import hemburgueria.services.lancheService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/lanches")
public class lancheResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private lancheService service;


    @PostMapping
    public ResponseEntity<lancheDTO> seve(@RequestBody lancheDTO dto) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service.create(dto).getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<lancheDTO>> find(){
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream().map(x -> mapper.map(x, lancheDTO.class))
                        .toList());
    }


}