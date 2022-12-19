package org.example.day7;

import org.example.exception.InvalidDataFromFile;

import java.util.ArrayList;
import java.util.List;

public final class FileSystemResolver {
    private FileSystemResolver() {
    }

    public static DirectoryInformation getFileSystemFromLines(List<String> lines) {
        int depth = 0;
        List<Node> nodeByDepths = new ArrayList<>();
        DirectoryInformation directoryInformation = new DirectoryInformation("", new ArrayList<>());
        nodeByDepths.add(directoryInformation);
        Node currentDirectory = directoryInformation;
        int i = 1;
        while (i < lines.size()) {
            String currentLine = lines.get(i);
            if (currentLine.contains("$ ls")) {
                i = feedDirectoryWithListedElementAndUpdateIndex(i, currentDirectory, lines);
            }
            if (isItANewDirectoryToGoIn(currentLine)) {
                depth++;
                String currentDirectoryName = currentLine.split(" ")[2];
                currentDirectory = currentDirectory.subElements().stream()
                        .filter(node -> node.name().equals(currentDirectoryName)).findFirst()
                        .orElseThrow(InvalidDataFromFile::new);
                nodeByDepths.add(depth, currentDirectory);
                i++;
            }
            if (currentLine.contains("$ cd ..")) {
                depth--;
                currentDirectory = nodeByDepths.get(depth);
                i++;
            }
        }

        return directoryInformation;
    }

    private static boolean isItANewDirectoryToGoIn(String currentLine) {
        return currentLine.contains("$ cd") && (!currentLine.contains("/") && !currentLine.contains(".."));
    }
    private static int feedDirectoryWithListedElementAndUpdateIndex(int index, Node currentDirectory, List<String> lines) {
        String currentLine = lines.get(++index);
        while (!currentLine.contains("$")) {
            List<Node> currentDirectoryNodes = currentDirectory.subElements();
            if (currentLine.contains("dir"))
                currentDirectoryNodes.add(DirectoryInformation.of(currentLine.split(" ")[1], new ArrayList<>()));
            else
                currentDirectoryNodes.add(FileInformation.of(currentLine));
            if (index < lines.size() -1)
                currentLine = lines.get(++index);
            else {
                index++;
                break;
            }
        }

        return index;
    }
}
