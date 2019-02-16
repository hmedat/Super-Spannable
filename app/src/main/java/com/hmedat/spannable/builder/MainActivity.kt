package com.hmedat.spannable.builder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import com.hmedat.spannable.builder.lib.Spannable
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.BlurMaskFilter
import android.text.style.MaskFilterSpan
import android.graphics.EmbossMaskFilter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val blurMaskFilterSpan = MaskFilterSpan(BlurMaskFilter(3f, BlurMaskFilter.Blur.OUTER))

        tvText.movementMethod = LinkMovementMethod.getInstance();
        tvText.text = Spannable(this)
            .appendText("Save sdkfjhsdkf sdfjhsdkfh sdfkjhsdkfj sdkjfhskdj sdfjhsdkfjh sdjhfksdjhf kjhsdfkjhsdfj sjdhfksjdhf") {
                leadingMarginSpanStandard(40, 90)
            }
            .getSpannable()


    }
}
