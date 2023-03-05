package teka.backend.refferal_module_demo1.core.models.utils;

import jakarta.persistence.*;
import lombok.Data;
import teka.backend.refferal_module_demo1.core.models.core.Encounter;

@Data
@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int dosage;

    @ManyToOne
    @JoinColumn(name = "encounter_id")
    private Encounter encounter;


}