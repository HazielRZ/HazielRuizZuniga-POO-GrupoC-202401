package Tarea7;
import java.util.*;
public class Employee {   private String name;
    private int age;
    private double salary;
    private List<BankAccount> accounts;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Edad no válida");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salario no válido");
        }
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        this.accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        this.accounts.remove(account);
    }

    public String getEmployeeInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Nombre: ").append(name).append("\n");
        info.append("Edad: ").append(age).append("\n");
        info.append("Salario: ").append(salary).append("\n");
        info.append("Cuentas bancarias:\n");
        for (BankAccount account : accounts) {
            info.append(account.getAccountInfo()).append("\n");
        }
        return info.toString();
    }
}