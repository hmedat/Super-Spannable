package com.hmedat.spannable.builder.lib.spans

import android.graphics.Color
import android.support.annotation.ColorInt
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View

/**
 * https://stackoverflow.com/q/16007147
 */
class ClickableSpanNoUnderline(
    @ColorInt private val color: Int = NO_COLOR,
    private val onClickListener: View.OnClickListener
) : ClickableSpan() {
    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.color = if (color == NO_COLOR) {
            ds.linkColor
        } else {
            color
        }
        ds.clearShadowLayer()
        ds.isUnderlineText = false
        ds.bgColor = Color.TRANSPARENT
    }

    override fun onClick(widget: View) {
        this.onClickListener.onClick(widget)
    }

    companion object {
        const val NO_COLOR = 0
    }
}