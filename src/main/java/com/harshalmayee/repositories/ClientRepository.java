package com.harshalmayee.repositories;

import com.harshalmayee.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
