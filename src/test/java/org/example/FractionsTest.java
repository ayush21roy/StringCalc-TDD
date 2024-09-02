package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionsTest {

     @Test
    public void zeroPlusZero() throws Exception {
        Fraction sum = new Fraction(0).plus(new Fraction(0));
        assertEquals(0, sum.intValue());
    }

    @Test
    public void nonZeroPlusZero() throws Exception {
         final  Fraction sum = new Fraction(3).plus(new Fraction(0));
         assertEquals(3, sum.intValue());
    }

    @Test
    public void zeroPlusNonZero() throws Exception {
         final Fraction sum = new Fraction(0).plus(new Fraction(5));
         assertEquals(5,sum.intValue());
    }

    @Test
    public void nonZeroPlusNonZero() throws Exception {
//         final Fraction sum = new Fraction(-3).plus(new Fraction(2));
//         assertEquals(-1, sum.intValue());
         assertEquals(new Fraction(-1), new Fraction(-3).plus(new Fraction(2)));
    }

    @Test
    public void nonTrivialDenominator() throws Exception {
         final Fraction sum = new Fraction(1,5).plus(new Fraction(2,5));
//         assertEquals(3, sum.getNumerator());
//         assertEquals(5, sum.getDenominator());
         assertEquals(new Fraction(3,5), sum);
    }

    @Test
    public void differentDenominatorsWithoutReducing () throws Exception {
         assertEquals(new Fraction(5,6), new Fraction(1,2).plus(new Fraction(1,3)));
    }

}
