package com.hmedat.spannable.builder.lib.options

import android.content.Context
import android.graphics.Typeface.NORMAL
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.annotation.IntDef
import android.support.v4.content.ContextCompat
import android.text.style.ImageSpan


class ImageSpanOption(private val context: Context, @DrawableRes val id: Int) {
    companion object {
        private const val DEFAULT_IMAGE_HQ = 24

        @IntDef(ImageSpan.ALIGN_BOTTOM, ImageSpan.ALIGN_BASELINE)
        annotation class ImageSpanAlignment
    }


    var size = DEFAULT_IMAGE_HQ
        private set
    @ImageSpanAlignment
    var verticalAlignment = ImageSpan.ALIGN_BASELINE
        private set
    var tintColor = 0
        private set

    fun size(@DimenRes resSizId: Int) {
        size = context.resources.getDimensionPixelSize(resSizId)
    }

    fun tintColor(@ColorRes resColor: Int) {
        tintColor = ContextCompat.getColor(context, resColor)
    }

    fun verticalAlignment(@ImageSpanAlignment alignment: Int) {
        this.verticalAlignment = alignment
    }
}