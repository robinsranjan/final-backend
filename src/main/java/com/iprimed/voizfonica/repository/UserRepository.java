package com.iprimed.voizfonica.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.iprimed.voizfonica.model.UserPdf;

 
public interface UserRepository extends JpaRepository<UserPdf, Integer>{
     
}