package teka.backend.refferal_module_demo1.core.services;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teka.backend.refferal_module_demo1.core.models.core.*;
import teka.backend.refferal_module_demo1.core.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoreFakeDataService  {


    private final PersonRepository personRepository;
    private final PhysicianRepository physicianRepository;
    private final SecretaryRepository secretaryRepository;
    private final HospitalRepository hospitalRepository;
    private final EncounterRepository encounterRepository;
    private final ObservationRepository observationRepository;
    private final Faker faker;

    @Autowired
    public CoreFakeDataService(PersonRepository personRepository,
                               PhysicianRepository physicianRepository,
                               SecretaryRepository secretaryRepository,
                               HospitalRepository hospitalRepository,
                               EncounterRepository encounterRepository,
                               ObservationRepository observationRepository) {
        this.personRepository = personRepository;
        this.physicianRepository = physicianRepository;
        this.secretaryRepository = secretaryRepository;
        this.hospitalRepository = hospitalRepository;
        this.encounterRepository = encounterRepository;
        this.observationRepository = observationRepository;
        this.faker = new Faker();
    }


    public void generateFakeData() {
        // Generate hospitals
        List<Hospital> hospitals = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Hospital hospital = new Hospital();
            hospitalRepository.save(hospital);
            hospitals.add(hospital);
        }

        // Generate persons
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Person person = new Person();
            person.setUsername(faker.name().username());
            person.setIdNumber((int)faker.number().randomNumber());
            person.setGender(faker.options().option("Male", "Female"));
            personRepository.save(person);
            persons.add(person);
        }

        // Generate physicians
        List<Physician> physicians = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Physician physician = new Physician();
            physician.setPerson(persons.get(faker.number().numberBetween(0, persons.size())));
            physician.setSpeciality(faker.options().option("Cardiologist", "Neurologist", "Pediatrician"));
            physicianRepository.save(physician);
            physicians.add(physician);
        }

        // Generate secretaries
        List<Secretary> secretaries = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Secretary secretary = new Secretary();
            secretary.setPerson(persons.get(faker.number().numberBetween(0, persons.size())));
            secretary.setPosition(faker.options().option("Receptionist", "Secretary"));
            secretaryRepository.save(secretary);
            secretaries.add(secretary);
        }

        // Generate encounters and observations
        for (int i = 0; i < 200; i++) {
            Person patient = persons.get(faker.number().numberBetween(0, persons.size()));
            Hospital hospital = hospitals.get(faker.number().numberBetween(0, hospitals.size()));
            Physician physician = physicians.get(faker.number().numberBetween(0, physicians.size()));
            //setting up encounter
            Encounter encounter = new Encounter();
            encounter.setPatient(patient);
            encounter.setHospital(hospital);
            encounter.setPhysician(physician);
            encounterRepository.save(encounter);
            //setting up observation
            for (int j = 0; j < faker.number().numberBetween(1, 10); j++) {
                Observation observation = new Observation();
                observation.setPerson(patient);
                observation.setEncounter(encounter);
                observation.setObservation(faker.lorem().word());
                observationRepository.save(observation);
            }
        }
    }


}
