package finalExplored;

import finalExplored.generic.BaseClass;
import finalExplored.specific.ChildClass;

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

        System.out.println("-------------------");
        parent.recommendedStatic();
        System.out.println("-----------------");
        childReferredToAsBase.recommendedStatic();
        System.out.println("-----------------");
        child.recommendedStatic();
    }
}
