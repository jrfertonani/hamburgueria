package hemburgueria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data   @Entity
public class Pedidos implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_pedidos_lanches",
            joinColumns = @JoinColumn(name = "pedidos"),
            inverseJoinColumns = @JoinColumn(name = "lanches"))
    private Set<Lanches> lanches = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_pedidos_bebidas",
            joinColumns = @JoinColumn(name = "pedidos"),
            inverseJoinColumns = @JoinColumn(name = "bebidas"))
    private Set<Bebidas> bebidas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "clientes")
    private Clientes clientes;


}
