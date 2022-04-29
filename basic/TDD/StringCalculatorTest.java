import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator cal;

    @BeforeEach
    void setCal() {
        cal = new StringCalculator();
    }


    @Test
    void add_숫자하나() {
        assertEquals(1, cal.add("1"));
    }

    @Test
    void add_쉼표구분() {
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    void add_쉼표_또는_콜론_구분() {
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    void add_custom_구분자() {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    //exceptionTest
    @Test
    void add_negative() throws Exception {
        Assertions.assertThrows(RuntimeException.class, () -> {
            cal.add("-1,2,3");
        });
    }
}