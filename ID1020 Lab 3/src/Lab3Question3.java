import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*README
Program from algorithm book
Takes the first 100 words and finds how much of each word is used. The user can find the nth most used to the xth used
 */

public class Lab3Question3
{
    //taken from the algorithm book
    public class BinarySearchST<Key extends Comparable<Key>, Value>
    {
        private Key[] keys;  //array of key
        private Value[] vals;  //array of values
        private int N;  //the length
        public BinarySearchST(int capacity)  //make the size of the array this one is non resizing
        { // See Algorithm 1.1 for standard array-resizing code.
            keys = (Key[]) new Comparable[capacity];  //typecast the comparable to key when making it
            vals = (Value[]) new Object[capacity];  //typecast the object to value when making it
        }

        public boolean isEmpty()  //checks, if keys == null, true else false
        {
            return (keys == null);
        }

        public int size()  //gets the size
        { return N; }

        public Value get(Key key)  //gets the value corresponding to the key
        {
            if (isEmpty()) return null;  //if empty null
            int i = rank(key);  //get the index of it
            if (i < N && keys[i].compareTo(key) == 0) return vals[i];  //if in array and found the key return the value
            else return null;
        }

        public int rank(Key key)  //uses binary search
        {
            int lo = 0, hi = N-1;  //boundaries
            while (lo <= hi)
            {
                int mid = lo + (hi - lo) / 2;
                int cmp = key.compareTo(keys[mid]);
                if (cmp < 0) hi = mid - 1;  //if lower search the lower part
                else if (cmp > 0) lo = mid + 1;  //if higher search the higher part
                else return mid;  //if matched return that
            }
            return lo;  //if it doesn't exist put it in index lo
        }
        // See page 381.

        public void put(Key key, Value val)
        { // Search for key. Update value if found; grow table if new.
            int i = rank(key);  //get the index of the key
            if (i < N && keys[i].compareTo(key) == 0)  //if in array and found return the
            { vals[i] = val; return; }
            for (int j = N; j > i; j--)
            { keys[j] = keys[j-1]; vals[j] = vals[j-1]; }
            keys[i] = key; vals[i] = val;
            N++;
        }

        public boolean contains(Key key)  //checks the array if there is a key that is the same
        {
            int size = size();

            for (int x = 0; x < size; x++)
            {
                if (key.equals(keys[x]))
                {
                    return (true);
                }
            }

            return (false);
        }

        public Key[] keys()  //returns a copy of the key array
        {
            int tempLength = size();
            Key[] tempArray = (Key[]) new Comparable[tempLength];

            for (int x = 0; x < tempLength; x++)
            {
                tempArray[x] = this.keys[x];
                //System.out.println(Arrays.toString(vals));
            }

            return (tempArray);
        }
    }

    public static void main(String[] args) throws IOException
    {
        long startTime = System.nanoTime();
        Scanner in = new Scanner(new File("TextModified.txt"));
        Lab3Question3 lab = new Lab3Question3();
        int limit = 150000;  //limit of the amount of words
        String word = in.nextLine();
        int wordCounter = 0;  //counter for 100 words
        int letterCounter = 0;  //counter so that it stays in the line
        int spaceCounter = 0;  //marker for the space after the word
        int anotherCounter = 0;  //marker for starting to add letters of the word
        String[] filteredWords = new String[limit];  //array to store the extracted words

        while (in.hasNextLine())  //word separator
        {
            StringBuilder sb = new StringBuilder();
            int stringLimit = word.length();

            while (letterCounter < stringLimit)  //while still need new words
            {
                if (word.charAt(letterCounter) == ' ' && anotherCounter != 0)  //checks if there is a space after the
                {//word
                    spaceCounter++;  //marks a space if found after a word
                }
                else if (word.charAt(letterCounter) != ' ')  //if a letter add it
                {
                    sb.append(word.charAt(letterCounter));
                    anotherCounter++;  //marks that a word is found
                    if (letterCounter == stringLimit - 1)
                    {
                        spaceCounter++;  //if at the end of the line and a letter is there mark it so that it can write
                    }
                }
                if (spaceCounter != 0)  //if a space after the word is found make it into a string and put it in the
                {//array
                    //System.out.println(sb.toString());  //replace with inserting
                    if (wordCounter < limit)  //prevent overfilling the array at the last line
                    {
                        //System.out.println(sb.toString());
                        filteredWords[wordCounter] = sb.toString();
                    }
                    int delete = sb.length();  //reset for the next word
                    sb.delete(0, delete);
                    anotherCounter = 0;
                    spaceCounter = 0;
                    wordCounter++;
                }

                letterCounter++;  //increment the pointer for the line
            }

            letterCounter = 0;  //reset for the next line'
            if (in.hasNextLine())
            {
                word = in.nextLine();
            }
        }

        Lab3Question3.BinarySearchST<String, Integer> st =
                lab.new BinarySearchST  <String, Integer>(limit);

        for (int x = 0; x < wordCounter; x++)  //for the words in the array put it in
        { // Build symbol table and count frequencies.
            String wordInput = filteredWords[x];

            if (!st.contains(wordInput))  //if a new word add it in
            {
                st.put(wordInput, 1);
            }
            else  //if an old word increment the value
            {
                st.put(wordInput, st.get(wordInput) + 1);
            }
        }
// Find a key with the highest frequency count.
        String max = "";  //add this as a benchmark
        st.put(max, 0);

        Comparable[] outputArray = st.keys();  //get the list of keys in the dictionary/symbol table

        for (int x = 0; x < outputArray.length; x++)  //for all the entries check the highest amount of entry
        {
            //System.out.println((String) (outputArray[x]) + ' ' + st.get((String) (outputArray[x])));
            if (st.get((String) (outputArray[x])) > st.get(max))  //if bigger than
            {
                max = (String) (outputArray[x]);
            }
        }

        System.out.println(max + " " + st.get(max));
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.printf("Program time: %d ns\n", time);


        String[][] sorted = new String[limit / 2][];  //doesn't need full length as some words have same occurrence
        int putCounter = 1;
        int counterSort = 0;
        int counterInnerSort = 0;

        for (int x = sorted.length; x >= 1; x--)  //go through the sorted array from the back
        {
            String[] temp = new String[limit];
            for (int y = 0; y < outputArray.length; y++)  //go through the array in the binary search symbol table
            {
                //System.out.println(x);
                if (st.get((String) (outputArray[y])) == x)  //put in the most used words first
                {
                    temp[counterInnerSort] = (String) (outputArray[y]);
                    sorted[putCounter] = temp;
                    counterSort = 1;
                    //System.out.println(x);
                    //System.out.println(Arrays.toString(temp));
                    counterInnerSort++;
                }
            }

            counterInnerSort = 0;

            if (counterSort == 1)
            {
                counterSort = 0;
                putCounter++;
            }
        }

        //System.out.println(Arrays.toString(outputArray));
        //System.out.println(Arrays.toString(sorted[1]));
        //System.out.println(Arrays.toString(sorted[2]));

        Scanner inType = new Scanner(System.in);
        int loop = 0;
        while (loop == 0)
        {
            System.out.println("To exit type abc");
            System.out.println("Type 2 numbers \"N X\" to check for the Nth to the Xth most used word");
            String input = inType.nextLine();

            if (input.equals("abc"))
            {
                loop = 1;
            }
            else
            {
                String[] output = new String[limit];
                String[] numbers = input.split("\\W+");  //split the input so that you get the numbers

                //System.out.println(numbers[0]);
                //System.out.println(numbers[1]);
                int number1 = Integer.parseInt(numbers[0]);
                int number2 = Integer.parseInt(numbers[1]);
                int outputCounter = 0;
                max = "";
                st.put(max, 0);
                for (int x = 1; x < putCounter; x++)  //check for the different amount of used words
                {
                    for (int y = 0; y < sorted[x].length; y++)  //go through the sorted array
                    {
                        if ((number1 <= x) && (x <= number2))  //if between the numbers show it
                        {
                            if(sorted[x][y] != null)
                            {
                                output[outputCounter] = sorted[x][y];
                                outputCounter++;
                            }
                        }
                    }
                }

                for (String s : output)
                {
                    if (s != null)
                    {
                        int number = st.get(s);
                        System.out.printf("%s %d\n", s, number);
                    }
                }
            }
        }
    }
}
