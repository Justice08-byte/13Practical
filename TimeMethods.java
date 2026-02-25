import javax.sound.sampled.Line;
import java.lang.Math.*;
import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class TimeMethods{
    static class Node{
        int key;
        String data;
        Node(int key, String data){
            this.key = key;
            this.data = data;
        }
    }
    public static Node[] nodes;
    public static int N = 32654; // total expected keys
    static Random rand = new Random();
    // Linear Search
    public static int Linearsearch(int[] arr, int  target){
        int n = arr.length;
        for(int i = 0; i<n; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int Binarysearch(int[] arr, int target, int left, int right){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;
        int SearchesPerRun = 30;

        runTime = 0;

        for(int r = 0; r<repetitions; r++){
            int[] randomKeys = new int[SearchesPerRun];

            for(int i = 0; i<SearchesPerRun; i++){
                randomKeys[i] = 1 + rand.nextInt(32654);
            }

            //Linear Search Timing
            start = System.currentTimeMillis();
            for(int key:randomKeys){
                linearsearch(nodes, key);
            }
            finish = System.currentTimeMillis();
            time = (double)(finish - start);
            runTime += time;
            runTime2 += (time*time);

            //Binary Search Timing
            start = System.currentTimeMillis();
            for(int key: randomKeys){
               binarysearch(nodes, key);
            }
            time = (double)(finish - start);
            runTime += time;
            runTime2 += (time*time);
        }
        //Statistics
        double Average = runTime/ repetitions;
        double StdDev = Math.sqrt(runTime2-repetitions * runTime*runTime / (repetitions-1));

        System.out.printf("\n\n\fStatistics\n");
        System.out.println("________________________________________________");
        System.out.println("Total time = " + runTime/1000 + "s.");
        System.out.println("Total time\u00b2 = " + runTime2);
        System.out.println("Average time = "+ fiveD.format(Average/1000)+ "s. "+ '\u00B1' + "" + fourD.format(StdDev) + "ms.");
        System.out.println("Standard deviation = " + fourD.format(StdDev));
        System.out.println("n = " + n);
        System.out.println("Average time / run = " + fiveD.format(Average/n*1000) + '\u00B5' + "s. ");
        System.out.println("Repetitions = " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println();


    }

    private static void binarysearch(Node[] nodes, int key) {
    }

    private static void linearsearch(Node[] nodes, int key) {
    }
      // Load file into Array 
    public static Node[] loadFile(String[] filename) throws Exception{
        ArrayList<Node> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(Arrays.toString(filename)));
        String line;
        
        while((line = br.readLine()) != null){
            String[] parts = line.trim().split("\\s" + 2);
            
            int key = Integer.parseInt(parts[0]);
            String data = parts.length > 1 ? parts[1]:"";
            
            list.add(new Node(key, data));
        }
        br.close();
        Node[] arr = list.toArray(new Node[0]);
        



        return arr;
    }

    private static Comparator<? super Node> ComparatorInt(boolean b) {
        return null;
    }


}