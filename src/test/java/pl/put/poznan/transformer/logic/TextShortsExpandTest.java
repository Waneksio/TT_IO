package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class TextShortsExpandTest {

    private TextShortsExpand textShortsExpand;
    private TextShortsExpand mock;

    @Before
    public void set_up(){
        textShortsExpand = new TextShortsExpand(new TextTransform());
        mock = mock(TextShortsExpand.class);
        when(mock.transform("")).thenReturn("");
        when(mock.transform("prof.")).thenReturn("profesor");
        when(mock.transform("dr Ninja")).thenReturn("doktor Ninja");

    }

    @Test
    public void test_transform(){
        assertEquals(textShortsExpand.transform(""), "");
        assertEquals(textShortsExpand.transform("abcd"), "abcd");
        assertEquals(textShortsExpand.transform("Pan Prof. spóźnił się na zajęcia."), "Pan Profesor spóźnił się na zajęcia.");
        assertEquals(textShortsExpand.transform("dr Ninja"), "doktor Ninja");
        assertEquals(textShortsExpand.transform("prof., dr itp."), "profesor, doktor i tym podobne");

        // Mock tests
        String result1 = mock.transform("");
        verify(mock).transform("");
        assertEquals(result1, "");

        String result2 = mock.transform("prof.");
        verify(mock).transform("prof.");
        assertEquals(result2, "profesor");

        String result3 = mock.transform("dr Ninja");
        verify(mock).transform("dr Ninja");
        assertEquals(result3, "doktor Ninja");
    }
}