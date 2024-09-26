package com.guilherme.devsuperiorAtividade.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.devsuperiorAtividade.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {}
