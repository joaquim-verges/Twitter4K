package com.joaquimverges.twitter4ksample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joaquim.library.Api
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val tweets = Api(resources.getString(R.string.api_key)).recentSearch("AndroidDev")
            Log.i("Twitter4K", tweets)
        }

    }
}