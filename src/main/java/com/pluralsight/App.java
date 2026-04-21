package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the name of the file employee file to process: ");
            String fileName = scanner.nextLine();
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            System.out.print("Enter the name of the payroll file to create: ");
            String payrollFileName = scanner.nextLine();
            FileWriter writer = new FileWriter(payrollFileName);
            BufferedWriter bw = new BufferedWriter(writer);

            String line;
            br.readLine();
            bw.write("id|name|gross pay\n");
            while((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                int employeeId = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                bw.write(String.format("%d|%s|%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));
            }
            br.close();
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file employees.csv was not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        scanner.close();
    }
}
