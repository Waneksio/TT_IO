package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignsConverterTest {

    private SignsConverter signsConverter;

    @Before
    public void set_up(){
        signsConverter = new SignsConverter(new TextTransform());
    }

    @Test
    public void test_transform(){
        assertEquals(signsConverter.transform(""), "");
        assertEquals(signsConverter.transform("abcd"), "abcd");
        assertEquals(signsConverter.transform("a\\b"), "a\\backslashb");
        assertEquals(signsConverter.transform("a&b"), "a\\&b");
        assertEquals(signsConverter.transform("a\\&}p"), "a\\backslash\\&\\}p");
    }

}