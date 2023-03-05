package teka.backend.refferal_module_demo1.core.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import teka.backend.refferal_module_demo1.core.models.core.Secretary;

public interface SecretaryRepository extends JpaRepository<Secretary, Long>{

}