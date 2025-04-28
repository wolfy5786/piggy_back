package com.piggyback.repository;

import com.piggyback.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepositary extends JpaRepository<Driver,Integer>{

}
