package pl.put.poznan.transformer.logic;

/**@author PanPastwa
 *
 * Decorator class
 * @version 1.0
 */
abstract class TextDecorator implements TextTransformer{

    TextTransformer transformed_text;

    /** Class constructor
     *
     * @param textTransformer TextTransformer object
     */
    TextDecorator(TextTransformer textTransformer){
        this.transformed_text = textTransformer;
    }

}
