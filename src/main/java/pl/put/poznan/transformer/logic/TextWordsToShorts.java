package pl.put.poznan.transformer.logic;

public class TextWordsToShorts extends TextDecorator {

    public TextWordsToShorts(TextTransformer decoratedText){
        super(decoratedText);
    }

    public String transform(String text){
        // zamiana slow na skroty
        // np. na przyklad --> np.
        // todo
        // implement
        return text;
    }
}
