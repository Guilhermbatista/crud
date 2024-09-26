package com.guilherme.devsuperiorAtividade.DTO;

import java.time.LocalDate;

import com.guilherme.devsuperiorAtividade.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class ClientDTO {
	private Long id;
	@Size(min = 3, max=80, message = "Nome precisa ter entre 3 a 80 caracteres")
	@NotBlank(message = "Campo Obrigatorio")
	private String name;
	private String cpf;
	private Double income;
	private LocalDate birthDate;
	private Integer children;

	public ClientDTO() {

	}

	public ClientDTO(Long id,String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public ClientDTO(Client dto) {
		id= dto.getId();
		name = dto.getName();
		cpf = dto.getCpf();
		income = dto.getIncome();
		birthDate = dto.getBirthDate();
		children = dto.getChildren();
	}

	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}

}
