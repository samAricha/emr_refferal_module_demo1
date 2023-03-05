package teka.backend.refferal_module_demo1.core.models.utils;

import jakarta.persistence.*;
import teka.backend.refferal_module_demo1.core.models.core.Encounter;

@Entity
@Table(name = "xrays")
public class Xray {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "encounter_id")
    private Encounter encounter;

    // Constructors, getters, and setters
}

