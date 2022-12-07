package org.example.day7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DirectoryInformationTest {

    private static Stream<Arguments> inputDatasForDirectory() {
        FileInformation fileInformation1 = FileInformation.of("14848514 b.txt");
        FileInformation fileInformation2 = FileInformation.of("8504156 c.dat");
        DirectoryInformation dirA = new DirectoryInformation("a", new ArrayList<>());
        DirectoryInformation dirD = new DirectoryInformation("d", new ArrayList<>());
        DirectoryInformation expectedDirectory1 = new DirectoryInformation("", List.of(dirA, fileInformation1, fileInformation2, dirD));
        DirectoryInformation dirE = new DirectoryInformation("e", new ArrayList<>());
        FileInformation fileInformation3 = FileInformation.of("29116 f");
        FileInformation fileInformation4 = FileInformation.of("2557 g");
        FileInformation fileInformation5 = FileInformation.of("62596 h.lst");
        DirectoryInformation expectedDirectory2 = new DirectoryInformation("a", List.of(dirE, fileInformation3, fileInformation4, fileInformation5));

        return Stream.of(
                Arguments.of("", List.of("dir a", "14848514 b.txt", "8504156 c.dat", "dir d"), expectedDirectory1),
                Arguments.of("a", List.of("dir e", "29116 f", "2557 g", "62596 h.lst"), expectedDirectory2)
        );
    }
    @ParameterizedTest
    @MethodSource("inputDatasForDirectory")
    void of_should_give_directory_information_from_lines_and_parent_directory(String givenDirectoryName, List<String> givenLines,
                                                                              DirectoryInformation expectedDirectory) {
        DirectoryInformation directoryInformation = DirectoryInformation.of(givenDirectoryName, givenLines);

        assertThat(directoryInformation).isEqualTo(expectedDirectory);
    }

}