package hemburgueria.resources;

import hemburgueria.services.lancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/lanches")
public class lancheResource {


    @Autowired
    private lancheService service;





}

