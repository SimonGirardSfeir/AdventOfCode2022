package org.example.day7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FileInformationTest {

    private static Stream<Arguments> fileLines() {
        return Stream.of(
                Arguments.of("14848514 b.txt", new FileInformation("b.txt", 14848514)),
                Arguments.of("8504156 c.dat", new FileInformation("c.dat", 8504156))
        );
    }
    @ParameterizedTest
    @MethodSource("fileLines")
    void of_should_give_file_information_from_line(String givenLine, FileInformation expectedFileInformation) {
        //When
        FileInformation fileInformation = FileInformation.of(givenLine);

        //Then
        assertThat(fileInformation).isEqualTo(expectedFileInformation);
    }
}