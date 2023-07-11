package com.example.dynamicchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.futured.donut.DonutProgressView
import app.futured.donut.DonutSection
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDonut(1000f,500f)

        val entries = listOf<Entry>(Entry(0f,100f) ,Entry(50f,300f) ,Entry(150f,500f),Entry(200f,100f),Entry(250f,200f))

        setLineChart(entries)

    }

    fun setDonut(maxValue: Float, current: Float) {
        val donut_view = findViewById<DonutProgressView>(R.id.donut_view)
        donut_view.cap = maxValue

        val section1 = DonutSection(
            name = "section_1",
            color = Color.parseColor("#2de923"),
            amount = current
        )
        donut_view.submitData(listOf(section1))
    }

    fun setLineChart(dataSetEntry: List<Entry>) {
        val lineChart = findViewById<LineChart>(R.id.LineChart)
        val dataSet = LineDataSet(dataSetEntry,"My Data")
        val linedata = LineData(dataSet)
        lineChart.setData(linedata)
        lineChart.setDrawGridBackground(false)
        lineChart.getAxisLeft().setDrawLabels(false);
        lineChart.getAxisRight().setDrawLabels(false);
        lineChart.getXAxis().setDrawLabels(false);

        lineChart.getLegend().setEnabled(false);   // Hide the legend

    }
}