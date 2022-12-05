import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


import static java.nio.file.StandardOpenOption.CREATE;

public class Main

{

    public static void main(String[] args)

    {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String record = "";
        int linesCount = 0;
        int wordsCount = 0;


        try
        {

            File workingDirectory = new File(System.getProperty("user.dir"));


            chooser.setCurrentDirectory(workingDirectory);


            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {

                selectedFile = chooser.getSelectedFile();

                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                String[] fields;

                while (reader.ready())


                {

                    record = reader.readLine();
                    linesCount++;
                    fields = record.split(" ");
                    wordsCount += fields.length;
                    System.out.printf("\nLine %2d %-20s ", linesCount, record);


                }
                reader.close();
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("File: "+ selectedFile+ " has been read");
                System.out.println("File name is: " + selectedFile.getName()) ;
                System.out.println("There is " + selectedFile.length() + " characters in this file.");
                System.out.println("There is " + linesCount  + " lines in this file.");
                System.out.println("There is " + wordsCount + " words in this file.");
            }

            else

            {

                System.out.println("You did not select a file. ... exiting.\nRetry again and select a file.");
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File has not been found");
            e.printStackTrace()

            ;
        }

        
        catch (IOException e)

        {
            e.printStackTrace();
        }


    }


}