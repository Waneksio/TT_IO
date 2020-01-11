package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextNumberExpandTest {

    private TextNumberExpand textNumberExpand;

    @Before
    public void set_up(){
        textNumberExpand = new TextNumberExpand(new TextTransform());
    }

    @Test
    public void test_transform(){
        assertEquals(textNumberExpand.transform(""), "");
        assertEquals(textNumberExpand.transform("abcd"), "abcd");
        assertEquals(textNumberExpand.transform("51"), "pięćdziesiątjeden");
        assertEquals(textNumberExpand.transform("22 125"), "dwadzieściadwa sto dwadzieściapięć");
        assertEquals(textNumberExpand.transform("1 2 3 11 99 888"), "jeden dwa trzy jedenaście dziewięćdziesiątdziewięć osiemset osiemdziesiątosiem");
    }

}