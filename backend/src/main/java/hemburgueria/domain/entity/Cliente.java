package hemburgueria.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Cliente extends Pessoas implements Serializable {
    private static final long serialVersionUID = 1L;




}

