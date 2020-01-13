package pl.put.poznan.transformer.logic;

/**@author Beata
 *
 * @version 1.1
 * provides methods for making shortcuts
 */
public class TextWordsToShorts extends TextDecorator {

    /**Class constructor
     *
     * @param decoratedText TextTransformer object with decorated text
     */
    public TextWordsToShorts(TextTransformer decoratedText){
        super(decoratedText);
    }

    /**Transforms words into shorts
     *
     * @param text String of characters to process
     * @return Transformed text
     */
    public String transform(String text){
        // Zwijanie skrotow
        // np. na przyklad --> np.
        String result;

        String textL = text.toLowerCase();
        text = text.replace("miedzy innymi", "m.in").replace("Miedzy innymi", "M.in").replace("MIEDZY INNYMI", "M.IN");
        text = text.replace("na przyklad", "np.").replace("Na przyklad", "Np.").replace("NA PRZYKLAD", "NP.");
        text = text.replace("i tak dalej", "itd.").replace("I tak dalej", "Itd.").replace("I TAK DALEJ", "ITD.");
        text = text.replace("i tym podobne", "itp.").replace("I tym podobne", "Itp.").replace("I TYM PODOBNE", "ITP.");

        textL = textL.replace("miedzy innymi", "m.in");
        textL = textL.replace("na przykład", "np.");
        textL = textL.replace("i tak dalej", "itd.");
        textL = textL.replace("i tym podobne", "itp.");

        if (textL.length() == text.length()) {
            result = text;
        }
        else {result = textL;}

        return result;
    }
}
