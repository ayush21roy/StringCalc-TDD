package org.exampleMultiply;

import org.example.Fraction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplyFractionsTest {

    @Test
    public void zeroMultiply() throws Exception {
         final FractionMultiply mul = new FractionMultiply(0).multiply(new FractionMultiply(0));
         assertEquals(0, mul.intVal());
    }

    @Test
    public void wholeNumberMultiply() {
        final FractionMultiply mul = new FractionMultiply(2).multiply(new FractionMultiply(3));
        assertEquals(6, mul.intVal());
    }

    @Test
    public void sameInDenominator() {
        final FractionMultiply mul = new FractionMultiply(1,5).multiply(new FractionMultiply(4,5));
        assertEquals(4, mul.getNumerator());
        assertEquals(25, mul.getDenominator());

        assertEquals(new FractionMultiply(2,9), new FractionMultiply(2,3).multiply(new FractionMultiply(1,3)));
    }

    // make sure 1/2 == 3/6
    @Test
    public void reduceFraction() {
        assertEquals(new FractionMultiply(1,2), new FractionMultiply(3,6));
    }

    @Test
    public void reduceAfterMultiplying() {
        assertEquals(new FractionMultiply(4,3), new FractionMultiply(2,3).multiply(new FractionMultiply(6,3)));
        assertEquals(new FractionMultiply(1,4), new FractionMultiply(1,8).multiply(new FractionMultiply(4,2)));
    }
}
