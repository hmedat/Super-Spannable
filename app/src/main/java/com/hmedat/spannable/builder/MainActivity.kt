package com.hmedat.spannable.builder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import com.hmedat.spannable.builder.lib.Spannable
import kotlinx.android.synthetic.main.activity_main.*
import android.text.style.ImageSpan
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText.movementMethod = LinkMovementMethod.getInstance();
        tvText.text = Spannable(this)
            .appendBullet(R.dimen.w_18dp, R.color.colorPrimary, 10)
            .appendText("Click on this") {
                onClick(R.color.colorPrimary, View.OnClickListener {
                    Toast.makeText(this@MainActivity, "1", Toast.LENGTH_SHORT).show()
                })
                underline()
            }
            .space()
            .appendIcon(R.drawable.ic_cancel_deep_orange_600_24dp) {
                size(R.dimen.w_24dp)
                verticalAlignment(ImageSpan.ALIGN_BOTTOM)
            }
            .space()
            .appendText("ljl ") {
                textColor(R.color.colorPrimary)
                onClick(View.OnClickListener {
                    Toast.makeText(this@MainActivity, "2", Toast.LENGTH_SHORT).show()

                })
            }
            .getSpannable()


    }
}
