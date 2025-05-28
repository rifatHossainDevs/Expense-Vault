package com.free.expense.manager.expensevault.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.free.expense.manager.expensevault.base.BaseFragment
import com.free.expense.manager.expensevault.databinding.FragmentHomeBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    lateinit var pieChart: PieChart

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pieChart = binding.pieChart
        showPieChart()
    }

    override fun setAllClickListener() {

    }

    override fun allObserver() {

    }

    private fun showPieChart() {
        val expenseListByCategory = ArrayList<PieEntry>()
        expenseListByCategory.add(PieEntry(100f, "Shopping"))
        expenseListByCategory.add(PieEntry(105f, "Lunch"))
        expenseListByCategory.add(PieEntry(80f, "Dinner"))
        expenseListByCategory.add(PieEntry(30f, "Drinks"))

        val pieDataSet = PieDataSet(expenseListByCategory, "")
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        pieDataSet.valueTextSize = 14f
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.setSliceSpace(2f)

        val valueFormatter = object : ValueFormatter() {
            @SuppressLint("DefaultLocale")
            override fun getFormattedValue(value: Float): String {
                return "৳${String.format("%.1f", value)}"
            }
        }
        pieDataSet.valueFormatter = valueFormatter

        val pieData = PieData(pieDataSet)
        pieChart.data = pieData
        pieChart.description.text = ""
        pieChart.centerText = "Expense"
        pieChart.setCenterTextSize(16f)
        pieChart.animateY(2000)

        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 35f
        pieChart.transparentCircleRadius = 30f
        pieChart.invalidate() // Refresh chart
    }
}
