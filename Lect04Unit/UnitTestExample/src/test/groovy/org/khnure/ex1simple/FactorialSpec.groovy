package org.khnure.ex1simple


import spock.lang.Specification

class FactorialSpec extends Specification {
    def "calculate factorial"() {
        given:
        def factorial = new Factorial()

        expect:
        factorial.calculate(number) == result

        where:
        number | result
        0      | 1
        1      | 1
        2      | 2
        3      | 6
        4      | 24
        5      | 120
    }

    def "calculate factorial of negative number"() {
        given:
        def factorial = new Factorial()

        when:
        factorial.calculate(-1)

        then:
        thrown(IllegalArgumentException)
    }
}
