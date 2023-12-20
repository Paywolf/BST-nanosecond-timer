import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Binary Search Tree");
        List<Long> insertAndDeleteDurations100 = run(100);
        List<Long> insertAndDeleteDurations1000 = run(1000);
        List<Long> insertAndDeleteDurations10000 = run(10000);
        List<Long> insertAndDeleteDurations100000 = run(100000);

        System.out.format("%7s%15d%15d%15d%15d%n",
                "",
                100,
                1000,
                10000,
                100000
        );

        System.out.format("%7s%15d%15d%15d%15d%n",
                "Insert:",
                insertAndDeleteDurations100.get(0),
                insertAndDeleteDurations1000.get(0),
                insertAndDeleteDurations10000.get(0),
                insertAndDeleteDurations100000.get(0)
        );

        System.out.format("%7s%15d%15d%15d%15d%n",
                "Delete:",
                insertAndDeleteDurations100.get(1),
                insertAndDeleteDurations1000.get(1),
                insertAndDeleteDurations10000.get(1),
                insertAndDeleteDurations100000.get(1)
        );
    }

    public static List<Long> run(int elementsCount) {
        Random rand = new Random(); // we are generating random numbers to populate the tree

        Set<Integer> values = new HashSet<>(); // set to store unique random numbers

        while (values.size() != elementsCount) { // continue adding until we have `elementsCount` integers
            values.add(rand.nextInt());  // generate random number and add to the `values` set
        }

        // converting to an array of primitives
        // the cost of getting elements is minimal when iterating a primitive array than a HashSet of Integers
        // this helps to get more accurate readings for actual time spent on tree operations than data access operations
        int[] valuesArr = values.stream().mapToInt(Number::intValue).toArray();

        BinarySearchTree bst = new BinarySearchTree();

        long startTime = System.nanoTime(); // start timer
        for(int i:valuesArr){
            bst.insert(i); // perform insert operations
        }
        long insertDuration = System.nanoTime() - startTime;

        startTime = System.nanoTime(); // start timer
        for(int i:valuesArr){
            bst.delete(i); // perform delete operations
        }
        long deleteDuration = System.nanoTime() - startTime;

        return List.of(insertDuration, deleteDuration);
    }
}

// Output:
//
// > Driver
// Binary Search Tree
//                    100           1000          10000         100000
// Insert:         241875         360375        1094291       12263083
// Delete:          74833         575750        1575792       10091459
//
// Process finished with exit code 0
//