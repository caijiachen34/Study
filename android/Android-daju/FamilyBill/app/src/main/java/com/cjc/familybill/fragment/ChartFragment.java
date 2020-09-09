package com.cjc.familybill.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.entity.AccountEntity;
import com.cjc.familybill.http.presenter.AccountPresenter;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class ChartFragment extends BaseFragment {
    @BindView(R.id.chart_out)
    TextView chartOut;
    @BindView(R.id.chart_in)
    TextView chartIn;
    @BindView(R.id.piechart_out)
    PieChart piechartOut;
    @BindView(R.id.piechart_in)
    PieChart piechartIn;


    private String uname;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chart, null);
        ButterKnife.bind(this, view);
        uname = getUname();
        initChart();
        initData();
        initListener();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initChart();
    }

    private void initChart() {
        if (uname == null) {
            piechartOut.setVisibility(View.GONE);
            piechartIn.setVisibility(View.GONE);
        }else{
            piechartOut.setVisibility(View.VISIBLE);
            initPieOut();
            chartOut.setTextColor(Color.parseColor("#FF9900"));
            piechartIn.setVisibility(View.GONE);
        }
    }

    private void initPieIn() {
        ArrayList<PieEntry> entriesout;
        piechartIn.getDescription().setEnabled(false); //设置pieChart图表的描述
        piechartIn.setBackgroundColor(getResources().getColor(R.color.pieChartColor)); //设置pieChart图表背景色
        piechartIn.setRotationEnabled(true); //可以手动旋转
        piechartIn.setDragDecelerationFrictionCoef(0.95f); //设置pieChart图表转动阻力摩擦系数[0,1]
        piechartIn.setHighlightPerTapEnabled(true);  //设置piecahrt图表点击Item高亮是否可用
        piechartIn.animateY(1400, Easing.EaseInOutQuad); // 设置pieChart图表展示动画效果
        piechartIn.setUsePercentValues(true);
        Legend l = piechartIn.getLegend();
        l.setEnabled(true); //是否启用图列 true：下面属性才有意义
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setForm(Legend.LegendForm.DEFAULT); //设置图例的形状
        l.setFormSize(10);  //设置图例的大小
        l.setFormToTextSpace(10f); //设置每个图例实体中标签和形状之间的间距
        l.setDrawInside(false);
        l.setWordWrapEnabled(true); //设置图列换行(注意使用影响性能,仅适用legend位于图表下面)
        l.setXEntrySpace(10f); //设置图例实体之间延X轴的间距（setOrientation = HORIZONTAL有效）
        l.setYEntrySpace(8f); //设置图例实体之间延Y轴的间距（setOrientation = VERTICAL 有效）
        l.setYOffset(0f); //设置比例块Y轴偏移量
        l.setTextSize(14f); //设置图例标签文本的大小
        l.setTextColor(Color.parseColor("#333333")); //设置图例标签文本的颜色



        entriesout = new ArrayList<>();
        AccountPresenter.queryAccUnamePayType(new Subscriber<List<AccountEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AccountEntity> accountEntities) {
                entriesout.clear();
                Log.d("ChartFragment", "" + accountEntities);
                for (AccountEntity accountEntity : accountEntities) {
                    String accountMoney = (accountEntity.getAccountMoney()).toString();
                    entriesout.add(new PieEntry(Float.parseFloat(accountMoney),accountEntity.getAccountType()));
                    piechartIn.notifyDataSetChanged();
                }
            }
        },"收入",uname);

        PieDataSet dataSet = new PieDataSet(entriesout, "数据说明");
        dataSet.setDrawIcons(false);

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.JOYFUL_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.COLORFUL_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.LIBERTY_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.PASTEL_COLORS) {
            colors.add(c);
        }

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);


        PieData pieData = new PieData(dataSet);
        pieData.setDrawValues(true);
        pieData.setValueTextSize(12f);
        pieData.setValueTypeface(Typeface.DEFAULT);
        dataSet.setValueFormatter(new PercentFormatter(piechartIn));


        piechartIn.setData(pieData);
        piechartIn.invalidate();

    }

    private void initPieOut() {
        ArrayList<PieEntry> entriesout;
        piechartOut.getDescription().setEnabled(false); //设置pieChart图表的描述
        piechartOut.setBackgroundColor(getResources().getColor(R.color.pieChartColor)); //设置pieChart图表背景色
        piechartOut.setRotationEnabled(true); //可以手动旋转
        piechartOut.setDragDecelerationFrictionCoef(0.95f); //设置pieChart图表转动阻力摩擦系数[0,1]
        piechartOut.setHighlightPerTapEnabled(true);  //设置piecahrt图表点击Item高亮是否可用
        piechartOut.animateY(1400, Easing.EaseInOutQuad); // 设置pieChart图表展示动画效果
        piechartOut.setUsePercentValues(true);
        Legend l = piechartOut.getLegend();
        l.setEnabled(true); //是否启用图列 true：下面属性才有意义
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setForm(Legend.LegendForm.DEFAULT); //设置图例的形状
        l.setFormSize(10);  //设置图例的大小
        l.setFormToTextSpace(10f); //设置每个图例实体中标签和形状之间的间距
        l.setDrawInside(false);
        l.setWordWrapEnabled(true); //设置图列换行(注意使用影响性能,仅适用legend位于图表下面)
        l.setXEntrySpace(10f); //设置图例实体之间延X轴的间距（setOrientation = HORIZONTAL有效）
        l.setYEntrySpace(8f); //设置图例实体之间延Y轴的间距（setOrientation = VERTICAL 有效）
        l.setYOffset(0f); //设置比例块Y轴偏移量
        l.setTextSize(14f); //设置图例标签文本的大小
        l.setTextColor(Color.parseColor("#333333")); //设置图例标签文本的颜色



        entriesout = new ArrayList<>();
        AccountPresenter.queryAccUnamePayType(new Subscriber<List<AccountEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AccountEntity> accountEntities) {
                entriesout.clear();
                Log.d("ChartFragment", "" + accountEntities);
                for (AccountEntity accountEntity : accountEntities) {
                    String accountMoney = (accountEntity.getAccountMoney()).toString();
                    entriesout.add(new PieEntry(Float.parseFloat(accountMoney),accountEntity.getAccountType()));
                    piechartOut.notifyDataSetChanged();
                }
            }
        },"支出",uname);

        PieDataSet dataSet = new PieDataSet(entriesout, "数据说明");
        dataSet.setDrawIcons(false);

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.JOYFUL_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.COLORFUL_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.LIBERTY_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.PASTEL_COLORS) {
            colors.add(c);
        }

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);


        PieData pieData = new PieData(dataSet);
        pieData.setDrawValues(true);
        pieData.setValueTextSize(12f);
        pieData.setValueTypeface(Typeface.DEFAULT);
        dataSet.setValueFormatter(new PercentFormatter(piechartOut));


        piechartOut.setData(pieData);
        piechartOut.invalidate();

    }

    private void initData() {

    }

    private void initListener() {
        chartOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chartOut.setTextColor(Color.parseColor("#FF9900"));
                piechartIn.setVisibility(View.GONE);
                piechartOut.setVisibility(View.VISIBLE);
                chartIn.setTextColor(0xFF000000);
                initPieOut();
            }
        });

        chartIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPieIn();
                chartIn.setTextColor(Color.parseColor("#FF9900"));
                piechartOut.setVisibility(View.GONE);
                piechartIn.setVisibility(View.VISIBLE);
                chartOut.setTextColor(0xFF000000);

            }
        });
    }
}
