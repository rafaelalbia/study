package Java.Algorithms;

class Sample {

    // Binary Search
    public static int binarySearch(String[] array, String target) {
        int higher = array.length - 1;
        int half;
        int lower = 0;

        while (lower <= higher) {
            half = (lower + higher) / 2;

            if (array[half].compareTo(target) < 0) {
                lower = half + 1;
            } else if (array[half].compareTo(target) > 0) {
                higher = half - 1;
            } else {
                return half;
            }
        }

        return -1;
    }

}

public class Main {
    
    public static void main(String[] args) {

        Sample sample = new Sample();

        // Binary Search
        sample.binarySearch(args, null);

    }

}
