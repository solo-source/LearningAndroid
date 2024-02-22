package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Status:", "onCreate Called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Status:","onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Status","onResume Called")
    }
    override fun onPause() {
        super.onPause()
        Log.d("Status:","onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Status","onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Status:","onDestroy Called")
    }
}