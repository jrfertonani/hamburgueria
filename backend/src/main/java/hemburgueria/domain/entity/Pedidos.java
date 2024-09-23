package hemburgueria.domain.entity;

import hemburgueria.domain.entity.DTO.pedidoDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    //  @JsonFormat(pattern = "dd/MM/yyyy")
    //  private LocalDate dataAbertura = LocalDate.now();
    //  @JsonFormat(pattern = "dd/MM/yyyy")
    //  private LocalDate dataFechamento;


    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Integer clientes;


    @OneToMany(mappedBy = "pedidos")
    private List<Lanches> lanches = new ArrayList<>();

    public Pedidos(pedidoDTO entity) {
        super();
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.clientes = entity.getClientes();
        this.lanches = entity.getLanches();
    }

}


