package com.example.newsaggregator.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.OnConflictStrategy
import com.example.newsaggregator.data.rss.RssFeed
import com.example.newsaggregator.ui.theme.NewsAggregatorTheme
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.launch
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType
import retrofit2.Retrofit

private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.theguardian.com")
    .addConverterFactory(
        XML.asConverterFactory(
            MediaType.get("application/xml; charset=UTF8")
        )
    ).build()

private val guardian = retrofit.create(RssFeed::class.java)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAggregatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OnConflictStrategy.ABORT
                    Greeting(
                        text = "Press me!",
                        modifier = Modifier.padding(innerPadding),
                        guardian,
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    text: String,
    modifier: Modifier = Modifier,
    feed: RssFeed,
) {
    val scope = rememberCoroutineScope()
    Button(
        onClick = {
            Log.d("happy", "done")
            scope.launch {
                val r = feed.getRss()
                r.channel.items.forEach {
                    Log.d("link", it.link)  // https://www.theguardian.com/film/2025/may/22/grifter-loneliness-is-not-for-me-any-more-julia-stiles-on-dance-dexter-and-her-directorial-debut
                    Log.d("guid", it.guid) // https://www.theguardian.com/film/2025/may/22/grifter-loneliness-is-not-for-me-any-more-julia-stiles-on-dance-dexter-and-her-directorial-debut
                    Log.d("dcDate", it.dcDate)
                    Log.d("pubDate", it.pubDate)
                    Log.d("pubDate", it.description)
                    it.contents.forEach { c ->
                        Log.d("c-url", c.url)
                        Log.d("c-type", c.type ?: "null")
                        Log.d("c-width", c.width ?: "null")
                        Log.d("c-credit", c.credit.toString())
                    }
                    Log.d("c-credit", "-------------------------------")
                }
            }
        }
    ) {
        Text(
            text = text,
            modifier = modifier,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAggregatorTheme {
        Greeting(
            text = "Press me!",
            feed = guardian
        )
    }
}