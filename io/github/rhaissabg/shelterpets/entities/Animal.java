package io.github.rhaissabg.shelterpets.entities;

import java.util.Objects;

public class Animal {

	private String name;
	private String type;
	private String sex;
	private String adress;
	private int age;
	private double weight;
	private String breed;
	
	public Animal(String name, String type, String sex, String adress, int age, double weight, String breed) {
		this.name = name;
		this.type = type;
		this.sex = sex;
		this.adress = adress;
		this.age = age;
		this.weight = weight;
		this.breed = breed;
	}

	public Animal() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", type=" + type + ", sex=" + sex + ", adress=" + adress + ", age=" + age
				+ ", weight=" + weight + ", breed=" + breed + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adress, age, breed, name, sex, type, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(adress, other.adress) && age == other.age && Objects.equals(breed, other.breed)
				&& Objects.equals(name, other.name) && Objects.equals(sex, other.sex)
				&& Objects.equals(type, other.type)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}
	
}
