package com.cjc.mpandroidcharttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private PieChart pieChart;
    private ArrayList<PieEntry> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListener();
    }

    private void init() {
        pieChart = findViewById(R.id.pieChart);
        pieChart.getDescription().setEnabled(false); //设置pieChart图表的描述
        pieChart.setBackgroundColor(Color.WHITE); //设置pieChart图表背景色
        pieChart.setRotationEnabled(true); //可以手动旋转
        pieChart.setDragDecelerationFrictionCoef(0.95f); //设置pieChart图表转动阻力摩擦系数[0,1]
        pieChart.setHighlightPerTapEnabled(true);  //设置piecahrt图表点击Item高亮是否可用
        pieChart.animateY(1400, Easing.EaseInOutQuad); // 设置pieChart图表展示动画效果
        Legend l = pieChart.getLegend();
        l.setEnabled(true); //是否启用图列（true：下面属性才有意义
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
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

        entries = new ArrayList<>();
        entries.add(new PieEntry(10, "人性的弱点"));
        entries.add(new PieEntry(12, "狼道"));
        entries.add(new PieEntry(17, "鬼谷子"));
        entries.add(new PieEntry(20, "YOUTH.度"));
        entries.add(new PieEntry(22, "週莫"));
        entries.add(new PieEntry(25, "墨菲定律"));

        PieDataSet dataSet = new PieDataSet(entries, "数据说明");
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
        dataSet.setValueFormatter(new PercentFormatter());


        pieChart.setData(pieData);


    }

    private void initListener() {

    }



}