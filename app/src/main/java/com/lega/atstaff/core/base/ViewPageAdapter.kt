package com.lega.atstaff.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lega.atstaff.R
import com.lega.atstaff.ui.fragment.*

class ViewPageAdapter(
    fragment: DetailFragment,
    private val items:List<String>
) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{TitleFragment()}
            1->{CourseFragment() }
            2->{ LicenseFragment() }
            3->{VisaFragment() }
            else-> TitleFragment()
        }
    }
}