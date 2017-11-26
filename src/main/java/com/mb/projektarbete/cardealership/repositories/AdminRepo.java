package com.mb.projektarbete.cardealership.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb.projektarbete.cardealership.config.Administrator;

public interface AdminRepo extends JpaRepository<Administrator, String> {

}
