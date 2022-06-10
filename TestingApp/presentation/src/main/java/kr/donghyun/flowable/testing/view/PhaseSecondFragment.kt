package kr.donghyun.flowable.testing.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import kr.donghyun.flowable.testing.R
import kr.donghyun.flowable.testing.base.BaseFragment
import kr.donghyun.flowable.testing.databinding.FragmentPhaseSecondBinding
import kr.donghyun.flowable.testing.viewmodel.SearchResultViewModel

class PhaseSecondFragment : BaseFragment<FragmentPhaseSecondBinding, SearchResultViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_phase_second
    override val viewModel: SearchResultViewModel by activityViewModels()

    override fun onViewCreated(view: FragmentPhaseSecondBinding) {

    }
}