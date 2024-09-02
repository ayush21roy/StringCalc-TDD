package org.example;

import java.util.Objects;

public class Fraction {
    private final int numerator;
    private final int denominator;
    private Fraction that;

    public Fraction(int integerValue) {
        this(integerValue,1);            // constructor - chaining
    }

    public Fraction(int numerator, int denominator) {
        final int gcd = NumberTheory.gcd(numerator, denominator);
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    public Fraction plus(Fraction that) {
            return new Fraction(this.numerator * that.denominator + that.numerator * this.denominator,
                    this.denominator * that.denominator);
    }

    public int intValue() {
        return numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Fraction)
        {
            Fraction that = (Fraction) other;
            return this.numerator == that.numerator
                    && this.denominator == that.denominator;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return numerator * 19 + denominator ;
    }

}
