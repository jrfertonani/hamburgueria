package hemburgueria.domain.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Cliente extends Pessoas implements Serializable {
    private static final long serialVersionUID = 1L;



}

