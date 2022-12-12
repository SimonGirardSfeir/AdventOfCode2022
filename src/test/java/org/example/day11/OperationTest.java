package org.example.day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.day11.Operator.ADDITION;
import static org.example.day11.Operator.MULTIPLICATION;
import static org.example.day11.Operator.SQUARE;

class OperationTest {

    private static Stream<Arguments> line() {
        return Stream.of(
                Arguments.of("  Operation: new = old * 19", new Operation(19, MULTIPLICATION)),
                Arguments.of("  Operation: new = old + 6", new Operation(6, ADDITION)),
                Arguments.of("  Operation: new = old * old", new Operation(2, SQUARE))
        );
    }

    @ParameterizedTest
    @MethodSource("line")
    void of_should_give_operation_from_line(String givenLine, Operation expectedOperation) {
        //When
        Operation operation = Operation.of(givenLine);

        //Then
        assertThat(operation).isEqualTo(expectedOperation);
    }

}