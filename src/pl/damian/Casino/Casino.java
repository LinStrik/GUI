package pl.damian.Casino;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Casino implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int lastNumber = -1;
            int inARow = 1;


            @Override
            public boolean hasNext() {
                return inARow<3;
            }

            @Override
            public Integer next() {
                if(!this.hasNext()){
                    throw new NoSuchElementException();
                }
                int newNumber = (int)Math.round(Math.random());
                if(lastNumber != newNumber){
                    inARow = 1;
                }else{
                    inARow++;
                }

                lastNumber = newNumber;

                return lastNumber;
            }
        };
    }
}
