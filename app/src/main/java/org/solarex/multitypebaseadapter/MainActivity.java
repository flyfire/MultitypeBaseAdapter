package org.solarex.multitypebaseadapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import org.solarex.multitypebaseadapter.impl.Adapter;
import org.solarex.multitypebaseadapter.impl.PresenterImpl;
import org.solarex.multitypebaseadapter.impl.SolarexTouchListener;
import org.solarex.multitypebaseadapter.interfaces.BasePresenter;
import org.solarex.multitypebaseadapter.interfaces.IView;
import org.solarex.multitypebaseadapter.interfaces.ItemTouchMoveListener;
import org.solarex.multitypebaseadapter.model.Visitable;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener{
    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private BasePresenter mPresenter;
    private Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
        initOthers();
        initListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attachView(this);
        mPresenter.initData();
        ArrayList<Visitable> datas = mPresenter.getDatas();
        mAdapter = new Adapter(datas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    private void initViews() {
        mFab = (FloatingActionButton)findViewById(R.id.fab);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
    }

    private void initListener() {
        mFab.setOnClickListener(this);
        ItemTouchHelper.Callback callback = new SolarexTouchListener((ItemTouchMoveListener) mPresenter);
        new ItemTouchHelper(callback).attachToRecyclerView(mRecyclerView);
    }

    private void initOthers() {
        mPresenter = new PresenterImpl();
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab:
                mPresenter.addData();
                break;
            default:
                break;
        }

    }

    @Override
    public void notifyInserted(int position) {
        mAdapter.notifyItemInserted(position);
    }

    @Override
    public void notifyRemoved(int position) {
        mAdapter.notifyItemRemoved(position);
    }

    @Override
    public void notifySwaped(int from, int to) {
        mAdapter.notifyItemMoved(from, to);
    }
}
