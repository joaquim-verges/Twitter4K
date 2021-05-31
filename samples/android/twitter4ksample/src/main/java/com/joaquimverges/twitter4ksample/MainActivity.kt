package com.joaquimverges.twitter4ksample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.joaquimverges.twitter4k.Api
import com.joaquimverges.twitter4k.models.TweetFields
import com.joaquimverges.twitter4k.models.TweetRequestParams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var api: Api
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        api = Api(resources.getString(R.string.api_key))
        textView = findViewById(R.id.text_view)
        searchTweets()
    }

    fun searchTweets() {
        lifecycleScope.launchWhenStarted {
            textView.text = "Loading..."
            val tweets = withContext(Dispatchers.IO) {
                api.searchTweets("AndroidDev", TweetRequestParams(listOf(TweetFields.AUTHOR_ID, TweetFields.CREATED_AT)))
            }
            textView.text = tweets.map { it.authorId }.first()
        }
    }

    fun lookupUsers() {
        lifecycleScope.launchWhenStarted {
            textView.text = "Loading..."
            val tweets = withContext(Dispatchers.IO) {
                api.lookupUsers(listOf("2244994945"))
            }
            textView.text = tweets.map { it.username }.first()
        }
    }
}