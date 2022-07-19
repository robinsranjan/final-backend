package com.iprimed.voizfonica.model;

import java.util.*;

import javax.persistence.*;
 
@Entity


public class UserPdf{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int orderid;
//    private Integer id;
//     
    private String email;
//     
//    private String password;
//     
//    @Column(name = "full_name")
    private String fullName;
    private String plan;
    private String expiry;
//         
//    private boolean enabled;
//     
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<Role> roles = new HashSet<>();
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public UserPdf(int orderid, String email, String fullName, String plan, String expiry, Set<Role> roles) {
		super();
		this.orderid = orderid;
		this.email = email;
		this.fullName = fullName;
		this.plan = plan;
		this.expiry = expiry;
		this.roles = roles;
	}
	public UserPdf() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getFullName() {
//		return fullName;
//	}
//
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//
//	public boolean isEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}
//
//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
//
//	public UserPdf(Integer id, String email, String password, String fullName, boolean enabled, Set<Role> roles) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.password = password;
//		this.fullName = fullName;
//		this.enabled = enabled;
//		this.roles = roles;
//	}
//
//	public UserPdf() {
//		super();
//	}
//    
// 
//    // constructors, getter and setters are not shown for brevity
//}
    
    
    
    
