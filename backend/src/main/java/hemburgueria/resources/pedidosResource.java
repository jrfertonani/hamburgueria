package hemburgueria.resources;

import hemburgueria.services.pedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/pedidos")
public class pedidosResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private pedidoService service;


}
