package com.example.nycopendata.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Dependency injection library that reduces creating manual dependency injections
@HiltAndroidApp
class NycApp: Application() {
}