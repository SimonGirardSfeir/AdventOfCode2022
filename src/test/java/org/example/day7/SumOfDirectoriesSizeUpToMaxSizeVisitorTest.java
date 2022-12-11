package org.example.day7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfDirectoriesSizeUpToMaxSizeVisitorTest {

    private final Visitor sumOfDirectoriesSizeUpToMaxSizeVisitor = new SumOfDirectoriesSizeUpToMaxSizeVisitor(100000);

    @Test
    void perform_should_give_the_sum_of_directories_size_with_a_size_up_to_the_fixed_limit() {
        //Given
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
        DirectoryInformation directory = new DirectoryInformation("", List.of(dirA, fileB, fileC, dirD));

        //When
        int totalSizeDirectory = sumOfDirectoriesSizeUpToMaxSizeVisitor.perform(directory);

        //Then
        assertThat(totalSizeDirectory).isEqualTo(95437);
    }

}