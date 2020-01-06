package pl.put.poznan.transformer.logic;

/**@author PanPastwa
 *
 * @version 1.0
 * Component that does nothing
 */
public class TextTransform implements TextTransformer{

    /** The transform method
     *
     * @param text String of characters to process
     * @return The original text
     */
    public String transform(String text){
        return text;
    }
}
