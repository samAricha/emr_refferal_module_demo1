package teka.backend.refferal_module_demo1.core.services;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teka.backend.refferal_module_demo1.core.models.core.Person;
import teka.backend.refferal_module_demo1.core.models.core.Physician;
import teka.backend.refferal_module_demo1.core.models.core.Secretary;
import teka.backend.refferal_module_demo1.core.repositories.PersonRepository;
import teka.backend.refferal_module_demo1.core.repositories.PhysicianRepository;
import teka.backend.refferal_module_demo1.core.repositories.SecretaryRepository;

@Service
public class FakeDataService {
    private final PersonRepository personRepository;
    private final PhysicianRepository physicianRepository;
    private final SecretaryRepository secretaryRepository;
    private final Faker faker;

    @Autowired
    public FakeDataService(PersonRepository personRepository, PhysicianRepository physicianRepository, SecretaryRepository secretaryRepository) {
        this.personRepository = personRepository;
        this.physicianRepository = physicianRepository;
        this.secretaryRepository = secretaryRepository;
        this.faker = new Faker();
    }

    public void populateDatabase(int count) {
        for (int i = 0; i < count; i++) {
            // Generate fake data for Person table
            Person person = new Person();
            person.setUsername(faker.name().username());
            person.setIdNumber(faker.random().nextInt(1000000000));
            person.setGender(faker.options().option("Male", "Female"));

            // Generate fake data for Physician table
            Physician physician = new Physician();
            physician.setPerson(person);
            physician.setSpeciality(faker.options().option("Cardiology", "Dermatology", "Endocrinology"));

            // Generate fake data for Secretary table
            Secretary secretary = new Secretary();
            secretary.setPerson(person);
            secretary.setPosition(faker.options().option("Receptionist", "Administrative Assistant", "Office Manager"));

            // Save the records to the database
            personRepository.save(person);
            physicianRepository.save(physician);
            secretaryRepository.save(secretary);
        }
    }
}