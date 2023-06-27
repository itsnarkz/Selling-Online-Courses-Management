package sellingonlinecoursesmanagement.App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystem {
    private Map<String, String> regularUsers;
    private Map<String, String> adminUsers;
    private static final String FILE_PATH = "users.txt";

    public LoginSystem() {
        regularUsers = new HashMap<>();
        adminUsers = new HashMap<>();
        loadUsers();
    }

    public boolean login(String username, String password) {
        if (regularUsers.containsKey(username) && regularUsers.get(username).equals(password)) {
            return true;
        }

        if (adminUsers.containsKey(username) && adminUsers.get(username).equals(password)) {
            return true;
        }

        return false;
    }

    public boolean hasPermission(String username, String permission) {
        if (adminUsers.containsKey(username) && permission.equals("admin")) {
            return true;
        }

        return false;
    }

    public void addUser(String username, String password, String role) {
        if (role.equals("user")) {
            regularUsers.put(username, password);
        } else if (role.equals("admin")) {
            adminUsers.put(username, password);
        } else {
            System.out.println("Invalid role.");
            return;
        }

        saveUsers();
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String username = parts[0];
                String password = parts[1];
                String role = parts[2];

                if (role.equals("user")) {
                    regularUsers.put(username, password);
                } else if (role.equals("admin")) {
                    adminUsers.put(username, password);
                }

            }
        } catch (IOException e) {
            System.out.println("Error loading users from file: " + e.getMessage());
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : regularUsers.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + ":user");
                writer.newLine();
            }

            for (Map.Entry<String, String> entry : adminUsers.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + ":admin");
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
        }
    }


}
