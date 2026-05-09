public class MP3 extends Gadget {
    private int availableMemory;

    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    public int getAvailableMemory() {
        return availableMemory;
    }

    public void downloadMusic(int memoryUsed) {
        if (availableMemory >= memoryUsed) {
            availableMemory = availableMemory - memoryUsed;
            System.out.println(memoryUsed + " MB music downloaded successfully.");
            System.out.println("Remaining memory: " + availableMemory + " MB");
        } else {
            System.out.println("Not enough memory available to download music.");
        }
    }

    public void deleteMusic(int memoryFreed) {
        availableMemory = availableMemory + memoryFreed;
        System.out.println(memoryFreed + " MB music deleted successfully.");
        System.out.println("Available memory: " + availableMemory + " MB");
    }

    public void display() {
        super.display();
        System.out.println("Available Memory: " + availableMemory + " MB");
    }

    public String toString() {
        return "MP3 Player\n" +
               super.toString() +
               "\nAvailable Memory: " + availableMemory + " MB";
    }
}
