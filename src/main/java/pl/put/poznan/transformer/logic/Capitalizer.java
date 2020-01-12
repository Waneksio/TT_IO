package pl.put.poznan.transformer.logic;

public class Capitalizer extends TextDecorator{

    public Capitalizer(TextTransformer decoratedText) { super(decoratedText); }

    public String transform(String text) {
        String words[] = text.split("\\s");
        String capitalized="";
        for(String w: words) {
            capitalized += w.substring(0,1).toUpperCase() + w.substring(1).toLowerCase()+" ";
        }
        return capitalized;
    }
}
