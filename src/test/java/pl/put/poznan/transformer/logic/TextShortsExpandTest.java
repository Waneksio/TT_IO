package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextShortsExpandTest {

    private TextShortsExpand textShortsExpand;

    @Before
    public void set_up(){ textShortsExpand = new TextShortsExpand(new TextTransform());
    }

    @Test
    public void test_transform(){
        assertEquals(textShortsExpand.transform(""), "");
        assertEquals(textShortsExpand.transform("abcd"), "abcd");
        assertEquals(textShortsExpand.transform("Pan Prof. spóźnił się na zajęcia."), "Pan Profesor spóźnił się na zajęcia.");
        assertEquals(textShortsExpand.transform("dr Ninja"), "doktor Ninja");
        assertEquals(textShortsExpand.transform("prof., dr itp."), "profesor, doktor i tym podobne");
    }
}