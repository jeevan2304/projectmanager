package com.example.projectmanager.Activity

import android.content.Intent
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
import com.example.projectmanager.databinding.ActivityMainBinding
//import com.example.projectmanager.Activity.ProfileActivity


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
            // Initialize the adapter for ongoing items
            val ongoingAdapter by lazy { OngoingAdapter(mainViewModel.loadData()) }
            viewOngoing.apply {
                adapter = ongoingAdapter
                layoutManager = GridLayoutManager(this@DashboardActivity, 2)
            }

//            // Set up the click listener for the profile ImageView
//            imageprofile.setOnClickListener {
//                // Start ProfileActivity when the profile image is clicked
//                val intent = Intent(this@DashboardActivity, ProfileActivity::class.java)
//                startActivity(intent)
//            }
        }
    }
}
