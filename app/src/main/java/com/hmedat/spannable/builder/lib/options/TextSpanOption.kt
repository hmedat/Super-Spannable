package com.hmedat.spannable.builder.lib.options

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Typeface
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.v4.content.ContextCompat
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.*
import android.view.View
import com.hmedat.spannable.builder.lib.spans.ClickableSpanNoUnderline

class TextSpanOption(
    private val context: Context,
    private val builder: SpannableStringBuilder,
    private val builderLength: Int,
    private val currentText: String
) {

    fun textSize(@DimenRes textSizeRes: Int) = setSpan(AbsoluteSizeSpan(getDimen(textSizeRes)))

    private fun getDimen(textSizeRes: Int) = context.resources.getDimensionPixelSize(textSizeRes)

    fun bold() = setSpan(StyleSpan(Typeface.BOLD))

    /*   private fun setTypeFaceSpan(@FontRes id: Int) {
           val typeface = ResourcesCompat.getFont(context, id) ?: return
           setSpan(CustomTypefaceSpan(typeface))
       }*/

    fun italic() = setSpan(StyleSpan(Typeface.ITALIC))

    fun strikeThrough() = setSpan(StrikethroughSpan())

    fun underline() = setSpan(UnderlineSpan())

    fun textColor(@ColorRes textColorRes: Int) = setSpan(ForegroundColorSpan(getColor(textColorRes)))

    fun backgroundColor(@ColorRes textColorRes: Int) = setSpan(BackgroundColorSpan(getColor(textColorRes)))

    fun quote(@ColorRes textColorRes: Int) = setSpan(QuoteSpan(getColor(textColorRes)))

    fun scaleX(proportion: Float) = setSpan(ScaleXSpan(proportion))

    fun relativeSize(proportion: Float) = setSpan(RelativeSizeSpan(proportion))

    fun blurMaskFilter(radius: Float, style: BlurMaskFilter.Blur) =
        setSpan(MaskFilterSpan(BlurMaskFilter(radius, style)))

    fun leadingMarginSpanStandard(@DimenRes firstRes: Int, @DimenRes restRes: Int) =
        setSpan(LeadingMarginSpan.Standard(getDimen(firstRes), getDimen(restRes)))

    fun leadingMarginSpanStandard(@DimenRes everyRes: Int) = setSpan(LeadingMarginSpan.Standard(getDimen(everyRes)))

    private fun getColor(textColorRes: Int) = ContextCompat.getColor(context, textColorRes)

    fun onClick(onClickListener: View.OnClickListener) {
        onClick(ClickableSpanNoUnderline.NO_COLOR, onClickListener)
    }

    fun onClick(@ColorRes textColorRes: Int = ClickableSpanNoUnderline.NO_COLOR, onClickListener: View.OnClickListener) {
        if (textColorRes == ClickableSpanNoUnderline.NO_COLOR) {
            setSpan(ClickableSpanNoUnderline(ClickableSpanNoUnderline.NO_COLOR, onClickListener))
        } else {
            setSpan(ClickableSpanNoUnderline(getColor(textColorRes), onClickListener))
        }
    }

    fun setSpan(any: Any) {
        val index = builderLength
        builder.setSpan(any, index, index + currentText.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
    }
}