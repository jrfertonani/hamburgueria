package hemburgueria.services;

import hemburgueria.domain.entity.DTO.lancheDTO;
import hemburgueria.domain.entity.DTO.pedidoDTO;
import hemburgueria.domain.entity.Pedidos;
import hemburgueria.repositories.clienteRepository;
import hemburgueria.repositories.lancheRepository;
import hemburgueria.repositories.pedidoRepository;
import hemburgueria.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pedidoService {

    @Autowired
    private ModelMapper mapper;


    @Autowired
    private pedidoRepository pedidoRepository;

    @Autowired
    private clienteRepository clienteRepository;

    @Autowired
    private lancheRepository lancheRepository;

    public Pedidos create(pedidoDTO dto) {
        return pedidoRepository.save(
                mapper.map(dto, Pedidos.class)
        );
    }

    public List<Pedidos> findAll() {
        return pedidoRepository.findAll();
    }

    public pedidoDTO findById(Integer id) {
        return mapper.map(
        pedidoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado! ID: " +id)
                ),pedidoDTO.class
        );
    }

    public Pedidos update(Integer id, lancheDTO dto) {
        findById(id);
        return pedidoRepository.save(
                mapper.map(dto, Pedidos.class)
        );
    }

    public void delete(Integer id) {
        findById(id); // Verifica se o lanche existe
        pedidoRepository.deleteById(id);
    }

}
