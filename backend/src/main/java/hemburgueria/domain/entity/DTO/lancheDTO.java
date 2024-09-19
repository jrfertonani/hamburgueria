package hemburgueria.domain.entity.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hemburgueria.domain.entity.Lanches;
import hemburgueria.domain.entity.Pedidos;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class lancheDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;


    private List<String> pedidos;

    public lancheDTO() {
        super();
    }

    public lancheDTO(Lanches obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
    }
}
