package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class TextTransformTest {

    private TextTransform textTransform;
    private TextTransform mock;

    @Before
    public void set_up(){
        textTransform = new TextTransform();
        mock = mock(TextTransform.class);
        when(mock.transform("")).thenReturn("");
        when(mock.transform("abc")).thenReturn("abc");
        when(mock.transform("ninja i profesor")).thenReturn("ninja i profesor");
        when(mock.transform("udana trasformacja")).thenReturn("udana trasformacja");
    }

    @Test
    public void test_transform(){
        assertEquals(textTransform.transform(""), "");
        assertEquals(textTransform.transform("a"), "a");
        assertEquals(textTransform.transform("abcd"), "abcd");
        assertEquals(textTransform.transform("ninja i zapałki"), "ninja i zapałki");
        assertEquals(textTransform.transform("p12asd"), "p12asd");

        // Mock tests
        String result1 = mock.transform("");
        verify(mock).transform("");
        assertEquals(result1, "");

        String result2 = mock.transform("abc");
        verify(mock).transform("abc");
        assertEquals(result2, "abc");

        String result3 = mock.transform("ninja i profesor");
        verify(mock).transform("ninja i profesor");
        assertEquals(result3, "ninja i profesor");

        String result4 = mock.transform("udana trasformacja");
        verify(mock).transform("udana trasformacja");
        assertEquals(result4,"udana trasformacja");
    }

}