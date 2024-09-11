package hemburgueria.services;

import hemburgueria.domain.entity.Cliente;
import hemburgueria.domain.entity.DTO.clienteDTO;
import hemburgueria.repositories.clienteRepository;
import hemburgueria.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class clienteService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private clienteRepository repository;

    public Cliente create(clienteDTO dto) {
        return repository.save(
                mapper.map(dto, Cliente.class)
        );
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Integer id) {
        return repository.findById(id).orElseThrow(
       () -> new ObjectNotFoundException("Objeto não encontrado! ID: " +id)
        );
    }

    public Cliente update(Integer id, clienteDTO dto) {
        findById(id);
        return repository.save(
                mapper.map(dto, Cliente.class)
        );
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
