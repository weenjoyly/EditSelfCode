package com.example.editstock;


import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SelfcodeAdapter extends RecyclerView.Adapter implements View.OnScrollChangeListener {

    private List<List<String>> list;
    private Set<HorizontalScrollView> set;
    private int dx;

    public SelfcodeAdapter() {
        Observable.create(new ObservableOnSubscribe<List<List<String>>>() {
            @Override
            public void subscribe(ObservableEmitter<List<List<String>>> emitter) throws Exception {
                SelfcodeModel model = new SelfcodeModel();
                List<List<String>> list = model.getData();
                if (list == null) {
                    return;
                }
                emitter.onNext(list);
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<List<String>>>() {
            @Override
            public void accept(List<List<String>> o) throws Exception {
                update(o);
            }
        });
        set = new HashSet<>();
    }

    void update(List<List<String>> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.scroller_selfcode_item, viewGroup, false);
        return new SelfcodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        SelfcodeViewHolder selfcodeViewHolder = (SelfcodeViewHolder) viewHolder;
        selfcodeViewHolder.update(list.get(i));
        addHorizontalScrollView(selfcodeViewHolder.horizontalScrollView);
        selfcodeViewHolder.horizontalScrollView.scrollTo(dx, 0);
    }

    private void addHorizontalScrollView(HorizontalScrollView scrollView) {
        set.add(scrollView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scrollView.setOnScrollChangeListener(this);
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void scrollTo(int dx) {
        for (HorizontalScrollView scrollView : set) {
            scrollView.scrollTo(dx, 0);
        }
    }

    public void addHeadScrollerView(HorizontalScrollView scrollView) {
        addHorizontalScrollView(scrollView);
    }

    @Override
    public void onScrollChange(View v, final int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        scrollTo(scrollX);
        dx = scrollX;
    }

}
