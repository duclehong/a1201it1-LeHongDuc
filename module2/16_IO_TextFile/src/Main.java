import Exercise.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("enter link file");
        Scanner sc = new Scanner(System.in);
        String linkFile = sc.nextLine();
        File fileLink = new File(linkFile);
        if (fileLink.exists()) {
            List<String> lineFile = FileUtils.readFile(linkFile);
            System.out.println("Enter link file copy");
            String linkFileCopy = sc.nextLine();
            File fileCopy = new File(linkFileCopy);
            if (fileCopy.exists()) {
                System.out.println("Enter choice: \n1. Insert \n2. Copy in new file \n3. Delete and copy \n4. Exit");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        insertTextFile(lineFile, linkFileCopy);
                        break;
                    case 2:
                        File file;
                        String nameNewFile = null;
                        do {
                            System.out.println("Enter link and name new file");
                            nameNewFile = sc.nextLine();
                            file = new File(nameNewFile);
                        }while(file.exists()==true);
                        copyNewFile(lineFile, file, nameNewFile);
                        break;
                    case 3:
                        copyFile(lineFile, linkFileCopy);
                    case 4:
                        break;
                }
            } else {
                copyNewFile(lineFile, fileCopy, linkFileCopy);
            }
        } else {
            System.out.println("This file does not exist!");
        }

    }

    private static void copyNewFile(List<String> lineFile, File file, String nameNewFile) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(nameNewFile);
        copyFile(lineFile, nameNewFile);
    }

    private static void copyFile(List<String> lineFile, String linkFileCopy) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(linkFileCopy);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        String line = null;
        int countCharacter = 0;
        for (String a : lineFile) {
            line = a.toString();
            FileUtils.writeInsertFile(linkFileCopy, line);
            countCharacter += line.length();
        }
        System.out.println("Number of characters:" + countCharacter);
    }


    private static void insertTextFile(List<String> lineFile, String linkFileCopy) {

        String line = null;
        int countCharacter = 0;
        for (String a : lineFile) {
            line = a.toString();
            FileUtils.writeInsertFile(linkFileCopy, line);
            countCharacter += line.length();
            System.out.println(line.length());
        }
        System.out.println("Number of characters:" + countCharacter);
    }
}
