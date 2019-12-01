package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        // of course normally it would to something based on transforms
        String transformedText = expand(text);
        return transformedText;
    }

    public String expand(String text) {
        text = text.replace("prof.", "profesor").replace("Prof.", "Profesor");
        text = text.replace("np.", 	"na przykład").replace("Np.", "Na przykład");
        text = text.replace("dr", "doktor").replace("Dr", "Doktor");
        text = text.replace("itp.", "i tym podobne").replace("Itp.", "I tym podobne");

        return text;
    }
}
