package Tarea7;
import java.util.*;


public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            ArrayList<Employee> employees = new ArrayList<>();

            int op;
            do {
                System.out.println(" Nombre de Empleado: ");
                String employeeName = scanner.nextLine();
                System.out.println(" Edad de Empleado: ");
                int employeeAge = scanner.nextInt();
                System.out.println(" Salario de Empleado: ");
                double employeeSalary = scanner.nextDouble();
                scanner.nextLine();

                Employee employee = new Employee(employeeName, employeeAge, employeeSalary);
                System.out.println("¿Cuántas cuentas desea  para " + employeeName + "?");
                int numAccounts = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < numAccounts; i++) {
                    System.out.println(" Número de Cuenta: ");
                    long accountNumber = scanner.nextLong();
                    System.out.println("Ingrese Tipo de Cuenta (A, B o C): ");
                    char accountType = scanner.next().charAt(0);
                    scanner.nextLine();

                    BankAccount account = new BankAccount(accountNumber);
                    account.setAccountType(accountType);
                    employee.addAccount(account);
                }

                employees.add(employee);

                System.out.println("\n¿Desea añadir otro empleado? \n1.- Si  \n2.- No");
                op = scanner.nextInt();
                scanner.nextLine();
            } while (op == 1);

            int continueOp;
            do {
                System.out.println("Seleccione un empleado:");
                for (int i = 0; i < employees.size(); i++) {
                    System.out.println((i + 1) + ". " + employees.get(i).getName());
                }
                int selected = scanner.nextInt() - 1;
                scanner.nextLine();
                Employee selectedEmployee = employees.get(selected);

                System.out.println("Seleccione una cuenta:");
                for (int i = 0; i < selectedEmployee.getAccounts().size(); i++) {
                    BankAccount account = selectedEmployee.getAccounts().get(i);
                    System.out.println((i + 1) + ". Número de Cuenta: " + account.getAccountNumber() +
                            ", Tipo de Cuenta: " + account.getAccountType() + ", Saldo: $" + account.getAmount());
                }
                int accountSelected = scanner.nextInt() - 1;
                scanner.nextLine();
                BankAccount selectedAccount = selectedEmployee.getAccounts().get(accountSelected);

                System.out.println("¿Qué deseas hacer con la cuenta?");
                System.out.println("1.- Depositar ");
                System.out.println("2.- Retirar ");
                System.out.println("3.- Salir");
                op = scanner.nextInt();
                scanner.nextLine();
                switch (op) {
                    case 1:
                        selectedAccount.addMoney();
                        System.out.println("Nuevo Saldo: $" + selectedAccount.getAmount());
                        break;
                    case 2:
                        selectedAccount.withdrawMoney();
                        System.out.println("Nuevo Saldo: $" + selectedAccount.getAmount());
                        break;
                    case 3:
                        System.out.println("Tenga buen dia");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }

                System.out.println("¿Desea realizar otra operación? \n1.- Sí  \n2.- No");
                continueOp = scanner.nextInt();
                scanner.nextLine();

                if (continueOp == 2) {
                    System.out.println("Tenga buen dia");
                }
            } while (continueOp == 1);
        }
    }