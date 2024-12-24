package org.length

import spock.lang.Specification

import static org.length.Length.Unit.CM
import static org.length.Length.Unit.M
import static org.length.Length.Unit.MM

class LengthSpec extends Specification {

    def 'the same length initialized in different units should be equal\
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
        new Length(-10, CM)

        then:
        def exception = thrown(IllegalStateException)
        exception.message == "Length cannot be negative"
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


}
