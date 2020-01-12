package pl.put.poznan.transformer.logic;

public class Upperer extends TextDecorator{

    public Upperer(TextTransformer decoratedText) { super(decoratedText); }

    public String transform(String text) {
        return text.toUpperCase();
    }
}