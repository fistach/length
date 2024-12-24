package org.length

class Length {

    private int lengthInMillimeters;

    Length(int value, Unit unit) {
        if (unit == Unit.MM) {
            lengthInMillimeters = value
        }
    }

    enum Unit {
        M, CM, MM
    }

}

