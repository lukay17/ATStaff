package com.lega.atstaff.core.extension

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.lega.atstaff.core.base.glide.GlideApp
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("loadImage","placeHolder")
fun AppCompatImageView.loadImage(profileImage: String?, placeHolder: Drawable?) {
    profileImage?.let {
        GlideApp.with(this)
            .load(profileImage)
            .defaultOptions(placeHolder)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
}

fun CircleImageView.loadImg(profileImage: String?) {
    profileImage?.let {
        GlideApp.with(this)
            .load(profileImage)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    }
}
