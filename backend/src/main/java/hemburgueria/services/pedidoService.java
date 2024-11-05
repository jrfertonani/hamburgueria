package hemburgueria.services;

import hemburgueria.domain.DTO.pedidoDTO;
import hemburgueria.domain.entity.Pedidos;
import hemburgueria.repositories.pedidoRepository;
import hemburgueria.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class pedidoService {

    @Autowired
    private ModelMapper mapper;


    @Autowired
    private pedidoRepository repository;


    public Pedidos create(pedidoDTO dto) {
        return repository.save(
                mapper.map(dto, Pedidos.class)
        );
    }



    public List<Pedidos> findAll() {
        return repository.findAll();
    }

    public pedidoDTO findById(Integer id) {
        return mapper.map(
                repository.findById(id)
    .orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado! ID: " +id)
    ),pedidoDTO.class
        );
    }

    public pedidoDTO update(Integer id, pedidoDTO dto) {
        Optional<Pedidos> pedidoOptional = repository.findById(id);

        // Verifica se o pedido existe
        if (pedidoOptional.isPresent()) {
            Pedidos pedido = pedidoOptional.get();
            // Copia as propriedades do DTO para a entidade (evita NullPointerExceptions)
            BeanUtils.copyProperties(dto, pedido, "id"); // Ignora o ID para evitar sobrescrever

            return mapper.map(repository.save(pedido), pedidoDTO.class);
        } else {
            throw new ObjectNotFoundException("Pedido não encontrado");
        }
    }

    public void delete(Integer id) {
        findById(id); // Verifica se o pedido existe
        repository.deleteById(id);
    }

}
