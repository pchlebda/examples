import io.reactivex.Observable;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RxJavaUnitTest {
    String result="";

    @Test
    public void returnAValue(){
        result = "";
        Observable<String> observer = Observable.just("Hello");
        observer.subscribe(s -> result=s);
        assertTrue(result.equals("Hello"));

    }

}
