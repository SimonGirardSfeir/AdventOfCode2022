package org.example.day7;

import org.example.LineExtractor;
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
    void getFileSystemFromLines_should_gives_expected_file_system_from_input_lines() {
        //Given
        List<String> givenLines = List.of("$ cd /","$ ls","dir a","14848514 b.txt","8504156 c.dat","dir d","$ cd a",
                "$ ls","dir e","29116 f","2557 g","62596 h.lst","$ cd e","$ ls","584 i","$ cd ..","$ cd ..","$ cd d","$ ls",
                "4060174 j","8033020 d.log","5626152 d.ext","7214296 k");

        //When
        DirectoryInformation directoryInformation = FileSystemResolver.getFileSystemFromLines(givenLines);

        //Then
        FileInformation fileI = new FileInformation("i", 584);
        DirectoryInformation dirE = new DirectoryInformation("e", List.of(fileI));
        FileInformation fileF = new FileInformation("f", 29116);
        FileInformation fileG = new FileInformation("g", 2557);
        FileInformation fileH = new FileInformation("h.lst", 62596);
        DirectoryInformation dirA = new DirectoryInformation("a", List.of(dirE, fileF, fileG, fileH));
        FileInformation fileJ = new FileInformation("j", 4060174);
        FileInformation fileDLog = new FileInformation("d.log", 8033020);
        FileInformation fileDExt = new FileInformation("d.ext", 5626152);
        FileInformation fileK = new FileInformation("k", 7214296);
        DirectoryInformation dirD = new DirectoryInformation("d", List.of(fileJ, fileDLog, fileDExt, fileK));
        FileInformation fileB = new FileInformation("b.txt", 14848514);
        FileInformation fileC = new FileInformation("c.dat", 8504156);
        DirectoryInformation expectedDirectory = new DirectoryInformation("", List.of(dirA, fileB, fileC, dirD));
        assertThat(directoryInformation).isEqualTo(expectedDirectory);
    }

    @Test
    void resolve_part1_of_day7_problem() {
        //Given
        Node givenNode = FileSystemResolver.getFileSystemFromLines(lines);
        Visitor visitor = new SumOfDirectoriesSizeUpToMaxSizeVisitor(100000);
        //When
        int nodeUpTo100000TotalSize = visitor.perform(givenNode);
        //Then
        assertThat(nodeUpTo100000TotalSize).isEqualTo(1428881);
    }

    @Test
    void resolve_part2_of_day7_problem() {
        //Given
        Node givenNode = FileSystemResolver.getFileSystemFromLines(lines);
        Visitor visitor = new SizeSmallestDirectoryCandidateForDeletionVisitor(40000000);
        //When
        int nodeUpTo100000TotalSize = visitor.perform(givenNode);
        //Then
        assertThat(nodeUpTo100000TotalSize).isEqualTo(10475598);
    }

}