package io.github.rhaissabg.shelterpets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShelterApp {

	public static void main(String[] args) {

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
					boolean validName = false;
					while (!validName) {
						System.out.print(question + " ");
						String name = sc.nextLine();
						String[] nameParts = name.trim().split("\\s+");
						boolean hasNumberOrSpecialCharacter = false;
						for (String part : nameParts) {
							if (!part.matches("^[a-zA-Z]+$")) {
								hasNumberOrSpecialCharacter = true;
								break;
							}
						}
						try {
							if (nameParts.length > 1 && !hasNumberOrSpecialCharacter) {
								validName = true;
							} else {
								throw new IllegalArgumentException();
							}
						} catch (IllegalArgumentException e) {
							System.out.println("\nPlease, enter first and last name.\nUse with letters only, no numbers or special characters.");
							e.printStackTrace();
							System.out.println();
						}
					}
					
					
					boolean validType = false;
					question = reader.nextLine();
					while (!validType) {
						try {
							System.out.print(question + " ");
							String type = sc.nextLine();
							AnimalType typeEnum = AnimalType.valueOf(type.toUpperCase());
							validType = true;
						} catch (IllegalArgumentException e) {
							System.out.println("\nPlease, enter a valid type: dog or cat.\n");
						}
					}
					
					boolean validGender = false;
					question = reader.nextLine();
					while (!validGender) {
						try {
							System.out.print(question + " ");
							String gender = sc.nextLine();
							AnimalGender genderEnum = AnimalGender.valueOf(gender.toUpperCase());
							validGender = true;
						} catch (IllegalArgumentException e) {
							System.out.println("\nPlease, enter a valid gender: male or female.\n");
						}
					}
					
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

//				try {
//					Scanner reader = new Scanner(file);
//					boolean validName = false;
//					String name = null;
//					String question = reader.nextLine() + " ";
//					while (!validName) {
//						System.out.print(question);
//						name = sc.nextLine();
//						String[] nameParts = name.trim().split("\\s+");
//						boolean hasNumberOrSpecialCharacter = false;
//						for (int i = 0; i < nameParts.length; i++) {
//							if (!nameParts[i].matches("^[a-zA-Z\\\\s]*$")) {
//								hasNumberOrSpecialCharacter = true;
//								break;
//							}
//						}
//						if (nameParts.length < 2 || hasNumberOrSpecialCharacter) {
////							System.out.println("Please, enter first and last name and only letters!");
//							throw new IllegalArgumentException("Please, enter first and last name and only letters!");
//						} else {
//							validName = true;
//						}
//					}
//					System.out.print(reader.nextLine() + " ");
//					String type = sc.next();
//					System.out.print(reader.nextLine() + " ");
//					String sex = sc.next();
//					System.out.print(reader.nextLine() + " ");
//					sc.nextLine();
//					String adress = sc.nextLine();
//					System.out.print(reader.nextLine() + " ");
//					int age = sc.nextInt();
//					System.out.print(reader.nextLine() + " ");
//					double weight = sc.nextDouble();
//					System.out.print(reader.nextLine() + " ");
//					sc.nextLine();
//					String breed = sc.nextLine();
//					reader.close();
//					Animal animal = new Animal(name, type, sex, adress, age, weight, breed);
//					System.out.println(animal);
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}