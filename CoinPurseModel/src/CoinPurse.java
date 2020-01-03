import java.text.DecimalFormat;

public class CoinPurse {
    public final double PENNY = 0.01;
    public final double NICKEL = 0.05;
    public final double DIME = 0.10;
    public final double QUARTER = 0.25;

    public double penny;
    public double nickel;
    public double dime;
    public double quarter;

    //Formatter for money
    DecimalFormat format = new DecimalFormat("0.00");

    //Constructor
    public CoinPurse(double quarter, double dime, double nickel, double penny) {
        this.penny = penny;
        this.nickel = nickel;
        this.dime = dime;
        this.quarter = quarter;
    }

    //Getter for penny
    public double getPenny() {
        return this.penny;
    }

    //Setter for penny
    public void setPenny(double penny) {
        //if the value is negative, set to zero
        if(penny < 0){
            this.penny = 0;
        } else {
            this.penny = penny;
        }
    }

    public String moneyFromPennies(){
        return "Money from pennies is $" + format.format(this.penny*PENNY);
    }

    public double getNickel() {
        return this.nickel;
    }

    public void setNickel(double nickel) {
        if(nickel < 0){
            this.nickel = 0;
        } else {
            this.nickel = nickel;
        }
    }

    public String moneyFromNickels(){
        return "Money from nickles is $" + format.format(this.nickel*NICKEL);
    }

    public double getDime() {
        return this.dime;
    }

    public void setDime(double dime) {
        if(dime < 0){
            this.dime = 0;
        } else {
            this.dime = dime;
        }
    }

    public String moneyFromDimes(){
        return "Money from dimes is $" + format.format(this.dime*DIME);
    }

    public double getQuarter() {
        return this.quarter;
    }

    public void setQuarter(double quarter) {
        if(quarter < 0){
            this.quarter = 0;
        } else {
            this.quarter = quarter;
        }
    }

    public String moneyFromQuarters(){
        return "Money from quarters is $" + format.format(this.quarter*QUARTER);
    }

    //Method to return the total amount of money in a purse
    public String totalAmount(){
        double total = 0.0;
        total += (this.penny*PENNY);
        total += (this.quarter*QUARTER);
        total += (this.dime*DIME);
        total += (this.nickel*NICKEL);
        return "Total money is $" + format.format(total);
    }

    //Method to check if a purse is equal to the first purse
    public String isEqual(CoinPurse purse){
        if(purse.getQuarter() ==  this.quarter && purse.getPenny() == this.penny && purse.getNickel() == this.nickel && purse.getDime() == this.dime) {
            return "equal";
        }
        else {
            return "not equal";
        }
    }

    @Override
    public String toString() {
        return "quarters: " + (int)this.quarter +
                " dimes: " + (int)this.dime +
                " nickles: " + (int)this.nickel +
                " pennies: " + (int)this.penny;
    }
}
