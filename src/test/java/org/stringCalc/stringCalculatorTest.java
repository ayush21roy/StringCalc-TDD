package org.stringCalc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class stringCalculatorTest {

    @Test
    public void noArguments() {
        stringCalculator calc = new stringCalculator();
        String value =  calc.add("");
        assertEquals("0", value);
    }

    @Test
    public void singleArguments() {
        stringCalculator calc = new stringCalculator();
        String value =  calc.add("1");
        assertEquals("1.0", value);
    }

    @Test
    public void floatArguments() {
        stringCalculator calc = new stringCalculator();
        String value =  calc.add("1.1");
        assertEquals("1.1", value);
    }

    @Test
    public void floatMultipleArguments() {
        stringCalculator calc = new stringCalculator();
        String value =  calc.add("1.1,2.2");

        assertEquals("3.3", value);
        assertEquals("4.3", calc.add("1.1,1,2.2"));
        assertEquals("3.3", calc.add("1.1,,2.2"));
        assertEquals("15.9", calc.add("1.1,,2.2,3,4,5.6"));
    }

    @Test
    public void newlineAsDelimiter() {
        stringCalculator calc = new stringCalculator();

        assertEquals("10.0", calc.add("1,2,,3\n4"));
        assertEquals( calc.continousDelimiterError("1,2,3,\n4"), calc.add("1,2,3,\n4"));
        assertEquals(calc.continousDelimiterError("175.2,\n35"), calc.continousDelimiterError("175.2,\n35"));
    }

    @Test
    public void ErrorTests() {
        stringCalculator calc = new stringCalculator();

        assertEquals( calc.continousDelimiterError("1,2,3,\n4"), calc.add("1,2,3,\n4"));
        assertEquals(calc.continousDelimiterError("175.2,\n35"), calc.add("175.2,\n35"));

        assertEquals(calc.EOFErrorMessage(), calc.add("1,2,"));
    }

    @Test
    public void negativeNumberNotAllowed() {
        stringCalculator calc = new stringCalculator();

        assertEquals("Negative not allowed: -2.0,-3.0", calc.add("1,-2,-3"));
    }
}
