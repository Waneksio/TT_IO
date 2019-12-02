package pl.put.poznan.transformer.logic;

public class TextShortsExpand extends TextDecorator {

    public TextShortsExpand(TextTransformer decoratedText){
        super(decoratedText);
    }

    public String transform(String text){
        // Rozwijanie skrotow
        // np. prof. --> profesor
        text = text.replace("prof.", "profesor").replace("Prof.", "Profesor");
        text = text.replace("np.", 	"na przykład").replace("Np.", "Na przykład");
        text = text.replace("dr", "doktor").replace("Dr", "Doktor");
        text = text.replace("itp.", "i tym podobne").replace("Itp.", "I tym podobne");
        return text;
    }
}
