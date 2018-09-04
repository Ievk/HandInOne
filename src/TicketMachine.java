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
        if(balance >= price) {

            Ticket dktTicket = new Ticket(price,venue);

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
            return  dktTicket;

        }
        else {
          return null;
                    
        }
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
        TicketMachine machine = new TicketMachine(10,"Ieva's violin concert");
        machine.insertMoney(25);
        machine.printTicket();        
        machine.printTicket();        
        machine.printTicket();

    }
}
