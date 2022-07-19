 package com.iprimed.voizfonica.repository;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iprimed.voizfonica.model.usersMessage;


@Repository
public interface usersMessageRepository extends JpaRepository<usersMessage, Long> {

}
