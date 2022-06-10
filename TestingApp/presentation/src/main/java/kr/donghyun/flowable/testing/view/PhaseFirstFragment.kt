package kr.donghyun.flowable.testing.view

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.donghyun.flowable.testing.R
import kr.donghyun.flowable.testing.base.BaseFragment
import kr.donghyun.flowable.testing.databinding.FragmentPhaseFirstBinding
import kr.donghyun.flowable.testing.viewmodel.SearchResultViewModel

class PhaseFirstFragment : BaseFragment<FragmentPhaseFirstBinding, SearchResultViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_phase_first
    override val viewModel : SearchResultViewModel by activityViewModels()

    override fun onViewCreated(view: FragmentPhaseFirstBinding) {
        observePhaseAnimate(view)
    }

    private fun observePhaseAnimate(view: FragmentPhaseFirstBinding) {
        with(viewModel) {
            view.firstPhaseGround.setOnClickListener {
                viewModelScope.launch {
                    when(listPhase) {
                        0 -> {
                            delay(1000)
                            
                        }

                        1 -> {
                        }

                        else -> {

                        }
                    }
                }
                listPhase ++
            }
        }
    }
}