package it.mamino84.example.spring.webflux.server;

public class Employee {

	private String name;
	private String surname;

	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String toString() {
		return "NAME: " + name + " - SURNAME: " + surname;
	}
}
