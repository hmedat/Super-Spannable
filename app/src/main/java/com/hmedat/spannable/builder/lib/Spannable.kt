package com.hmedat.spannable.builder.lib

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.content.res.AppCompatResources
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.text.style.SubscriptSpan
import android.text.style.SuperscriptSpan
import android.text.style.URLSpan
import com.hmedat.spannable.builder.lib.options.ImageSpanOption
import com.hmedat.spannable.builder.lib.options.TextSpanOption

class Spannable(private val context: Context) {
    private val builder = SpannableStringBuilder()

    fun appendText(@StringRes resId: Int, options: (TextSpanOption.() -> Unit)?): Spannable {
        return appendText(context.getString(resId), options)
    }

    fun appendText(text: String, options: (TextSpanOption.() -> Unit)? = null): Spannable {
        if (text.isEmpty()) {
            return this
        }
        val length = builder.length
        builder.append(text)
        options?.let { TextSpanOption(context, builder, length, text).apply(it) }
        return this
    }

    fun appendUrl(text: String, url: String, options: (TextSpanOption.() -> Unit)? = null): Spannable {
        appendText(text) {
            setSpan(URLSpan(url))
            options?.let { this.it() }
        }
        return this
    }

    fun appendSuperscript(text: String, options: (TextSpanOption.() -> Unit)? = null): Spannable {
        appendText(text) {
            setSpan(SuperscriptSpan())
            options?.let { this.it() }
        }
        return this
    }

    fun appendSubscript(text: String, options: (TextSpanOption.() -> Unit)? = null): Spannable {
        appendText(text) {
            setSpan(SubscriptSpan())
            options?.let { this.it() }
        }
        return this
    }

    fun space(): Spannable {
        return appendText(" ")
    }

    fun newLine(): Spannable {
        return appendText("\n")
    }

    fun appendIcon(@DrawableRes id: Int, options: (ImageSpanOption.() -> Unit)? = null): Spannable {
        val imageSpanOption = ImageSpanOption(context, id)
        val fakeText = "I"
        options?.let {
            imageSpanOption.apply(it)
        }
        val imageSpan = getImageSpan(imageSpanOption) ?: return this
        appendText(fakeText) {
            setSpan(imageSpan)
        }
        return this
    }

    private fun getImageSpan(image: ImageSpanOption): ImageSpan? {
        var drawable = AppCompatResources.getDrawable(context, image.id) ?: return null
        if (image.tintColor != 0) {
            drawable = drawable.tint(image.tintColor)
        }
        drawable.apply {
            setBounds(0, 0, image.size, image.size)
        }
        return ImageSpan(drawable)
    }

    fun getSpannable(): SpannableStringBuilder {
        return builder
    }
}


fun Drawable.tint(@ColorInt resColor: Int): Drawable {
    val wrapDrawable = DrawableCompat.wrap(this)
    DrawableCompat.setTint(wrapDrawable, resColor)
    DrawableCompat.setTintMode(wrapDrawable, PorterDuff.Mode.SRC_IN)
    return wrapDrawable
}
