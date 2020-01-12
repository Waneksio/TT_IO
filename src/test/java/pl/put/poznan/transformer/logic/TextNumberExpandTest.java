package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class TextNumberExpandTest {

    private TextNumberExpand textNumberExpand;
    private TextNumberExpand mock;

    @Before
    public void set_up(){
        textNumberExpand = new TextNumberExpand(new TextTransform());
        mock = mock(TextNumberExpand.class);
        when(mock.transform("")).thenReturn("");
        when(mock.transform("41")).thenReturn("czterdzieścijeden");
        when(mock.transform("abc12def")).thenReturn("abcdwanaściedef");
    }

    @Test
    public void test_transform(){

        // Unit Tests
        assertEquals(textNumberExpand.transform(""), "");
        assertEquals(textNumberExpand.transform("abcd"), "abcd");
        assertEquals(textNumberExpand.transform("51"), "pięćdziesiątjeden");
        assertEquals(textNumberExpand.transform("22 125"), "dwadzieściadwa sto dwadzieściapięć");
        assertEquals(textNumberExpand.transform("1 2 3 11 99 888"), "jeden dwa trzy jedenaście dziewięćdziesiątdziewięć osiemset osiemdziesiątosiem");

        // Mock tests
        String result1 = mock.transform("");
        verify(mock).transform("");
        assertEquals(result1, "");

        String result2 = mock.transform("41");
        verify(mock).transform("41");
        assertEquals(result2, "czterdzieścijeden");

        String result3 = mock.transform("abc12def");
        verify(mock).transform("abc12def");
        assertEquals(result3, "abcdwanaściedef");
    }

}