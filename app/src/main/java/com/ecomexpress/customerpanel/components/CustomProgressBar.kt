package com.ecomexpress.customerpanel.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun CircularProgressBar(
    progress: Float,
    progressColor: Color,
    backgroundColor: Color,
    strokeWidth: Float = 8f,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                val canvasSize = Size(size.width, size.height)
                val center = Offset(canvasSize.width / 2f, canvasSize.height / 2f)
                val radius = canvasSize.width / 2f - strokeWidth / 2f
                val startAngle = -90f

                drawArc(
                    color = backgroundColor,
                    startAngle = startAngle,
                    sweepAngle = 360f,
                    useCenter = false,
                    topLeft = center - Offset(radius, radius),
                    size = Size(radius * 2f, radius * 2f),
                    style = Stroke(strokeWidth)
                )

                drawArc(
                    color = progressColor,
                    startAngle = startAngle,
                    sweepAngle = progress * 360f,
                    useCenter = false,
                    topLeft = center - Offset(radius, radius),
                    size = Size(radius * 2f, radius * 2f),
                    style = Stroke(strokeWidth)
                )
            }
        )
        Text(
            text = "${(progress * 100).toInt()}%",
            style = MaterialTheme.typography.h6,
            color = progressColor,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
