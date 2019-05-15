package pl.damian.Transform;

public class StrToInt implements Transform<String, Integer> {

    @Override
    public Integer[] apply(String[] in) {

        Integer[] tabTmp = new Integer[in.length];

        for (int i = 0; i < tabTmp.length; i++) {
            tabTmp[i] = in[i].length();
        }

        return tabTmp;

    }

}
