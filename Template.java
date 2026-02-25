// Code is stored as 13template.java
2 import java.lang.Math.∗; import java.io.∗; import java.text.∗;
        3
        4 public class timeMethods{
5 public static int N = ....;
6 public static void main(String args[]){
        7
        8 DecimalFormat twoD = new DecimalFormat(”0.00”);
        9 DecimalFormat fourD = new DecimalFormat(”0.0000”);
        10 DecimalFormat fiveD = new DecimalFormat(”0.00000”);
        11
        12 long start, finish;
        13 double runTime = 0, runTime2 = 0, time;
        14 double totalTime = 0.0;
        15 int n = N;
        16 int repetition, repetitions = 30;
        17
        18 runTime = 0;
        19 for(repetition = 0; repetition < repetitions; repetition++) {
            20 start = System.currentTimeMillis();
            21
            22 // call the procedures to time here:
            23 linearsearch (...);
            24 binarysearch (...);
            25 // Figure out how to alter this guideline here,
            26
            27 finish = System.currentTimeMillis();
            28
            29 time = (double)(finish − start);
            30 runTime += time;
            31 runTime2 += (time∗time); }
        32
        33 double aveRuntime = runTime/repetitions;
        34 double stdDeviation =
                35 Math.sqrt(runTime2 − repetitions∗aveRuntime∗aveRuntime)/(repetitions−1);
        36
        37 System.out.printf(”\n\n\fStatistics\n”);
        38 System.out.println(”________________________________________________”);
        39 System.out.println(”Total time = ” + runTime/1000 + ”s.”);
        40 System.out.println(”Total time\u00b2 = ” + runTime2);
        41 System.out.println(”Average time = ” + fiveD.format(aveRuntime/1000)
        42 + ”s. ” + ’\u00B1’ + ” ” + fourD.format(stdDeviation) + ”ms.”);
        43 System.out.println(”Standard deviation = ” + fourD.format(stdDeviation));
        44 System.out.println(”n = ” + n);
        45 System.out.println(”Average time / run = ” + fiveD.format(aveRuntime/n∗1000)
        46 + ’\u00B5’ + ”s. ”);
        47
        48 System.out.println(”Repetitions = ” + repetitions);
        49 System.out.println(”________________________________________________”);
        50 System.out.println();
        51 System.out.println(); } }
52
        53 static void oneofyourMethods(int n,
54 yourMethodParameter1,
55 yourMethodParameter2, . . . ) {
    56 // The declarations and body of your method / s
    57 // The final statement of this code.} }