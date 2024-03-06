package Tarea7;
import java.util.*;
public class BankAccount {
    private long accountNumber;
    private double amount;
    private char accountType;
    private static final Scanner scanner = new Scanner(System.in);
    private static final double MAX_DEPOSIT_A = 50000;
    private static final double MAX_DEPOSIT_B = 100000;
    private static final double MIN_WITHDRAW_A = 1000;
    private static final double MIN_WITHDRAW_B = 5000;
    private static final double MIN_WITHDRAW_C = 10000;

    public BankAccount(long accountNumber) {
        this.accountNumber = accountNumber;
        this.amount = 0;
    }

    public void addMoney() {
        double maxDeposit = getMaxDeposit();
        System.out.println("Cantidad que deseas ingresar (máximo $" + maxDeposit + "): ");
        double employeeAddMoney = scanner.nextDouble();

        if (employeeAddMoney <= maxDeposit) {
            amount += employeeAddMoney;
            System.out.println("Se ha agregado: $" + employeeAddMoney);
        } else {
            System.out.println("Tu tipo de cuenta no te permite ingresar más de $" + maxDeposit);
        }
    }

    public void withdrawMoney() {
        double minWithdraw = getMinWithdraw();
        System.out.println("Cantidad que deseas retirar (mínimo en cuenta $" + minWithdraw + "): ");
        double employeeWithdrawMoney = scanner.nextDouble();

        if (amount >= minWithdraw && employeeWithdrawMoney >= minWithdraw) {
            amount -= employeeWithdrawMoney;
            System.out.println("Se ha retirado: $" + employeeWithdrawMoney);
        } else {
            System.out.println("No tienes cantidad suficiente para retirar o la cantidad mínima no se cumple.");
        }
    }

    private double getMaxDeposit() {
        return switch (Character.toUpperCase(accountType)) {
            case 'A' -> MAX_DEPOSIT_A;
            case 'B' -> MAX_DEPOSIT_B;
            default -> Double.MAX_VALUE;
        };
    }

    private double getMinWithdraw() {
        return switch (Character.toUpperCase(accountType)) {
            case 'A' -> MIN_WITHDRAW_A;
            case 'B' -> MIN_WITHDRAW_B;
            case 'C' -> MIN_WITHDRAW_C;
            default -> 0;
        };
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public char getAccountType() {
        return accountType;
    }

    public void setAccountType(char accountType) {
        this.accountType = accountType;
    }
    public String getAccountInfo() {
        return "Número de Cuenta: " + accountNumber + ", Tipo de Cuenta: " + accountType + ", Saldo: $" + amount;
    }

}
