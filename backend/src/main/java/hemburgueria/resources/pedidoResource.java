package hemburgueria.resources;

import hemburgueria.services.pedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/pedidos")
public class pedidoResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private pedidoService service;



}
