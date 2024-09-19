package hemburgueria.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Clientes clientes;


    @OneToMany(mappedBy = "pedidos")
    private List<Lanches> lanches = new ArrayList<>();

}


