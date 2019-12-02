package pl.put.poznan.transformer.logic;

// Decorator class
abstract class TextDecorator implements TextTransformer{

    TextTransformer transformed_text;

    TextDecorator(TextTransformer textTransformer){
        this.transformed_text = textTransformer;
    }

}
