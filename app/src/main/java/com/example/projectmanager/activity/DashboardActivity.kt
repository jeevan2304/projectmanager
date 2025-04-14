package com.example.projectmanager.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projectmanager.Adapter.OngoingAdapter
import com.example.projectmanager.R
import com.example.projectmanager.ViewModel.MainViewModel
import com.example.projectmanager.databinding.ActivityMainBinding // ✅ Correct binding import

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            val ongoingAdapter by lazy { OngoingAdapter(mainViewModel.loadData()) }
            viewOngoing.apply {
                adapter = ongoingAdapter
                layoutManager = GridLayoutManager(this@DashboardActivity, 2)
            }
        }
    }
}
