package com.free.expense.manager.expensevault

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.free.expense.manager.expensevault.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}