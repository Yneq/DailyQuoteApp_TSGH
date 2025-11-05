package com.example.dailyquoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyQuoteApp()
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DailyQuoteApp(viewModel: QuoteViewModel = viewModel()) {
    val quote = viewModel.quote
    val isLoading = viewModel.isLoading
    val errorMessage = viewModel.errorMessage

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("每日金句 ✨", color = Color.White)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF4682B4)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0x88FFE0B2),
                            Color(0x88FFD580),
                            Color(0xFF4682B4)
                        )
                    )
                )
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Everyday Quotes ✨",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.padding(top = 60.dp, bottom = 40.dp)
            )
            // 以 quote 的 id 當成動畫 target
            AnimatedContent(
                targetState = quote?._id ?: "", // id 改變就觸發動畫
                transitionSpec = {
                    (fadeIn(animationSpec = tween(280)) + slideInVertically(animationSpec = tween(280)) { it / 3 })
                        .togetherWith(
                            fadeOut(animationSpec = tween(200)) + slideOutVertically(animationSpec = tween(200)) { -it / 3 }
                        )
                },
                label = "quote-change"
            ) {
                when {
                    isLoading -> {
                        CircularProgressIndicator(color = Color.Blue)
                    }
                    errorMessage != null -> {
                        Text(text = errorMessage ?: "", color = Color.White)
                    }
                    quote != null -> {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "\"${quote!!.content}\"",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )
                            Text(
                                text = "- ${quote!!.author}",
                                fontSize = 18.sp,
                                color = Color.Black.copy(alpha = 0.85f)
                            )
                        }
                    }
                    else -> {
                        // 初始沒有資料時的佔位
                        Text(text = "載入中...", color = Color.White)
                    }
                }
            }


            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { viewModel.fetchQuote() },
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(  // ✨ 自訂按鈕顏色
                    containerColor = Color.White,
                    contentColor = Color(0xFF6A11CB) // 載入時按鈕反灰不能重覆按
                )
            ) {
                Text("再來一句")
            }
        }
    }
}