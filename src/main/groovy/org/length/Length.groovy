package org.length

import static org.length.Length.Unit.MM

/**
 * A length with a unit, which is a multiple of a millimeter.
 * It can be used to represent a value of a measurement,
 * for example 23mm, 12cm or 11m.
 *
 */
class Length {

    private int lengthInMillimeters;

    Length(int value, Unit unit) {
        if (value < 0) {
            throw new IllegalStateException("Length cannot be negative")
        }

        if (unit == MM) {
            lengthInMillimeters = value
        } else if (unit == Unit.M) {
            lengthInMillimeters = value * 1000;
        } else if (unit == Unit.CM) {
            lengthInMillimeters = value * 10
        }
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (o == null || getClass() != o.class) return false

        Length length = (Length) o

        if (lengthInMillimeters != length.lengthInMillimeters) return false

        return true
    }

    int hashCode() {
        return lengthInMillimeters
    }

    Length plus(Length other) {
        return new Length(this.lengthInMillimeters + other.lengthInMillimeters, MM)
    }

    Length minus(Length other) {
        return new Length(this.lengthInMillimeters - other.lengthInMillimeters, MM)
    }

    @Override
    String toString() {
        return lengthInMillimeters + 'mm';
    }

    int inMm() {
        lengthInMillimeters
    }

    enum Unit {
        M, CM, MM
    }

    static Length of(int value, Unit unit) {
        new Length(value, unit)
    }

    static Length lengthOf(int value, Unit unit) {
        new Length(value, unit)
    }


}

