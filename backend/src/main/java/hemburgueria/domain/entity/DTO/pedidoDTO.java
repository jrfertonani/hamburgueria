package hemburgueria.domain.entity.DTO;

import hemburgueria.domain.entity.Lanches;
import hemburgueria.domain.entity.Pedidos;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class pedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    private Integer clientes;
    private List<Lanches> lanches;



    public pedidoDTO() {
        super();
    }

    public pedidoDTO(Integer id, String nome, Integer clientes, List<Lanches> lanches) {
        this.id = id;
        this.nome = nome;
        this.clientes = clientes;
        this.lanches = lanches;
    }

    public pedidoDTO(Pedidos entity) {
        super();
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.clientes = entity.getClientes();
        this.lanches = entity.getLanches();
    }


}
