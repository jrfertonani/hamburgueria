package hemburgueria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;

    @OneToMany(mappedBy = "clientes", fetch = FetchType.LAZY)
    protected List<Pedidos> pedidos = new ArrayList<>();



}

