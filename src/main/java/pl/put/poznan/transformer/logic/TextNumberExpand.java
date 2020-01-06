package pl.put.poznan.transformer.logic;

/**@author PanPastwa
 *
 * @version 1.0
 * Provides methods for writing numbers
 */
public class TextNumberExpand extends TextDecorator {

    /**Class constructor
     * @param decoratedText The text we will be working with
     */
    public TextNumberExpand(TextTransformer decoratedText){
        super(decoratedText);
    }

    /**Changes numbers in text into words
     *
     * @param text String of characters to process
     * @return Transformed text
     */
    public String transform(String text){
        String output_string = text;
        String str = text;
        str = str.replaceAll("[^-?0-9.]+", " ");
        String[] arr = str.trim().split(" ");
        for (String s : arr) {
            String nowy_tekst = null;
            if (s.contains(".")){
                if (s.substring(s.indexOf(".")+1).length() == 1 || s.substring(s.indexOf(".")+1).length() == 2){
                    String decimal_part = zamiana(s.substring(0, s.indexOf(".")));
                    String fraction_part = zamiana(s.substring(s.indexOf(".") + 1));
                    nowy_tekst = decimal_part + " i " + fraction_part;
                    if (s.substring(s.indexOf(".") + 1).length() == 1) {
                        nowy_tekst = nowy_tekst + " dziesiatych";
                    } else if (s.substring(s.indexOf(".") + 1).length() == 2) {
                        nowy_tekst = nowy_tekst + " setnych";
                    }
                }
                else {
                    nowy_tekst = s;
                }
            }
            else {
                nowy_tekst = zamiana(s);
            }
            output_string = output_string.substring(0, output_string.indexOf(s)) + nowy_tekst +
                    output_string.substring(output_string.indexOf(s)+s.length());
        }
        return output_string;
    }

    /** Changes number to word
     *
     * @param s Number to convert
     * @return Word describing a given number
     */
    public static String zamiana(String s){

        int number_of_digits = s.length();
        int number_in_text;
        String nowy_tekst = "";
        String[] data = {"sto ", "dwiescie ", "trzysta ", "czterysta ", "piecset ",
                "szescset ", "siedemset ", "osiemset ", "dziewiecset ", "dzisiec", "dwadziescia", "trzydziesci", "czterdzisci",
                "piecdziesiat", "szescdziesiat", "siedemdziesiat", "osiemdziesiat", "dziewiecdziesiat",
                "jedenascie", "dwanascie", "trzynascie", "czternascie", "pietnascie", "szesnascie", "siedemnascie", "osiemnascie",
                "dziewietnascie", "jeden", "dwa", "trzy", "cztery", "piec", "szesc", "siedem", "osiem", "dziewiec"};

        if (number_of_digits > 3){
            return s;
        }
        if (number_of_digits == 3) {
            number_in_text = Character.getNumericValue(s.charAt(0));
            if (number_in_text != 0)
                nowy_tekst = nowy_tekst + data[number_in_text - 1];
        }
        if (number_of_digits >= 2){
            if (number_of_digits == 3)
                number_in_text = Character.getNumericValue(s.charAt(1));
            else
                number_in_text = Character.getNumericValue(s.charAt(0));
            if (number_in_text == 0){
                // cyfra dziesiatek == 0 --> pokazuje cyfre jednosci
                if (number_of_digits == 3)
                    number_in_text = Character.getNumericValue(s.charAt(2));
                else
                    number_in_text = Character.getNumericValue(s.charAt(1));
                if (number_in_text != 0) {
                    nowy_tekst = nowy_tekst + data[26 + number_in_text];
                }
            }
            else if (number_in_text == 1){
                // dziesiec, jedenascie, ...
                if (number_of_digits == 3)
                    number_in_text = Character.getNumericValue(s.charAt(2));
                else
                    number_in_text = Character.getNumericValue(s.charAt(1));
                if (number_in_text == 0)
                    nowy_tekst = nowy_tekst + "dziesiec";
                else {
                    nowy_tekst = nowy_tekst + data[17+number_in_text];
                }

            }
            else {
                nowy_tekst = nowy_tekst + data[8+number_in_text];
                if (number_of_digits == 3)
                    number_in_text = Character.getNumericValue(s.charAt(2));
                else
                    number_in_text = Character.getNumericValue(s.charAt(1));
                if (number_in_text != 0){
                    nowy_tekst = nowy_tekst + data[26+number_in_text];
                }
            }
        }
        if (number_of_digits == 1){
            // pojedyncza cyfra
            number_in_text = Character.getNumericValue(s.charAt(0));
            if (number_in_text == 0)
                nowy_tekst = nowy_tekst + "zero";
            else {
                nowy_tekst = nowy_tekst + data[26+number_in_text];
            }
        }
        return nowy_tekst;
    }
}
