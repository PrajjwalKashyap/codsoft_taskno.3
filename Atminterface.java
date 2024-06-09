import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double Initialamount){
        if (Initialamount <= 0){
            System.out.println("Account balance cannot be negative.");
        }
        this.balance = Initialamount ;
    }
    public  double getBalance(){
        return balance;
    }
    public void withdraw(double amount){
        if (amount > 0 && amount <= balance ){
            balance -= amount;
            System.out.println("WithdrawAmount : " + amount);
        }
        else if (amount > balance){
            System.out.println("Insufficient Balance");
        }
        else{
            System.out.println("Amount cannot be negative");
        }
    }
    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Amount Deposited : " +amount);
        }else{
            System.out.println("Money cannot be deposited");
        }
    }
    public void checkBalance(){
        System.out.println("Current Balance : " +balance);
    }
}
     
class ATM {
        private BankAccount bal;
        
         public ATM(BankAccount bal){
            this.bal = bal ;
         }
        public void start() {
            Scanner sc = new Scanner(System.in);
            while(true){
                
                System.out.println("\nATM Menu : ");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Pullout the card");
                System.out.print("Choose an option : ");
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        bal.checkBalance();
                        break;
                    case 2:
                        System.out.println("Enter Withdrawl Amount ");
                        double withdrawAmount = sc.nextDouble();
                        bal.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Enter Deposited Amount ");
                        double depositAmount = sc.nextDouble();
                        bal.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Exiting... ");
                        sc.close();
                        return;
                    default:
                        System.out.println(" Invalid Option ");
                }
            }
        }
    }
public class Atminterface {
    public static void main(String[] args) {
        BankAccount bal = new BankAccount(1000);
        ATM atm = new ATM(bal);
        atm.start();
    }
}