package laptop.service.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import laptop.service.project.Entities.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Long> {

}
