package org.length

import spock.lang.Specification

import static org.length.Length.Unit.CM
import static org.length.Length.Unit.M
import static org.length.Length.Unit.MM

class LengthSpec extends Specification {

    def 'the same length initialized in different units should be equal'() {
        expect:
            new Length(value, unit) == new Length(1, M)
        where:
            value | unit
            100  | CM
            1    | M
            1000 | MM
    }

}

