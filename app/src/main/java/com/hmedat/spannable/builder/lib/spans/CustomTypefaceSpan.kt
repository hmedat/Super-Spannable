package com.hmedat.spannable.builder.lib.spans

import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.TypefaceSpan

/**
 * https://stackoverflow.com/a/4826885
 */
class CustomTypefaceSpan(private val newType: Typeface) : TypefaceSpan("") {

    companion object {
        private const val TEXT_SKEW = -0.25f
    }

    override fun updateDrawState(ds: TextPaint) {
        applyCustomTypeFace(ds, newType)
    }

    override fun updateMeasureState(paint: TextPaint) {
        applyCustomTypeFace(paint, newType)
    }

    private fun applyCustomTypeFace(paint: Paint, tf: Typeface) {
        val oldStyle: Int
        val old = paint.typeface
        oldStyle = old?.style ?: 0
        val fake = oldStyle and tf.style.inv()
        if (fake and Typeface.BOLD != 0) {
            paint.isFakeBoldText = true
        }
        if (fake and Typeface.ITALIC != 0) {
            paint.textSkewX = TEXT_SKEW
        }
        paint.typeface = tf
    }
}
