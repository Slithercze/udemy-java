package finalExplored;

import finalExplored.generic.BaseClass;
import finalExplored.specific.ChildClass;
import finalExplored.util.Logger;

public class Main {

    public static void main(String[] args) {

        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("-----------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("-----------------");
        child.recommendedMethod();

        System.out.println("-------------------"); //its better to access static methods with CLASS name not references
        parent.recommendedStatic();
        System.out.println("-----------------");
        childReferredToAsBase.recommendedStatic();
        System.out.println("-----------------");
        child.recommendedStatic(); //hiding vs overriding this is hiding

        System.out.println("-----------------");
        BaseClass.recommendedStatic();
        System.out.println("-");
        ChildClass.recommendedStatic();

        String xArgument = "This is all I've got to say about Section ";
        StringBuilder zArgument = new StringBuilder("Only saying this: Section ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("After Method, xArgument " + xArgument);
        System.out.println("After Method, zArgument " + zArgument);

        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", Step 2 is xyz.");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = " + tracker);
    }

    private static void doXYZ( String x, int y, final StringBuilder z) { //adding final to parameter wont make it immutable but you cant reassign new value

        final String c = x + y;
        System.out.println("c = " + c);
        x = c;
        z.append(y);
       // z = new StringBuilder("This is a new reference");
    }
}