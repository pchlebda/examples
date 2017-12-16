import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Observable<String> todoObservable = Observable.create(emitter -> {
            try {
                List<String> todos = getTodos();
                for (String String : todos) {
                    emitter.onNext(String);
                }
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        todoObservable.subscribe(e-> System.out.println(e));


        Observer<String> observer = todoObservable.subscribeWith(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("On subsribe " + d);
            }

            @Override
            public void onNext(String s) {
                System.out.printf("%s received %s in thread %s","Observer\n",s,Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                System.err.println(e);
            }

            @Override
            public void onComplete() {
                System.out.println("Observer end");
            }
        });

        DisposableObserver<String> disposableObserver = todoObservable.subscribeWith(new  DisposableObserver<String>() {

            @Override
            public void onNext(String t) {
                System.out.printf("%s received %s in thread %s","Observer\n",t,Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                System.err.println(e);
            }

            @Override
            public void onComplete() {
                System.out.println("DisposableObserver end");
            }
        });

        disposableObserver.dispose();

    }

    private static List<String> getTodos() {
        return Arrays.asList("A", "B", "C", "D", "E");
    }
}
