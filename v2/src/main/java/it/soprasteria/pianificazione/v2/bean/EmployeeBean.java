package it.soprasteria.pianificazione.v2.bean;

public class EmployeeBean {

	private String badgeNumber;
	private String name;
	private String surname;
	private String nameSurname;

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public String getBadgeNumber() {
		return badgeNumber;
	}

	public void setBadgeNumber(String budgeNumber) {
		this.badgeNumber = budgeNumber;
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

}
