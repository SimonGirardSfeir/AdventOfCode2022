package org.example.day7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DirectorySizeVisitorTest {
    private final Visitor directorySizeVisitor = new DirectorySizeVisitor();

    @Test
    void perform_should_give_total_size_of_directory() {
        //Given
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
        DirectoryInformation directory = new DirectoryInformation("", List.of(dirA, fileB, fileC, dirD));

        //When
        int totalSizeDirectory = directorySizeVisitor.perform(directory);

        //Then
        assertThat(totalSizeDirectory).isEqualTo(48381165);
    }

}