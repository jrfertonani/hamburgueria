package hemburgueria.domain.entity.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hemburgueria.domain.entity.Clientes;
import hemburgueria.domain.entity.Pedidos;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import javax.swing.event.ListDataEvent;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class clienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;


    private List<String> pedidos;

    public clienteDTO() {
        super();
    }

    public clienteDTO(Clientes obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
    }
}