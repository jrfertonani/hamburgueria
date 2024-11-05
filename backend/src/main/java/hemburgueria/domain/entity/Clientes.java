package hemburgueria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Clientes extends Pessoas implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "clientes")
    private List<Pedidos> pedidos;


}

