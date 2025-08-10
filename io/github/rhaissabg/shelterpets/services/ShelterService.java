package io.github.rhaissabg.shelterpets.services;

import java.util.Scanner;

public class ShelterService {

	public String validateAndSaveName(String question, Scanner sc) {
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
					return name;
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				System.out.println("\nPlease, enter first and last name.\nUse with letters only, no numbers or special characters.");
				e.printStackTrace();
				System.out.println();
			}
		}
		return null;
	}
	
	public <E extends Enum<E>> E validateAndSaveTypeOrGender(String question, Scanner sc, Class<E> enumType, String option1, String option2) {
		while (true) {
			try {
				System.out.print(question + " ");
				String type = sc.nextLine();
				return Enum.valueOf(enumType, type.toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.printf("\nPlease, enter a valid type: %s or %s.\n", option1, option2);
			}
		}
	}
	
}
