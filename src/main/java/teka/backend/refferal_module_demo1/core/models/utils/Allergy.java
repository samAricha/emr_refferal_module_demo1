package teka.backend.refferal_module_demo1.core.models.utils;

import jakarta.persistence.*;
import teka.backend.refferal_module_demo1.core.models.core.Patient;

public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "name")
    private String name;

    @Column(name = "severity")
    private String severity;

}



