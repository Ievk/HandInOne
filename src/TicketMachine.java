/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    // Task2 New private field of type String

    private String venue;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int price, String venue) //have to write in constructor the same amount of parameters
    {
       //initializing the private fields (task2)
        this.price = price;
        this.venue= venue;
        this.balance = 0;
        this.total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */

    // Task 3



    public Ticket printTicket()
    {
        Ticket dktTicket = null;
        if(balance >= price) {


             dktTicket = new Ticket(venue, price);

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else {
            dktTicket = new Ticket(venue, price, -1);
            System.out.println("You must insert at least: " +
                    (price - balance) + " more cents.");
        }

        if(dktTicket.isValid() == true) {
            System.out.println(dktTicket);
        }
        return dktTicket;
    }
    //task 8
    public Ticket printMultiRideTicket(int numRides)
    {
        Ticket dktTicket = null;
        if(numRides > 0){
            int totalPrice = price * numRides;

            if(balance >= totalPrice) {


                dktTicket = new Ticket(venue, price,numRides);

                // Update the total collected with the price.
                total = total + totalPrice;
                // Reduce the balance by the price.
                balance = balance - totalPrice;

            }
            else{
                dktTicket = new Ticket(venue, price,-1); // -1 will make isValid return false
                System.out.println("You must insert at least: " +
                        (totalPrice - balance) + " more cents.");
            }
        }
        else{
            System.out.println("Cannot issue a multi-ride ticket for fewer than 1 rides!");
        }
        if(dktTicket.isValid() == true) {
            System.out.println(dktTicket);
        }
        return dktTicket;
    }



    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    public static void main(String[] args) {
        TicketMachine machine = new TicketMachine(20,"Ieva's violin concert");
        machine.insertMoney(50);
        //machine.printTicket();
        //machine.printTicket();
       //machine.printTicket();

//USED FOR TEST
        machine.printTicket();
        machine.printTicket();
        machine.printTicket();

     //   Ticket newTicket = machine.printTicket();
     //   Ticket newTicket = machine.printMultiRideTicket(10);
     //   Ticket newTicket2 = machine.printMultiRideTicket(10);


    }
}
