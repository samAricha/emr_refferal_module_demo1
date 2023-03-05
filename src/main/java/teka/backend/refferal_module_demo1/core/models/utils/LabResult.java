package teka.backend.refferal_module_demo1.core.models.utils;

import jakarta.persistence.*;
import teka.backend.refferal_module_demo1.core.models.core.Encounter;

@Entity
@Table(name = "lab_results")
public class LabResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String result;

    @ManyToOne
    @JoinColumn(name = "encounter_id")
    private Encounter encounter;

}

