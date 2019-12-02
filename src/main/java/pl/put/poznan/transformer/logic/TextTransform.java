package pl.put.poznan.transformer.logic;


// Concrete Component
public class TextTransform implements TextTransformer{

    public String transform(String text){
        // Does nothing, returns text
        return text;
    }
}
