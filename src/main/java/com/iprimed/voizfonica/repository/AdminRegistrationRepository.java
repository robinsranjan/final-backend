package com.iprimed.voizfonica.repository;
 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iprimed.voizfonica.model.AdminRegistration;
import com.iprimed.voizfonica.model.User;


@Repository
public interface AdminRegistrationRepository extends JpaRepository<AdminRegistration, Integer> {
	
	public AdminRegistration findByEmail(String email);
	public AdminRegistration findByEmailAndPassword(String email,String password);
	public User findByPassword(String password);
//	public User findByOtp(int otp);
	List<User> findAllById(int id);
//List<User> findByEmail(String email);
	
	List<User> findAllByEmail(String email);
	//public User findById(int id);
	
	@Query("select u from User u where u.email = :email")
	public User getUserByUserName(@Param("email") String email);

}