package laptop.service.project.Services;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import laptop.service.project.Entities.Laptop;
import laptop.service.project.Exceptions.DataIntegrityViolationException;
import laptop.service.project.Repositories.LaptopRepo;

@Service
public class LaptopService {
	
	@Autowired
	private LaptopRepo laptopRepo;
	
	
	
	public Laptop saveLaptop(Laptop laptop) {
		Laptop laptop2 = null;
		try {
			laptop2 = laptopRepo.save(laptop);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Data integrity violation: "+e.getMessage());
		}
		
		return laptop2;
		
	}
	
	public List<Laptop> getAllLaptops(){
		return laptopRepo.findAll().stream().toList();
	}
	 

}
