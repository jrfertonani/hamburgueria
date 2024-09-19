package hemburgueria.domain.entity.DTO;

import hemburgueria.domain.entity.Pedidos;
import lombok.Data;

import java.io.Serializable;


@Data
public class pedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    private String nomeCliente;
    private String nomeLanche;


    public pedidoDTO() {
        super();
    }

    public pedidoDTO(Pedidos obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.nomeCliente = obj.getClientes().getNome();
        this.nomeLanche = obj.getNome();
    }
}
