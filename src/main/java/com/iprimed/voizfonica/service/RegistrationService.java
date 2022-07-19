package com.iprimed.voizfonica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iprimed.voizfonica.model.User;
import com.iprimed.voizfonica.repository.RegistrationRepository;


@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo;
	
	public User upUserProfe(String id, String pass) {
		User db=repo.findByEmail(id);	 
		db.setPassword(pass);
		User rd =repo.save(db);
		return rd;
		}
	
	public List<User> fetchuserList(){
		return repo.findAll();
	}
	public User saveUser(User user) {
		return repo.save(user);
		
	}
	public User fetchUserByid(String email) {
		return repo.findByEmail(email);

	}
	
	public Optional<User> fetchUserById(int id){
		return repo.findById(id);
	}
	
	public String deleteUserById(int id){
		String result;
		try {
		 repo.deleteById(id);
		 result="user deleted successfully";
		}
		catch(Exception e) {
			result="user with id is not deleted";
		}
		return result;
	}
	
	public User fetchUserByEmail(String email) {
		return repo.findByEmail(email);
		
	}
	public User fetchUserByEmailAndPassword(String email,String password) {
		return repo.findByEmailAndPassword(email, password);
		
	}
	public User getUserById(String email) {
		return repo.findByEmail(email);
	}
	
//	public User getUserByOtp(int otp) {
//		return repo.findByOtp(otp);
//	}
//	
//	public User fetchUserByOtp(int otp) {
//		return repo.findByOtp(otp);}
	
	
	
//	public User upUserProf(Integer id, User user) {
//
//		
//		 Optional<User> db= repo.findById(id); 
//		 if(db.isPresent())
//		 {
//			 User uu = db.get();
//			 uu.setPassword(user.getPassword());
//	 }
//		
//		 User uu3 = db.get();
//		 User uu4 = repo.save(uu3);
//		 return uu4;
//	
//	}
	public User fetchUserByPassword(String password) {
		// TODO Auto-generated method stub
		return repo.findByPassword(password);
	}
	
}
