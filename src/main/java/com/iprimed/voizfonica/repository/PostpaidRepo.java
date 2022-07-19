package com.iprimed.voizfonica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iprimed.voizfonica.model.Postpaid;



@Repository
public interface PostpaidRepo  extends JpaRepository<Postpaid, Long>{

	public Postpaid findByPackname(String packname);
	
	public Postpaid findByPacknameAndPackbenefits(String packname, String packbenefits);
	
	
	

}
