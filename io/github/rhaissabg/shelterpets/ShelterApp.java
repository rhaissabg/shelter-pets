package io.github.rhaissabg.shelterpets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import io.github.rhaissabg.shelterpets.enums.AnimalGender;
import io.github.rhaissabg.shelterpets.enums.AnimalType;
import io.github.rhaissabg.shelterpets.services.ShelterService;

public class ShelterApp {

	public static void main(String[] args) {

		ShelterService shelterService = new ShelterService();
		File file = new File("src/resources/shelter_questions.txt");
		Scanner sc = new Scanner(System.in);
		int option = -1;
		while (option != 6) {
			try {
				System.out.println("\n*** SHELTER ***");
				System.out.println("1 - Register a new pet");
				System.out.println("2 - Update registered pet data");
				System.out.println("3 - Delete a registered pet");
				System.out.println("4 - List all registered pets");
				System.out.println("5 - List pets by some criteria (age, name, breed)");
				System.out.println("6 - Exit");
				option = sc.nextInt();
				sc.nextLine();
				if (!(option >= 1 && option <= 6)) {
					System.out.println("\nPlease, enter a valid number");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nPlease, enter a number");
				sc.nextLine();
			}
			switch (option) {
			case 1:
				try {
					Scanner reader = new Scanner(file);
					
					String question = reader.nextLine();
					String name = shelterService.validateAndSaveName(question, sc);
					System.out.println(name);
					
					question = reader.nextLine();
					AnimalType type = shelterService.validateAndSaveTypeOrGender(question, sc, AnimalType.class, "dog", "cat");
					System.out.println(type);
					
					question = reader.nextLine();
					AnimalGender gender = shelterService.validateAndSaveTypeOrGender(question, sc, AnimalGender.class, "male", "female");
					System.out.println(gender);
					
					
//					boolean validType = false;
//					question = reader.nextLine();
//					while (!validType) {
//						try {
//							System.out.print(question + " ");
//							String type = sc.nextLine();
//							AnimalType typeEnum = AnimalType.valueOf(type.toUpperCase());
//							validType = true;
//						} catch (IllegalArgumentException e) {
//							System.out.println("\nPlease, enter a valid type: dog or cat.\n");
//						}
//					}
					
//					boolean validGender = false;
//					question = reader.nextLine();
//					while (!validGender) {
//						try {
//							System.out.print(question + " ");
//							String gender = sc.nextLine();
//							AnimalGender genderEnum = AnimalGender.valueOf(gender.toUpperCase());
//							validGender = true;
//						} catch (IllegalArgumentException e) {
//							System.out.println("\nPlease, enter a valid gender: male or female.\n");
//						}
//					}
					
					reader.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				break;
			}
		}

		sc.close();

	}

}