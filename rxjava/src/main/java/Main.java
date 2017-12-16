import rx.Observable;
import rx.Subscriber;

public class Main {

    public static void main(String[] args) {

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try{
                    String result = "some";
                    Thread.sleep(1000);
                    subscriber.onNext(result);
                    subscriber.onCompleted();
                }catch(Exception e){
                    subscriber.onError(e);
                }
            }
        });

        
    }

}
