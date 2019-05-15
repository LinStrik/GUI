package pl.damian.Letters;

import java.util.*;


public class Letters implements Iterable<Thread> {


    ArrayList<Thread> threadArrayList;
    boolean isRunning;
    String text;


    public Letters(String text) {
        this.text = text;
        this.isRunning = true;
        this.threadArrayList = new ArrayList<>();


        for (int i = 0; i < text.length(); i++) {
            String letter = Character.toString(text.charAt(i));
            threadArrayList.add(new Thread(
                    () -> {

                        try {
                            while (isRunning) {
                                System.out.print(letter);
                                Thread.sleep(1000);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    },letter));

        }

    }

    public void start() {
        for (Thread t :
                threadArrayList) {
            t.start();

        }
    }

    public void stop() {
        this.isRunning = false;
    }

    @Override
    public Iterator<Thread> iterator() {
        return this.threadArrayList.iterator();
    }


}
