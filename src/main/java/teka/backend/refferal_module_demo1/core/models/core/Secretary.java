package teka.backend.refferal_module_demo1.core.models.core;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "secretary")
public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    private String position;

}