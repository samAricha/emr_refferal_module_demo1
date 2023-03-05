package teka.backend.refferal_module_demo1.core.models.core;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "id_number")
    private int idNumber;

    private String gender;


}