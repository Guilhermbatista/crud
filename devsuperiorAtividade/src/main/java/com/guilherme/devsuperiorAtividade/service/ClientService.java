package com.guilherme.devsuperiorAtividade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guilherme.devsuperiorAtividade.DTO.ClientDTO;
import com.guilherme.devsuperiorAtividade.Exceptions.ResourceNotFoundException;
import com.guilherme.devsuperiorAtividade.Repositories.ClientRepository;
import com.guilherme.devsuperiorAtividade.entities.Client;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> result = repository.findAll(pageable);
		return result.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		return new ClientDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NOT FOUND")));
	}

	@Transactional
	public ClientDTO insert(ClientDTO data) {
		Client client = new Client(data);
		return new ClientDTO(repository.save(client));
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO data) {
		try {
			Client entity = repository.getReferenceById(id);
			entity = new Client(data);
			return new ClientDTO(repository.save(entity));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("ID NOT FOUND");
		}

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("ID NOT FOUND");
		}try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			
		}
		
	}
}
