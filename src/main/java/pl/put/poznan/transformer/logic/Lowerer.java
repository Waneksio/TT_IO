package pl.put.poznan.transformer.logic;

public class Lowerer extends TextDecorator {

    public Lowerer(TextTransformer decoratedText) { super(decoratedText); }

    public String transform(String text) {
        return text.toLowerCase();
    }
}
