package pl.put.poznan.transformer.logic;

/** @author Michasia
 *
 *  @version 1.0
 *  Provides methods for expanding shortcuts
 */

public class TextShortsExpand extends TextDecorator {

    /** Class constructor lol
     *
     * @param decoratedText The text we will be working with
     */
    public TextShortsExpand(TextTransformer decoratedText){
        super(decoratedText);
    }

    /** Extends selected shortcuts
     *
     *  @param text String of characters to process
     *  @return Transformed text
     */
    public String transform(String text){
        text = text.replace("prof.", "profesor").replace("Prof.", "Profesor");
        text = text.replace("np.", 	"na przyklad").replace("Np.", "Na przyklad");
        text = text.replace("dr", "doktor").replace("Dr", "Doktor");
        text = text.replace("itp.", "i tym podobne").replace("Itp.", "I tym podobne");
        return text;
    }
}
