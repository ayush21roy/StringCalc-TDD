package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReduceFractionTest {

    @Test
    public void alreadyInLowestTerms() throws Exception {
        assertEquals(new Fraction(3,4), new Fraction(3,4));
    }

    @Test
    public void reduceToNotWholeNumbers() throws Exception {
        assertEquals(new Fraction(3,4), new Fraction(6,8));
    }

    @Test
    public void reduceToWholeNumbers() throws Exception {
        assertEquals(new Fraction(6), new Fraction(24,4));
    }

    @Test
    public void reduceZero() throws Exception {
        assertEquals(new Fraction(0), new Fraction(0,17235));
    }

    @Test
    public void reduceResultToWholeNumbers() throws Exception {
        assertEquals(new Fraction(1), new Fraction(1,3).plus(new Fraction(2,3)));
    }

    @Test
    public void oneDenominatorIsAMultipleOfTheOther() throws Exception {
        assertEquals(new Fraction(11,8), new Fraction(3,4).plus(new Fraction(5,8)));
    }

    @Test
    public void commonFactorInDenominator() throws Exception {
        assertEquals(new Fraction(11,18), new Fraction(1,6).plus(new Fraction(4,9)));
    }

    @Test
    public void reduceResultsEvenWhenDenominatorsAreTheSame() throws Exception {
        assertEquals(new Fraction(3,2), new Fraction(3,4).plus(new Fraction(3,4)));
        assertEquals(new Fraction(1,2), new Fraction(3,8).plus(new Fraction(1,8)));
    }

    @Test
    public void negativeFractionAndReducing() throws Exception {
        assertEquals(new Fraction(1,2), new Fraction(-1,4).plus(new Fraction(3,4)));
        assertEquals(new Fraction(-1,8), new Fraction(3,8).plus(new Fraction(-1,2)));
    }

    @Test
    public void negativeSignsEverywhere() throws Exception {
        assertEquals(new Fraction(1,2), new Fraction(1,-4).plus(new Fraction(-3,-4)));
    }
}
