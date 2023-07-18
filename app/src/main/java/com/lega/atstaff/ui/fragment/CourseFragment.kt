package com.lega.atstaff.ui.fragment

import androidx.fragment.app.viewModels
import com.lega.atstaff.R
import com.lega.atstaff.core.base.BaseFragmentDb
import com.lega.atstaff.core.base.recycler.BaseRvAdapter
import com.lega.atstaff.databinding.FragmentCourseBinding
import com.lega.atstaff.domain.models.Courses
import com.lega.atstaff.ui.util.CustomSnackBar
import com.lega.atstaff.ui.vm.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseFragment : BaseFragmentDb<FragmentCourseBinding, DetailViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_course
    override val viewModel: DetailViewModel by viewModels()
    val TAG:String = "CourseFragement"
    var snackBar: CustomSnackBar = CustomSnackBar()

    private val adapterCourse by lazy {
        BaseRvAdapter<Courses>(R.layout.item_course_list){ courses ->
            courses?.let {
                snackBar.Image(requireView(), it.name, 2)
            }
        }
    }

    override fun initViewModels() {
        arguments?.getInt("Id")?.let { viewModel.loadCourseList(it) }
        dataBinding.courseRV.adapter?.notifyDataSetChanged()
        dataBinding.courseRV.adapter = adapterCourse
    }

    override fun observeViewModels() {
        viewModel.courseList.observe(viewLifecycleOwner) {
            adapterCourse.items = it
        }
    }
}