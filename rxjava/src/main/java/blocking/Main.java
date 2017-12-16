package blocking;

import func.SampleFunctions;
import rx.Observable;

public class Main {

    public static void main(String[] args) {
        Observable.fromCallable(SampleFunctions.thatReturnsNumberOne())
                .map(SampleFunctions.numberToString())
                .subscribe(SampleFunctions.printResult());

    }

}
