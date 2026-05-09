public class Mobile extends Gadget {
    private int callingCredit;

    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        super(model, price, weight, size);
        this.callingCredit = callingCredit;
    }

    public int getCallingCredit() {
        return callingCredit;
    }

    public void addCredit(int amount) {
        if (amount > 0) {
            callingCredit = callingCredit + amount;
            System.out.println(amount + " minutes of credit added.");
        } else {
            System.out.println("Please enter a positive amount of credit.");
        }
    }

    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            callingCredit = callingCredit - duration;
        } else {
            System.out.println("Insufficient calling credit to make the call.");
        }
    }

    public void display() {
        super.display();
        System.out.println("Calling Credit: " + callingCredit + " minutes");
    }

    public String toString() {
        return "Mobile Phone\n" +
               super.toString() +
               "\nCalling Credit: " + callingCredit + " minutes";
    }
}
