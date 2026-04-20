package com.pluralsight;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("employees.csv");
        BufferedReader br = new BufferedReader(reader);

        String line;
        br.readLine();
        while((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");

            int employeeId = Integer.parseInt(parts[0]);
            String name = parts[1];
            double hoursWorked = Double.parseDouble(parts[2]);
            double payRate = Double.parseDouble(parts[3]);
            Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
            System.out.printf("ID: %d, Name: %s, Gross Pay: %.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
        }
    }
}
