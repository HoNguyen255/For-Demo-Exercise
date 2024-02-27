package Exercise.Two;

import java.text.NumberFormat;
import java.util.Scanner;

public class Account {
    private long numberAccount;
    private String nameAccount;
    private double numberMoneyinAccount;

    Scanner scanner = new Scanner(System.in);

    public Account(){

    }

    public Account(long numberAccount, String nameAccount, double numberMoneyinAccount){
        this.numberAccount = numberAccount;
        this.nameAccount = nameAccount;
        this.numberMoneyinAccount = numberMoneyinAccount;
    }

    public long getNumberAccount(){
        return numberAccount;
    }

    public String getNamAccount(){
       return nameAccount;
    }

    public double getNumberMoneyinAccount(){
        return numberMoneyinAccount;
    }

    public void setNumberAccount(long numberAccount){
        this.numberAccount = numberAccount;
    }

    public void setNameAccount(String nameAccount){
        this.nameAccount = nameAccount;
    }

    public void setNumberMoneyinAccount(double numberMoneyinAccount){
        this.numberMoneyinAccount = numberMoneyinAccount;
    }

    public String toString(){
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str = currencyEN.format(numberMoneyinAccount);
        return numberAccount+ "-" + nameAccount + "-" + numberMoneyinAccount;
    }

    public double TopUpAccount(){
        double toUp;
        System.out.println("Enter number money need to up: ");
        toUp = scanner.nextDouble();
        if(toUp >= 0){
            numberMoneyinAccount = toUp + numberMoneyinAccount;
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            String str1 = currencyFormat.format(toUp);
            System.out.println("You just to up: "+str1+"into the account.");
            
        }else{
            System.out.println("The money to up invalid");
        }
        return toUp;
    }

    public double WithDrawMoney(){
        double fee = 5;
        double draw;
        System.out.println("Enter the number money you need draw: ");
        draw = scanner.nextDouble();
        if (draw<=(numberMoneyinAccount-fee)) {

            numberMoneyinAccount = numberMoneyinAccount - (draw + fee);
            NumberFormat currencyEn = NumberFormat.getCurrencyInstance();
            String str = currencyEn.format(draw);
            System.out.println("You just draw "+str+"$ from the account. Fee of draw money is 5$");
        }else{
            System.out.println("The number money want to draw invalid!");
        }
        return WithDrawMoney();
    }

    public double Expire(){
        double interest = 0.025;
        numberMoneyinAccount = numberMoneyinAccount + numberMoneyinAccount * interest;
        NumberFormat currencFormat = NumberFormat.getCurrencyInstance();
        String str = currencFormat.format(numberMoneyinAccount);
        System.out.println("You just be "+str+"from interest one mounth");
        return numberMoneyinAccount;
    }

    void printAccount() {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(numberMoneyinAccount);
        System.out.printf("%-10d %-20s %-20s \n", numberAccount, nameAccount, str1);
    }


}
