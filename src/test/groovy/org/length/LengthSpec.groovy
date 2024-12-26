package org.length

import spock.lang.Specification

import static org.length.Length.Unit.CM
import static org.length.Length.Unit.M
import static org.length.Length.Unit.M
import static org.length.Length.Unit.MM
import static org.length.Length.lengthOf

class LengthSpec extends Specification {

    def 'the same length initialized in different units should be equal \
to length initialized with meters'() {

        expect:
        new Length(value, unit) == new Length(1, M)

        where:
        value | unit
        100   | CM
        1     | M
        1000  | MM
    }

    def 'length should be non-negative'() {
        when:
        new Length(-10, unit)

        then:
        def exception = thrown(IllegalStateException)
        exception.message == "Length cannot be negative"

        where:
        unit << [M,
                 CM,
                 MM]
    }

    def 'the same length initialized in different units should be equal'() {
        expect:
        new Length(value1, unit1) == new Length(value2, unit2)

        where:
        value1 | unit1 | value2 | unit2
        123    | CM    | 1230   | MM
        983000 | MM    | 983    | M
        983000 | MM    | 98300  | CM
        45     | M     | 4500   | CM
        567    | M     | 567000 | MM
    }

    def 'sum of lengths should be the length of sum'() {
        given:
        Length length1 = new Length(1, M)
        Length length2 = new Length(1, M)

        when:
        var sum = length1 + length2

        then:
        sum == new Length(2, M)
    }

    def 'sum of lengths in millimeters cannot be greater than Integer.MAX'() {
        given:
        Length length1 = new Length(Integer.MAX_VALUE - 100, MM)
        Length length2 = new Length(101, MM)

        when:
        length1 + length2

        then:
        thrown(IllegalStateException)
    }

    def 'toString should print the length in mm and it should indicate it'() {
        given:
        def length = Length.of(12, M)

        when:
        String string = length.toString()

        then:
        '12000mm' == string
    }

    def 'it should be possible to get int value of length in mm'() {
        given:
        Length length = lengthOf 5,M

        when:
        int inMillimeters = length.inMm()

        then:
        5000 == inMillimeters
    }
}
