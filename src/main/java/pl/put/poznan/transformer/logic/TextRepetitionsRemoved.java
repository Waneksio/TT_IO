package pl.put.poznan.transformer.logic;

/**@author Beata
 *
 * @version 1.1
 * provides methods for making shortcuts
 */

public class TextRepetitionsRemoved extends TextDecorator {

    /**Class constructor
     *
     * @param decoratedText TextTransformer object with decorated text
     */
    public TextRepetitionsRemoved(TextTransformer decoratedText){
        super(decoratedText);
    }

    /**Remove repetitions from sentences.
     *
     * @param text String of characters to process
     * @return Transformed text
     */
    public String transform(String text){
        // Usuwanie powtórzeń
        // np. idę do do domu --> idę do domu
        String words[] = text.split(" ");
        String result = "";

        for(int i=0; i<(words.length - 1); i++){
            if(!(words[i].equals(words[i+1]))){
                result = result + " " + words[i];
            }
        }
        result = result + " " + words[words.length - 1];

        return result;
    }
}
