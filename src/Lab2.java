import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The Lab2 class demonstrates the brute force design pattern.
 * @author: Chris Wu
 * @studentID: A01256284
 * @set: 3D
 * @version: 1.0
 */
public class Lab2
{
    private static       ArrayList<Integer> numbers;
    private static final int                THIRTY_SEVEN = 37;

    /**
     * The Lab2 constructor.
     */
    public Lab2()
    {
        numbers = new ArrayList<>();
    }

    /**
     * Returns an ArrayList<String> of numbers that add up to a multiple of 37.
     * @return ArrayList<String> of numbers that add up to a multiple of 37
     */
    private static ArrayList<String> multipleOf37()
    {
        ArrayList<String> result          = new ArrayList<String>();
        final int         lastIndex       = numbers.size() - 1;
        final int         lastLeftIndex   = lastIndex - 2;
        final int         lastMiddleIndex = lastIndex - 1;

        for(int left = 0; left <= lastLeftIndex; left++)
        {
            for(int middle = left + 1; middle <= lastMiddleIndex; middle++)
            {
                for(int right = middle + 1; right <= lastIndex; right++)
                {
                    if((numbers.get(left) + numbers.get(middle) + numbers.get(right)) % THIRTY_SEVEN == 0)
                    {
                        result.add(String.valueOf(numbers.get(left)));
                        result.add(String.valueOf(numbers.get(middle)));
                        result.add(String.valueOf(numbers.get(right)));
                    }
                }
            }
        }
        return result;
    }

    /**
     * Displays the three numbers for each file that adds up to be a multiple of 37.
     * @param fileName is the file name
     * @param result is the ArrayList<String> that contains numbers that add up to a multiple of 37
     */
    private static void displayData(final String fileName,
                                    final ArrayList<String> result)
    {
        String output = fileName + ": {";

        for(String num : result)
        {
            output = output + num + ", ";
        }
        output = output.substring(0, output.length() - 2);
        output += "}";

        System.out.println(output);
    }

    /**
     * 1. Read a list of numbers from a data file and store them in an array
     * 2. Use a Brute Force algorithm to find the desired triple
     * 3. Display the results via output to the console
     * @param fileName is the file name
     * @throws FileNotFoundException if file is not found
     */
    public static void doTheStuff(final String fileName) throws FileNotFoundException
    {
        try
        {
            File file = new File(fileName);

            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine())
            {
                String number = scanner.nextLine();
                numbers.add(Integer.valueOf(number));
            }

            scanner.close();

            ArrayList<String> result = multipleOf37();
            displayData(fileName, result);
            numbers = new ArrayList<>();
        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of the program.
     * @param args (unused)
     */
    public static void main(final String[] args) throws FileNotFoundException
    {
        Lab2 obj = new Lab2();

        final String file0 = "data0.txt";
        final String file1 = "data1.txt";
        final String file2 = "data2.txt";
        final String file3 = "data3.txt";
        final String file4 = "data4.txt";
        final String file5 = "data5.txt";
        final String file6 = "data6.txt";

        doTheStuff(file0);
        doTheStuff(file1);
        doTheStuff(file2);
        doTheStuff(file3);
        doTheStuff(file4);
        doTheStuff(file5);
        doTheStuff(file6);
    }
}
