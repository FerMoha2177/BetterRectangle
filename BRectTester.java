
public class BRectTester {

    public static void main(String[] args)
    {
        final int NEGTHREE = -3;
        final int THREE = 3;
        final int FOUR = 4;

        BetterRectangle bRectA = new BetterRectangle(FOUR,THREE);
        BetterRectangle bRectB   = new BetterRectangle(bRectA);
        BetterRectangle bRectC = new BetterRectangle(1,1,THREE,FOUR);
        BetterRectangle bRectD = new BetterRectangle();

        //using all accessors for "custom" BetterTriangle

        System.out.print("BRecTA    ");
        System.out.println(bRectA.toString());
        printExpectedBRectA();

        //utility methods with origin & copy

        //printUtility(bRectB,bRectC);
        System.out.println("For bRectB to bRectC\n" + bRectB.toString(bRectC));

        //mutator method
        System.out.println("bRectD  "+bRectD.toString());
        printExpectedBRectD();
        boolean resultOFScale1 = bRectD.scaleBy(THREE);
        System.out.println("bRectD scale by 3 (expected to be true) :" + resultOFScale1);
        System.out.println("====================================================");
        System.out.println("New bRectD after scale: " + bRectD.toString());
        boolean resultOFScale2 = bRectD.scaleBy(NEGTHREE);
        System.out.println("bRectD scale by -3(Expected to be false):" + resultOFScale2);
    }
    public static void printUtility(BetterRectangle r1, BetterRectangle r2)
    {
        System.out.println("====================================================");
        System.out.println("BRectB  "+r1.toString());
        System.out.println("====================================================");
        printExpectedBRectB();
        System.out.println("====================================================");
        System.out.println("BRectC  "+r2.toString());
        System.out.println("====================================================");
        printExpectedBRectC();
        System.out.println("====================================================");
        System.out.println("Are BRectB and BRectC Congruent ? (Expected to be false) : " + r1.isCongruent(r2));
        System.out.println("Are BRectB and BRectC Equivalent? (Expected to be true ) : " + r1.isEquivalent(r2));
        System.out.println("Are BRectB and BRectC Similar?    (Expected to be true ) : " + r1.isSimilar(r2));
        System.out.println("Are BRectB and BRectC Concentric? (Expected to be false) : " + r1.isConcentric(r2));
        System.out.println("Are BRectB and BRectC EQUAL?      (Expected to be false) : " + r1.equals(r2));
        System.out.println("====================================================");
    }

    public static void printExpectedBRectA()
    {
        System.out.println("====================================================");
        System.out.println("Expected Results for BRectA");
        System.out.println("Area      :");
        System.out.println("Width     : 4.0");
        System.out.println("Height    : 3.0");
        System.out.println("Perimeter : 14.0");
        System.out.println("Slope     : .75");
        System.out.println("MidPoint  : (2.0,-1.5)");
        System.out.println("Lower Left Point:(0.0,-3.0)" );
        System.out.println("====================================================");
    }
    public static void printExpectedBRectB()
    {
        System.out.println("====================================================");
        System.out.println("Expected Results for BRectB");
        System.out.println("Area            : 12.0");
        System.out.println("Width           : 4.0");
        System.out.println("Height          : 3.0");
        System.out.println("Perimeter       : 14.0");
        System.out.println("Slope           : .75");
        System.out.println("MidPoint        : (2.0,-1.5)");
        System.out.println("Lower Left Point:(0.0,-3.0)" );
        System.out.println("====================================================");
    }
    public static void printExpectedBRectC()
    {
        System.out.println("====================================================");
        System.out.println("Expected Results for BRectC");
        System.out.println("Area            : 12.0");
        System.out.println("Width           : 3.0");
        System.out.println("Height          : 4.0");
        System.out.println("Perimeter       : 14.0");
        System.out.println("Slope           : 1.3333333333333");
        System.out.println("MidPoint        : (1.5,-2.0)");
        System.out.println("Lower Left Point: (1.0,-3.0)" );
        System.out.println("====================================================");
    }
    public static void printExpectedBRectD()
    {
        System.out.println("====================================================");
        System.out.println("Expected Results for BRectD");
        System.out.println("Area            : 1.0");
        System.out.println("Width           : 1.0");
        System.out.println("Height          : 1.0");
        System.out.println("Perimeter       : 4.0");
        System.out.println("Slope           : 1.0");
        System.out.println("MidPoint        : (0.5 , -0.5)");
        System.out.println("Lower Left Point: (0 , -1.0)" );
        System.out.println("====================================================");

    }

}
