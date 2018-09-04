public class Ticket {


    //Task 1
    //Class field
    private int price;
    private String venue ;
    private int useCount;
    private int numRides;



// Task 8
    // Constructor with parameters price and venue
    public Ticket(String venue, int price, int numRides){
        this.price = price;
        this.venue = venue;
        this.numRides = numRides;
        this.useCount = 0;
    }
    //https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
    public Ticket( String venue, int price) {
      this(venue, price, 1);
    }
        //task 5 and 9
    public boolean isValid(){
         return useCount <  numRides  ;
    }
    //task 6  and 9
    public boolean use(){
        boolean tmpValid = isValid();
        useCount++ ;
        return tmpValid;
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
