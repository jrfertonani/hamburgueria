package hemburgueria.domain.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class pedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Set<lancheDTO> lanches;
    private Set<bebidaDTO> bebidas;
    private clienteDTO cliente;
}
