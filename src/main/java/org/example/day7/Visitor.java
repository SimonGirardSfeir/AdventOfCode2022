package org.example.day7;

public interface Visitor {
    int perform(Node node);
    default int fileInformationVisitor(FileInformation fileInformation) {
        return fileInformation.fileSize();
    }

    int directoryInformationVisitor(DirectoryInformation directoryInformation);
}
