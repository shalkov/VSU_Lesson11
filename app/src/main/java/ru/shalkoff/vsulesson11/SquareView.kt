package ru.shalkoff.vsulesson11

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SquareView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private var squareColor = Color.RED

    fun changeColorToBlue() {
        squareColor = Color.BLUE
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = squareColor
        paint.style = Paint.Style.FILL

        val squareSize = resources.displayMetrics.density * 100f // Размер квадрата в пикселях
        val startX = (width - squareSize) / 2 // Начальная координата X
        val startY = (height - squareSize) / 2 // Начальная координата Y
        canvas.drawRect(
            startX,
            startY,
            startX + squareSize,
            startY + squareSize,
            paint
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // Измерение размера представления
        val desiredSize = (resources.displayMetrics.density * 100).toInt()
        val width = resolveSize(desiredSize, widthMeasureSpec)
        val height = resolveSize(desiredSize, heightMeasureSpec)

        // Установка измеренного размера
        setMeasuredDimension(width, height)
    }
}