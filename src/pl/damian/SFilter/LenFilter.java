package pl.damian.SFilter;

public class LenFilter implements SFilter {

    private int minVal;

    public LenFilter(int minLen){
        this.minVal = minLen;
    }

    @Override
    public boolean test(String text) {
        return text.length()>=minVal;
    }
}
