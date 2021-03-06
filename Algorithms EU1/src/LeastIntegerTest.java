import java.util.Random; // testbench

public class LeastIntegerTest {

    public static Random rand = new Random();

    public static void main(String[] args)
    {
        int[] arr1 = new int[16];
        int[] arr2 = {-1, 5, 123, 50, 80,
                40, 73, 27, 97, 93,
                82, 1, 40, 59, 42,
                25, 1, 41, 48};

        for(int x = 0; x < arr1.length; x++)
        {
            arr1[x] = rand.nextInt(101);
        }

        for(int x = 0; x < arr1.length; x++)
        {
            System.out.println(arr1[x]);
        }

        System.out.println();
        System.out.println("Min value is: " + min(arr1) + "\n");

        System.out.println("Min value is: " + min(arr2));
    }

    // The  min  method  returns  the  least  element  in a sequential
//  collection. If the  collection  is empty  an
//  IllegalArgumentException  is  thrown.
    public static int min(int[] elements)
            throws IllegalArgumentException {
        if (elements.length == 0)
            throw new IllegalArgumentException("empty  collection");
// Is used in trace  printing  2:
// int     nofIters = 1;
        int[] sequence = elements;
        //change starts !
        int nofPairs = sequence.length / 2;
        int nofUnpairedElements = sequence.length % 2;
        int nofPossibleElements = nofPairs + nofUnpairedElements;
        //int[] partialSeq = new int[nofPossibleElements];
        int i = 0;
        int j = 0;
        while (sequence.length > 1) {
            int[] partialSeq = new int[nofPossibleElements];
            //change ends
//  extract a partial  sequence  of  possible  elements
            i = 0;
            j = 0;
            while (j < nofPairs) {
                partialSeq[j++] = (sequence[i] < sequence[i + 1]) ?
                        sequence[i] : sequence[i + 1];
                i += 2;
            }
            if (nofUnpairedElements == 1)
                partialSeq[j] = sequence[sequence.length - 1];
// now  turn to the  partial  sequence
            sequence = partialSeq;
            nofPairs = nofPossibleElements / 2;
            nofUnpairedElements = nofPossibleElements % 2;
            nofPossibleElements = nofPairs + nofUnpairedElements;

            System.out.println(sequence.length);
            System.out.println(nofPairs);
            System.out.println(nofUnpairedElements);
            System.out.println(nofPossibleElements);
            System.out.println(j);
// Trace  printing 1 - to  follow  the  sequence
  System.out.println (java.util.Arrays.toString (sequence ));
// Trace  printing 2 - to  terminate  the  loop  preemptively
// (to be able to see  what  happens  initially)
// if (nofIters ++ == 10)
//     System.exit  (0);
        }
//  sequence [0] is the  only  remaining  possible  element
// - it is the  least  element
        return sequence[0];
    }
}
