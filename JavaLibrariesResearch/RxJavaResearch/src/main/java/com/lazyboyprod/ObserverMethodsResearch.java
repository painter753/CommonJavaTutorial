package com.lazyboyprod;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverMethodsResearch {

    public static void main(String[] args) {
        Observable<String> locations =
                Observable.just("Bucharest", "Krakow", "Moscow", "Kiev", "Sofia");

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Subscribed to" + disposable);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Length: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done.");
            }
        };

        locations.map(String::length)
                .subscribe(observer);
    }

}
