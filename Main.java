/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */

public class Main {

    public static Map<String,Integer> processData(ArrayList<String> array) {
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return the appropriate value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
	Emp test = new Emp();
	Emp eng = new Emp();

	int i = 0;
	while (i < array.size())
	{
		String org[] = array.get(i).split(",");

		if (org[2].trim().equals("Testing"))
		{

			if (test.empid < Integer.parseInt(org[0]))
			{
			test.empid = Integer.parseInt(org[0]);
			test.salary = Integer.parseInt(org[3].trim()); 				
			}
		}
		else
		{

			if (eng.empid < Integer.parseInt(org[0]))
			{
			eng.empid = Integer.parseInt(org[0]);
			eng.salary = Integer.parseInt(org[3].trim()); 				
			}
		}

		i++;
	}

        Map<String,Integer> retVal = new HashMap<String,Integer>();
	
	retVal.put("Engineering", eng.salary);
	retVal.put("Testing", test.salary);
	


       return retVal;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String,Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}

class Emp
{
	int empid;
	int salary;
	
	Emp() 
	{
		empid = 0;
		salary = 0;
	}	
};

