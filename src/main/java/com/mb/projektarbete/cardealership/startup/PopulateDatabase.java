package com.mb.projektarbete.cardealership.startup;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mb.projektarbete.cardealership.cars.Brand;
import com.mb.projektarbete.cardealership.cars.Car;
import com.mb.projektarbete.cardealership.config.Administrator;
import com.mb.projektarbete.cardealership.repositories.AdminRepo;
import com.mb.projektarbete.cardealership.repositories.CarRepo;

//Populates database with some values(cars) at application startup!
@Component
public class PopulateDatabase implements ApplicationListener<ContextRefreshedEvent>{

	private CarRepo carRepo;
	private AdminRepo adminRepo;
	
	private Logger log = Logger.getLogger(PopulateDatabase.class);
	
	@Autowired
	public void setCarRepo(CarRepo carRepo) {
		this.carRepo = carRepo;
	}
	
	@Autowired
	public void setAdminRepo(AdminRepo adminRepo) {
		this.adminRepo = adminRepo;
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Car charger = new Car();
		charger.setBrand(Brand.DODGE);
		charger.setDescription("Super fast with low milage!");
		charger.setPrice(10000);
		charger.setImgUrl("/images/charger.png");
		carRepo.save(charger);
		
		log.info("Saved Charger with id: " + charger.getId());
		
		Car golf = new Car();
		golf.setBrand(Brand.VOLKSWAGEN);
		golf.setDescription("Secure and very German");
		golf.setPrice(50000);
		golf.setImgUrl("/images/golf.jpg");
		carRepo.save(golf);

		log.info("Saved Golf with id: " + golf.getId());
		
		Administrator admin1 = new Administrator("sammy", "test");
		adminRepo.save(admin1);
		log.info("Skapat admin med namn: " + admin1.getUsername() + " och lösenord: " + admin1.getPassword());
		
	}

}
