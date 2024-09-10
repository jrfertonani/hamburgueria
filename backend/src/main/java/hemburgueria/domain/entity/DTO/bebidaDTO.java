package hemburgueria.domain.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter     @Setter
public class bebidaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;


}
