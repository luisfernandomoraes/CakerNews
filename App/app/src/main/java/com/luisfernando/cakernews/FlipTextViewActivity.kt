package com.luisfernando.cakernews


import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import com.aphidmobile.flip.FlipViewController

class FlipTextViewActivity : Activity() {

    protected lateinit var flipView: FlipViewController

    /**
     * Called when the activity is first created.
     */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("Title")

        flipView = FlipViewController(this)

        flipView.adapter = object : BaseAdapter() {
            override fun getCount(): Int {
                return 10
            }

            override fun getItem(position: Int): Any {
                return position
            }

            override fun getItemId(position: Int): Long {
                return position.toLong()
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view: NumberTextView
                if (convertView == null) {
                    val context = parent.context
                    view = NumberTextView(context, position)
                    view.textSize = context.resources.getDimension(R.dimen.textSize)
                } else {
                    view = (convertView as NumberTextView?)!!
                    view.number = position
                }

                return view
            }
        }

        setContentView(flipView)
    }

    override fun onResume() {
        super.onResume()
        flipView.onResume()
    }

    override fun onPause() {
        super.onPause()
        flipView.onPause()
    }
}
