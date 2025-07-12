package com.kubrayildirim.jetpackglanceexample

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.kubrayildirim.jetpackglanceexample.ui.theme.Pink80

class MyAppWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MyContent()
        }
    }

    @Composable
    private fun MyContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(color = Pink80)
                .padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                provider = ImageProvider(R.drawable.ic_widget),
                contentDescription = "App Icon",
                modifier = GlanceModifier
                    .size(48.dp)
                    .padding(bottom = 8.dp)
            )

            Text(
                text = "Jetpack Glance",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = GlanceModifier.padding(bottom = 4.dp)
            )

            Spacer(modifier = GlanceModifier.size(8.dp))
            Text(
                text = "Modern App Widgets with Compose!",
                style = TextStyle(
                    fontSize = 14.sp
                ),
                modifier = GlanceModifier.padding(bottom = 12.dp)
            )

            Button(
                text = "Open App",
                onClick = actionStartActivity<MainActivity>(),
                modifier = GlanceModifier.background(White)
            )
        }
    }
}


