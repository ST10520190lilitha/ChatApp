/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp_part2;

import java.util.Scanner;

/**
 *
 * @author lilit
 */
public class Main {

    public static void main(String[] args) {

        // Scanner allows user input
        Scanner input = new Scanner(System.in);

        // Create object of Login class
        Login login = new Login();

        // Variables
        String name;
        String surname;
        String username;
        String password;
        String phone;

        boolean registered = false;

        // ================= REGISTRATION SECTION =================
        System.out.println("=== USER REGISTRATION ===");

        System.out.print("Enter a name: ");
        name = input.nextLine();

        System.out.print("Enter a surname: ");
        surname = input.nextLine();

        // LOOP until username is correct
        do {
            System.out.print("Enter a username: ");
            username = input.nextLine();

            if (!login.checkUserName(username)) {
                System.out.println("Invalid username.");
                System.out.println("Username must contain '_' and be max 5 characters.");
            }

        } while (!login.checkUserName(username));

        // LOOP until password is correct
        do {
            System.out.print("Enter password: ");
            password = input.nextLine();

            if (!login.checkPasswordComplexity(password)) {
                System.out.println("Invalid password.");
                System.out.println("Password must contain:");
                System.out.println("- 8 characters");
                System.out.println("- capital letter");
                System.out.println("- number");
                System.out.println("- special character");
            }

        } while (!login.checkPasswordComplexity(password));

        // LOOP until phone number is correct
        do {
            System.out.print("Enter Your South African phone number (+27...): ");
            phone = input.nextLine();

            if (!login.checkPhoneNumber(phone)) {
                System.out.println("Invalid phone number.");
                System.out.println("Phone number must start with +27");
            }

        } while (!login.checkPhoneNumber(phone));

        // Register user
        String response = login.registerUser(username, password, phone);

        // Display registration message
        System.out.println(response);

        // Check if registration succeeded
        if (response.contains("successfully")) {
            registered = true;
        }

        // ================= LOGIN SECTION =================
        if (registered) {

            System.out.println("\n=== USER LOGIN ===");

            System.out.print("Enter a username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            // Check login details
            boolean loggedIn = login.loginUser(loginUsername, loginPassword);

            // Display login message
            String loginMessage = login.returnLoginStatus(loggedIn);

            System.out.println(loginMessage);

        } else {

            System.out.println("Registration failed. Cannot continue to login.");

        }

        // Close scanner
        input.close();
    }
}
