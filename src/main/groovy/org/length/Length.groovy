package org.length

import static org.length.Length.Unit.MM

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

    Length plus(Length length) {
        return new Length(length.lengthInMillimeters + this.lengthInMillimeters, MM)
    }

    enum Unit {
        M, CM, MM
    }

}

