package com.hmedat.spannable.builder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Toast
import com.hmedat.spannable.builder.lib.Spannable
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  tvText.movementMethod = LinkMovementMethod.getInstance(); // enable clicking on url span
        tvText.text = Spannable(this)
            .appendText("Open this ")
            .appendText("Link") {
                onClick(View.OnClickListener {
                    Toast.makeText(this@MainActivity, "sdfsdf", Toast.LENGTH_SHORT).show()
                })
            }
            .getSpannable()*/


    }
}
