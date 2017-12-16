package async;

import rx.Observable;
import rx.schedulers.Schedulers;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Observable.just("long", "longer", "longest")
                .doOnNext(c -> System.out.println("processing item on thread " + Thread.currentThread()
                        .getName()))
                .subscribeOn(Schedulers.newThread())
                .map(String::length)
                .subscribe(length -> System.out.println("item length " + length));

        Thread.sleep(2000);
    }

}
