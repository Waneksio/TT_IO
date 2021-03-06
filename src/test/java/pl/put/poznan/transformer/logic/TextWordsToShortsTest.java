package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextWordsToShortsTest {

    private TextWordsToShorts textWordsToShorts;

    @Before
    public void set_up(){
        textWordsToShorts = new TextWordsToShorts(new TextTransform());
    }

    @Test
    public void test_transform(){
        assertEquals(textWordsToShorts.transform(""), "");
        assertEquals(textWordsToShorts.transform("abcd"), "abcd");
        assertEquals(textWordsToShorts.transform("Miedzy innymi ninja"), "M.in ninja");
        assertEquals(textWordsToShorts.transform("Ninja na przyklad"), "Ninja np.");
        assertEquals(textWordsToShorts.transform("Na przyklad ninja i tak dalej"), "Np. ninja itd.");
    }

}