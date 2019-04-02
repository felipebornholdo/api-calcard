package br.com.calcard.app.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String cpf;
	private Integer age;
	private String gender;
	private String maritalStatus;
	private String state;
	private BigDecimal money;
	private Integer dependent;
	private String description;
	private String creditLimit;

	public Client() {
	}

	public Client(String name, String cpf, Integer age, String gender, Integer dependent, String maritalStatus, String state, BigDecimal money) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.state = state;
		this.money = money;
		this.dependent = dependent;
	}

	public void setResult(Result result) {
		this.description = result.getDescription();
		this.creditLimit = result.getCreditLimit();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalstatus) {
		this.maritalStatus = maritalstatus;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getDependent() {
		return dependent;
	}

	public void setDependent(Integer dependent) {
		this.dependent = dependent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
}
