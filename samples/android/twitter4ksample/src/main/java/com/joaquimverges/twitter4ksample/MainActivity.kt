package com.joaquimverges.twitter4ksample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.joaquim.library.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = "Loading..."
        lifecycleScope.launchWhenStarted {
            val tweets = withContext(Dispatchers.IO) {
                Api(resources.getString(R.string.api_key)).recentSearch("AndroidDev")
            }
            textView.text = tweets
        }
    }
}