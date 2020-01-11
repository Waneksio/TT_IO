package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextTransformTest {

    private TextTransform textTransform;

    @Before
    public void set_up(){
        textTransform = new TextTransform();
    }

    @Test
    public void test_transform(){
        assertEquals(textTransform.transform(""), "");
        assertEquals(textTransform.transform("a"), "a");
        assertEquals(textTransform.transform("abcd"), "abcd");
        assertEquals(textTransform.transform("ninja i zapałki"), "ninja i zapałki");
        assertEquals(textTransform.transform("p12asd"), "p12asd");
    }

}