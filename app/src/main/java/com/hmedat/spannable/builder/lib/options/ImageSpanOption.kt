package com.hmedat.spannable.builder.lib.options

import android.content.Context
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat


class ImageSpanOption(private val context: Context, @DrawableRes val id: Int) {
    companion object {
        private const val DEFAULT_IMAGE_HQ = 10
    }

    var size = DEFAULT_IMAGE_HQ
        private set
    var tintColor = 0
        private set

    fun size(@DimenRes resSizId: Int) {
        size = context.resources.getDimensionPixelSize(resSizId)
    }

    fun tintColor(@ColorRes resColor: Int) {
        tintColor = ContextCompat.getColor(context, resColor)
    }
}