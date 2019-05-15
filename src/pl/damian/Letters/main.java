package pl.damian.Letters;

public class main {

    public static void main(String[] args) {

        Letters letters = new Letters("ABC");
        for (Thread t : letters) {
            System.out.println(t.getName() + " starting");
        }

        letters.start();
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ignore) { }

        letters.stop();
        System.out.println("\nProgram completed.");


    }

}
