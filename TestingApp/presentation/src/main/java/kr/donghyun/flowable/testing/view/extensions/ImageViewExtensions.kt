package kr.donghyun.flowable.testing.view.extensions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setGlideImage(context: Context, data: String) {
    Glide.with(context)
        .load(data)
        .into(this)
}