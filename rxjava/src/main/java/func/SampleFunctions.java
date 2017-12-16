package func;

import rx.functions.Action1;
import rx.functions.Func1;

import java.util.concurrent.Callable;

public class SampleFunctions {


    public static Callable<Integer> thatReturnsNumberOne() {
        return () -> {
            System.out.println("Observable thread" + Thread.currentThread()
                    .getName());

            return 1;
        };
    }

    public static Func1<Integer, String> numberToString() {
        return number -> {
            System.out.println("Operator thread" + Thread.currentThread()
                    .getName());
            return String.valueOf(number);
        };
    }

    public static Action1<String> printResult() {
        return result -> {
            System.out.println("Operator thread" + Thread.currentThread()
                    .getName());
            System.out.println("Result: " + result);
        };
    }

}
