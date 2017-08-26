package com.example.finefinecom.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d(TAG, "onCreate: "+Thread.currentThread().getName());

//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.d(TAG, "subscribe: Observable thread is:"+Thread.currentThread().getName());
//                Log.d(TAG, "subscribe: emit 1");
//                e.onNext(1);
//            }
//        });
//
//        Consumer<Integer> consumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.d(TAG, "accept: Observer thread is:"+Thread.currentThread().getName());
//                Log.d(TAG, "accept: "+integer);
//            }
//        };
//
//
//        observable.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Function<Integer, String>() {
//                    @Override
//                    public String apply(Integer integer) throws Exception {
//                        return "This is result"+integer;
//                    }
//                })
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        Log.d(TAG, "accept: "+s);
//                    }
//                });
    }


//    Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//        @Override
//        public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//            e.onNext(1);
//            e.onNext(2);
//            e.onNext(3);
//            e.onComplete();
//        }
//    });
//
//
//
//
//
//    Observer<Integer> observer = new Observer<Integer>() {
//        @Override
//        public void onSubscribe(Disposable d) {
//            Log.d(TAG, "onSubscribe: ");
//        }
//
//        @Override
//        public void onNext(Integer value) {
//            Log.d(TAG, "onNext: "+value);
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            Log.d(TAG, "onError: ");
//        }
//
//        @Override
//        public void onComplete() {
//            Log.d(TAG, "onComplete: ");
//        }
//    };

    public void click(View v)
    {
//        observable.safeSubscribe(observer);
        
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
                e.onNext(4);
                
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                final List<String> list =new ArrayList<String>();
                for (int i = 0;i<3;i++)
                {
                    list.add("I am value "+integer);
                }

                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "accept: "+s);
            }
        });
    }


}
