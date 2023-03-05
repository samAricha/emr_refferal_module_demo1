package teka.backend.refferal_module_demo1.core.models.core;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "encounter")
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Person patient;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "physician_id", nullable = false)
    private Physician physician;
}