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

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    @BindView(R.id.tv_select_time)
    TextView tvSelectTime;


    private String uname;
    private TimePickerView pvTime;
    private View view;
    private String time;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_chart, null);
        ButterKnife.bind(this, view);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        String inittime = df.format(new Date());
        time=inittime;
        tvSelectTime.setText(inittime);
        initPieIn();
        initPieOut();
        uname = getUname();
        initChart();
        initData();
        initListener();
        initTimePicker1();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initChart();
    }

    @Override
    public void onStart() {
        super.onStart();
        initChart();
    }

    private void initChart() {
        if (uname == null) {
            piechartOut.setVisibility(View.GONE);
            piechartIn.setVisibility(View.GONE);
        } else {
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
        l.setEnabled(false); //是否启用图列 true：下面属性才有意义
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
                float sumgouwu = 0;
                float sumgongzi = 0;
                float sumzufang = 0;
                float sumxuexi = 0;
                float sumlvyou = 0;
                float sumjiaotong = 0;
                float sumyingshi = 0;
                float sumyiliao = 0;
                float sumqita = 0;
                entriesout.clear();
                Log.d("ChartFragment", "" + accountEntities);
                for (AccountEntity accountEntity : accountEntities) {
//                    float accountMoney = Float.parseFloat((accountEntity.getAccountMoney()).toString());
////                    entriesout.add(new PieEntry(accountMoney,accountEntity.getAccountType()));
////                    piechartOut.notifyDataSetChanged();
                    if (accountEntity.getAccountType().equals("购物")) {
                        sumgouwu += accountEntity.getAccountMoney();
                        float accountMoney = Float.parseFloat((accountEntity.getAccountMoney()).toString());


                    } else if (accountEntity.getAccountType().equals("工资")) {
                        sumgongzi += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("租房")) {
                        sumzufang += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("学习")) {
                        sumxuexi += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("旅游")) {
                        sumlvyou += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("交通")) {
                        sumjiaotong += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("饮食")) {
                        sumyingshi += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("医疗")) {
                        sumyiliao += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("其他消费")) {
                        sumqita += accountEntity.getAccountMoney();


                    }
                    entriesout.clear();
                    if (sumgouwu != 0.0f) {
                        entriesout.add(new PieEntry(sumgouwu, "购物"));
                    }
                    if (sumgongzi != 0.0f) {
                        entriesout.add(new PieEntry(sumgongzi, "工资"));
                    }
                    if (sumzufang != 0.0f) {
                        entriesout.add(new PieEntry(sumzufang, "租房"));
                    }
                    if (sumxuexi != 0.0f) {
                        entriesout.add(new PieEntry(sumxuexi, "学习"));
                    }
                    if (sumlvyou != 0.0f) {
                        entriesout.add(new PieEntry(sumlvyou, "旅游"));
                    }
                    if (sumjiaotong != 0.0f) {
                        entriesout.add(new PieEntry(sumjiaotong, "交通"));
                    }
                    if (sumyingshi != 0.0f) {
                        entriesout.add(new PieEntry(sumyingshi, "饮食"));
                    }
                    if (sumyiliao != 0.0f) {
                        entriesout.add(new PieEntry(sumyiliao, "医疗"));
                    }
                    if (sumqita != 0.0f) {
                        entriesout.add(new PieEntry(sumqita, "其他消费"));
                    }

                    piechartIn.notifyDataSetChanged();
                }
            }
        }, "收入", uname,time);

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
        l.setEnabled(false); //是否启用图列 true：下面属性才有意义
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
                float sumgouwu = 0;
                float sumgongzi = 0;
                float sumzufang = 0;
                float sumxuexi = 0;
                float sumlvyou = 0;
                float sumjiaotong = 0;
                float sumyingshi = 0;
                float sumyiliao = 0;
                float sumqita = 0;
                entriesout.clear();
                Log.d("ChartFragment", "" + accountEntities);
                for (AccountEntity accountEntity : accountEntities) {
//                    float accountMoney = Float.parseFloat((accountEntity.getAccountMoney()).toString());
////                    entriesout.add(new PieEntry(accountMoney,accountEntity.getAccountType()));
////                    piechartOut.notifyDataSetChanged();
                    if (accountEntity.getAccountType().equals("购物")) {
                        sumgouwu += accountEntity.getAccountMoney();
                        float accountMoney = Float.parseFloat((accountEntity.getAccountMoney()).toString());


                    } else if (accountEntity.getAccountType().equals("工资")) {
                        sumgongzi += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("租房")) {
                        sumzufang += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("学习")) {
                        sumxuexi += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("旅游")) {
                        sumlvyou += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("交通")) {
                        sumjiaotong += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("饮食")) {
                        sumyingshi += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("医疗")) {
                        sumyiliao += accountEntity.getAccountMoney();


                    } else if (accountEntity.getAccountType().equals("其他消费")) {
                        sumqita += accountEntity.getAccountMoney();


                    }
                    entriesout.clear();
                    if (sumgouwu != 0.0f) {
                        entriesout.add(new PieEntry(sumgouwu, "购物"));
                    }
                    if (sumgongzi != 0.0f) {
                        entriesout.add(new PieEntry(sumgongzi, "工资"));
                    }
                    if (sumzufang != 0.0f) {
                        entriesout.add(new PieEntry(sumzufang, "租房"));
                    }
                    if (sumxuexi != 0.0f) {
                        entriesout.add(new PieEntry(sumxuexi, "学习"));
                    }
                    if (sumlvyou != 0.0f) {
                        entriesout.add(new PieEntry(sumlvyou, "旅游"));
                    }
                    if (sumjiaotong != 0.0f) {
                        entriesout.add(new PieEntry(sumjiaotong, "交通"));
                    }
                    if (sumyingshi != 0.0f) {
                        entriesout.add(new PieEntry(sumyingshi, "饮食"));
                    }
                    if (sumyiliao != 0.0f) {
                        entriesout.add(new PieEntry(sumyiliao, "医疗"));
                    }
                    if (sumqita != 0.0f) {
                        entriesout.add(new PieEntry(sumqita, "其他消费"));
                    }

                    piechartOut.notifyDataSetChanged();
                }
            }
        }, "支出", uname,time);

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
        tvSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.show();
            }
        });

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

    private void initTimePicker1() {//选择出生年月日


        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        //startDate.set(2013,1,1);
        Calendar endDate = Calendar.getInstance();
        //endDate.set(2020,1,1);

        //正确设置方式 原因：注意事项有说明
        startDate.set(2013, 0, 1);
        endDate.set(2021, 11, 31);

        pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
                time = simpleDateFormat.format(date);
                tvSelectTime.setText(time);
                initPieIn();
                initPieOut();
            }
        })
                .setType(new boolean[]{true, true, false, false, false, false})// 默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确认")//确认按钮文字
                .setTitleSize(20)//标题文字大小
                .setTitleText("")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(getResources().getColor(R.color.colorOrange))//确定按钮文字颜色
                .setCancelColor(getResources().getColor(R.color.colorOrange))//取消按钮文字颜色
                .setTitleBgColor(Color.WHITE)//标题背景颜色 Night mode
                .setBgColor(Color.WHITE)//滚轮背景颜色 Night mode
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setLabel("年", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式
                .build();

    }
}
