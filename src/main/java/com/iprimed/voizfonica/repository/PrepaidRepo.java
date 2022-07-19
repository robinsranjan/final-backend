package com.iprimed.voizfonica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iprimed.voizfonica.model.Prepaid;

@Repository
public  interface PrepaidRepo  extends JpaRepository<Prepaid, Long>{

	public Prepaid findByPackname(String packname);
	
	public Prepaid findByPacknameAndPackbenefits(String packname, String packbenefits);
	
	
}
