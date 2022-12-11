package org.example.day7;

import org.example.LineExtractor;
import org.example.exception.InvalidDataFromFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileSystemResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day7/inputData.txt");
    }

    @Test
    void getFileSystemFromLines_should_gives_expected_file_system_from_input_lines() throws InvalidDataFromFile {
        //Given
        List<String> givenLines = List.of("$ cd /","$ ls","dir a","14848514 b.txt","8504156 c.dat","dir d","$ cd a",
                "$ ls","dir e","29116 f","2557 g","62596 h.lst","$ cd e","$ ls","584 i","$ cd ..","$ cd ..","$ cd d","$ ls",
                "4060174 j","8033020 d.log","5626152 d.ext","7214296 k");

        //When
        DirectoryInformation directoryInformation = FileSystemResolver.getFileSystemFromLines(givenLines);

        //Then
        FileInformation fileI = FileInformation.of("584 i");
        DirectoryInformation dirE = new DirectoryInformation("e", List.of(fileI));
        FileInformation fileF = FileInformation.of("29116 f");
        FileInformation fileG = FileInformation.of("2557 g");
        FileInformation fileH = FileInformation.of("62596 h.lst");
        DirectoryInformation dirA = new DirectoryInformation("a", List.of(dirE, fileF, fileG, fileH));
        FileInformation fileJ = FileInformation.of("4060174 j");
        FileInformation fileDLog = FileInformation.of("8033020 d.log");
        FileInformation fileDExt = FileInformation.of("5626152 d.ext");
        FileInformation fileK = FileInformation.of("7214296 k");
        DirectoryInformation dirD = new DirectoryInformation("d", List.of(fileJ, fileDLog, fileDExt, fileK));
        FileInformation fileB = FileInformation.of("14848514 b.txt");
        FileInformation fileC = FileInformation.of("8504156 c.dat");
        DirectoryInformation expectedDirectory = new DirectoryInformation("", List.of(dirA, fileB, fileC, dirD));
        assertThat(directoryInformation).isEqualTo(expectedDirectory);
    }

    @Test
    void resolve_part1_of_day7_problem() throws InvalidDataFromFile {
        //Given
        Node givenNode = FileSystemResolver.getFileSystemFromLines(lines);
        Visitor visitor = new SumOfDirectoriesSizeUpToMaxSizeVisitor(100000);
        //When
        int nodeUpTo100000TotalSize = visitor.perform(givenNode);
        //Then
        assertThat(nodeUpTo100000TotalSize).isEqualTo(1428881);
    }

    @Test
    void resolve_part2_of_day7_problem() throws InvalidDataFromFile {
        //Given
        Node givenNode = FileSystemResolver.getFileSystemFromLines(lines);
        Visitor visitor = new SizeSmallestDirectoryCandidateForDeletionVisitor(40000000);
        //When
        int nodeUpTo100000TotalSize = visitor.perform(givenNode);
        //Then
        assertThat(nodeUpTo100000TotalSize).isEqualTo(10475598);
    }

}