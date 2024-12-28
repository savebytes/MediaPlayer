@file:OptIn(ExperimentalFoundationApi::class)

package com.example.mediaplayer

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mediaplayer.models.AudioData
import com.example.mediaplayer.ui.theme.MediaPlayerTheme
import com.example.mediaplayer.views.AudioListScreen
import com.example.mediaplayer.views.PreviewItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : ComponentActivity() {

    private var mAudioListData: List<AudioData>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadJsonData(this)

        setContent {
            MediaPlayerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { if (!mAudioListData.isNullOrEmpty()) {
                    AudioListScreen(mAudioListData!!)
                } else {
                    PreviewItem()
                }

                }
            }
        }
    }

    fun clickAction(){
        //
    }

    private fun loadJsonData(context: Context): List<AudioData>? {
        // Read the JSON file from assets
        val inputStream = context.resources.openRawResource(R.raw.data)
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        // Convert JSON string to a list of Item objects
        val gson = Gson()
        val listType = object : TypeToken<List<AudioData>>() {}.type
        mAudioListData = gson.fromJson(jsonString, listType)
        Log.d("TAG", "loadJsonData: $mAudioListData")
        return mAudioListData
    }

}

/*
@Composable
fun MyTabLayout() {

    val tabItems = listOf(
        TabItem(title = "Audio"),
        TabItem(title = "Video"),
    )
    var selectedTab by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedTab) {
        pagerState.animateScrollToPage(selectedTab)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress){
            selectedTab = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        TabRow(selectedTabIndex = selectedTab) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == selectedTab,
                    onClick = {
                        selectedTab = index
                    },
                    text = {
                        Text(
                            tabItem.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.W700
                        )
                    },
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                //
            }

        }
    }
}*/

/*
data class TabItem(
    val title: String,
)
*/
