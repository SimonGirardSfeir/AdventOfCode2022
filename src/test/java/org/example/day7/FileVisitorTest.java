package org.example.day7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileVisitorTest {

    FileVisitor fileVisitor = new FileVisitor();

    @Test
    void countNodeTotalSizeOfNodesWithSizeUpToMaxSize_should_give_the_total_size_of_Node_sub_nodes_included_up_to_a_certain_size() {
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
        DirectoryInformation givenDirectory = new DirectoryInformation("", List.of(dirA, fileB, fileC, dirD));

        //When
        int nodeTotalSize = fileVisitor.countNodeTotalSizeOfNodesWithSizeUpToMaxSize(givenDirectory, 100000);

        //Then
        assertThat(nodeTotalSize).isEqualTo(95437);
    }

    @Test
    void computeTotalSizeOfSmallestDirectoryBigEnoughToDeleteForFreeUpEnoughSpaceForSystemUpdate_should_give_the_total_size_of_the_required_directory() {
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
        DirectoryInformation givenDirectory = new DirectoryInformation("", List.of(dirA, fileB, fileC, dirD));

        //When
        int nodeTotalSize = fileVisitor.computeTotalSizeOfSmallestDirectoryBigEnoughToDeleteForFreeUpEnoughSpaceForSystemUpdate
                (givenDirectory, 70000000, 30000000);

        //Then
        assertThat(nodeTotalSize).isEqualTo(24933642);
    }

}