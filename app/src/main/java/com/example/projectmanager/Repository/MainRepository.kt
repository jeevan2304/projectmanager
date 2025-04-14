package com.example.projectmanager.Repository

import com.example.projectmanager.Domain.OngoingDomain

class MainRepository {
    val items = listOf(
        OngoingDomain("Food App", "June 12, 2023", 50 , "ongoing1"),
        OngoingDomain("AI Recoding", "June 26, 2023", 60 , "ongoing2"),
        OngoingDomain("Weather App", "July 22, 2023", 25 , "ongoing3"),
        OngoingDomain("E-Book App", "June 13, 2023", 80 , "ongoing4")
    )
}