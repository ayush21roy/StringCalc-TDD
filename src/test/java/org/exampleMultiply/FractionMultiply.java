package org.exampleMultiply;

import org.example.NumberTheory;

public class FractionMultiply {
    private int value;
    private final int numerator;
    private final int denominator;

    public FractionMultiply(int value) {
       this(value,1);
    }

    public FractionMultiply(int numerator, int denominator) {
        final int gcd = NumberTheory.gcd(numerator, denominator);
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    public FractionMultiply multiply(FractionMultiply that) {
        return new FractionMultiply(this.numerator * that.numerator, this.denominator * that.denominator);
    }

    public int intVal() {
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
        if(other instanceof FractionMultiply)
        {
            FractionMultiply that = (FractionMultiply) other;
            return this.numerator == that.numerator
                    && this.denominator == that.denominator;
        }
        return false;
    }
}
