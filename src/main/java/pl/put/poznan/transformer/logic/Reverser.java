package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reverser extends TextDecorator{

    public Reverser(TextTransformer decoratedText) { super(decoratedText); }

    public String transform(String text) {

        String words[] = text.split("\\s");
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        String result = "";
        //System.out.println(text);
        List<Character> cList = new ArrayList<Character>();
        for(String w: words) {
            char[] tmp = w.toCharArray();
            for(char c : tmp) {
                if(Character.isUpperCase(c)) {
                    sizes.add(1);
                    cList.add(c);
                }
                else {
                    sizes.add(0);
                    cList.add(c);
                }
            }
            Collections.reverse(cList);
            //System.out.println(cList);
            for(int i = 0; i <= cList.size()-1; i++) {
                if(sizes.get(i) == 1) {
                    Character c = cList.get(i);
                    result += Character.toUpperCase(c.charValue());
                    //System.out.println(result);
                }
                else {
                    Character c = cList.get(i);
                    result += Character.toLowerCase(c.charValue());
                    //System.out.println(result);
                }
            }
            result += " ";
            cList.clear();
        }

        return result;
    }
}
