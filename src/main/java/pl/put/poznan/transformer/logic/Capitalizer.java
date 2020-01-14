package pl.put.poznan.transformer.logic;

/**@author Michasia
 *
 * @version 1.0
 * provides methods for capitalizing words in text
 */

public class Capitalizer extends TextDecorator{

    /**class constructor
     *
     * @param decoratedText the text we will be working with
     */
    public Capitalizer(TextTransformer decoratedText) { super(decoratedText); }

    /**Capitalizes every single word in the input text
     *
     * @param text String of characters to process
     * @return Transformed text
     */
    public String transform(String text) {
        String words[] = text.split("\\s");
        String capitalized="";
        for(String w: words) {
            capitalized += w.substring(0,1).toUpperCase() + w.substring(1).toLowerCase()+" ";
        }
        return capitalized;
    }
}
