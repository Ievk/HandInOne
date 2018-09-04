public class Ticket {


    //Task 1
    //Class field
    private int price;
    private String venue ;

    // Constructor with parameters price and venue
    public Ticket(int price, String venue) {
        this.price = price;
        this.venue = venue;
    }

    //Task4
    public String toString() {

        String ticketString =
        "##################" + System.lineSeparator() +
        "# " + venue + System.lineSeparator() +
        "# Ticket" + System.lineSeparator() +
        "# " + price + " cents." +System.lineSeparator() +
        "##################";

        return ticketString;



    }


}
