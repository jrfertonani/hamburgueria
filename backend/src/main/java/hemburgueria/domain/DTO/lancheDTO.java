package hemburgueria.domain.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
public class lancheDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;



}
