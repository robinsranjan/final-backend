package com.iprimed.voizfonica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iprimed.voizfonica.model.Dongle;


@Repository
public interface DongleRepo extends JpaRepository<Dongle, Long> {

}
