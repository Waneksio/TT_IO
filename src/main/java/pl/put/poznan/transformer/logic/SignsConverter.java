package pl.put.poznan.transformer.logic;
/**@author Waneksio
 *
 * @version
 * provides methods for converting special signs
 */
public class SignsConverter extends TextDecorator{

    /**Class constructor
     *
     * @param decoratedText The text we will be working with
     */
    public SignsConverter(TextTransformer decoratedText) { super(decoratedText); }

    /**Replaces signs so that LaTeX could read it
     *
     * @param text String of characters to process
     * @return Transformed text
     */
    public String transform(String text){
        text = text.replace("\\", "\\backslash");
        text = text.replace("&", "\\&");
        text = text.replace("%", "\\%");
        text = text.replace("#", "\\#");
        text = text.replace("^", "\\^");
        text = text.replace("_", "\\_");
        text = text.replace("{", "\\{");
        text = text.replace("}", "\\}");
        text = text.replace("~", "\\~");
        return text;
    }
}
