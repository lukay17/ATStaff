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
    private val items:List<String>,
    private val id:Int
) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        val titleFragment = TitleFragment()
        titleFragment.arguments = Bundle().apply { putInt(ARG_ID, id) }

        val licenseFragment = LicenseFragment()
        licenseFragment.arguments = Bundle().apply { putInt(ARG_ID, id) }

        val courseFragment = CourseFragment()
        courseFragment.arguments = Bundle().apply { putInt(ARG_ID, id) }

        val visaFragment = VisaFragment()
        visaFragment.arguments = Bundle().apply { putInt(ARG_ID, id) }

        return when(position){
            0->{titleFragment}
            1->{courseFragment}
            2->{licenseFragment}
            3->{visaFragment}
            else-> titleFragment
        }
    }

    companion object{
        private const val ARG_ID = "Id"

    }
}