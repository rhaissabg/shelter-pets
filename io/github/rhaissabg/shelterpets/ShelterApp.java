package io.github.rhaissabg.shelterpets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShelterApp {

	public static void main(String[] args) {
		
		File file = new File("src/resources/shelter_questions.txt");
		Scanner sc = new Scanner(System.in);
		try {
			Scanner reader = new Scanner(file);
			System.out.print(reader.nextLine() + " ");
			String name = sc.nextLine();
			System.out.print(reader.nextLine() + " ");
			String type = sc.next();
			System.out.print(reader.nextLine() + " ");
			String sex = sc.next();
			System.out.print(reader.nextLine() + " ");
			sc.nextLine();
			String adress = sc.nextLine();
			System.out.print(reader.nextLine() + " ");
			int age = sc.nextInt();
			System.out.print(reader.nextLine() + " ");
			double weight = sc.nextDouble();
			System.out.print(reader.nextLine() + " ");
			sc.nextLine();
			String breed = sc.nextLine();
			reader.close();
			Animal animal = new Animal(name, type, sex, adress, age, weight, breed);
			System.out.println(animal);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		sc.close();

	}

}
