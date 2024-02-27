package Exercise.Two;

import java.util.Scanner;

//import javafx.scene.transform.Scale;

public class BankManagementAccount {
    static Scanner scanner = new Scanner(System.in);
    static void EnterAccount(Account ac){
        System.out.println("Enter the number account: ");
        ac.setNumberAccount(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter name account: ");
        ac.setNameAccount(scanner.nextLine());
        ac.setNumberMoneyinAccount(50);
        }
    /**
     * @param args
     */
    public static void main(String args[]){
        Account a[] = null;
        int k, b, n = 0;
        long s, d, c, f;
        boolean flag = true;
        do {
            System.out.println("Your choice: ");
            System.out.println("1.Enter information of the customer\n"
                    + "2.Output information of the customer\n" + "3.To up the Money\n" + "4.Withdraw the money\n"
                    + "5.Expire\n" + "6.Chuyển khoản\n" + "Number other to exit");
            b = scanner.nextInt();
            switch (b) {
                case 1:
                    System.out.println("Enter number customer who want to enter: ");
                    n = scanner.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Customer number: " + (i+1));
                        a[i] = new Account();
                        EnterAccount(a[i]);
                        
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s\n", "Number Account", "Name Account", "Number money in Account");
                    for (int i = 0; i < n; i++) {
                        a[i].printAccount();
                    }
                    break;
                case 3:
                    System.out.println("Enter the account who customer need to up money: ");
                    s = scanner.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getNumberAccount();
                        if (s == d) {
                            System.out.println("Your choice account: " + d);
                            a[i].WithDrawMoney();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the account who customer need with draw money: ");
                    s = scanner.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getNumberAccount();
                        if (s == d) {
                            System.out.println("Your choice account: " + d);
                            a[i].WithDrawMoney();
                        }
                    }
                    break; 
                    case 5:
                        System.out.println("Enter the account who customer need to expire: ");
                        s = scanner.nextLong();
                        for (int i = 0; i < n; i++) {
                            d = a[i].getNumberAccount();
                            if (s == d) {
                                System.out.println("Your choice account: " + d);
                                a[i].Expire();
                            } else {
                                System.out.println("");
                            }
                        }
                        break;
                default:
                    System.out.println("Bye!!");
                    flag = false;
                    break;
            }   
            
        }while (flag);
        
    }
}