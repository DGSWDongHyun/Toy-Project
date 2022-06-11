package kr.donghyun.flowable.testing.view

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.donghyun.flowable.testing.R
import kr.donghyun.flowable.testing.base.BaseFragment
import kr.donghyun.flowable.testing.databinding.FragmentPhaseFirstBinding
import kr.donghyun.flowable.testing.view.extensions.setGlideImage
import kr.donghyun.flowable.testing.viewmodel.SearchResultViewModel

class PhaseFirstFragment : BaseFragment<FragmentPhaseFirstBinding, SearchResultViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_phase_first
    override val viewModel : SearchResultViewModel by activityViewModels()

    override fun onViewCreated(view: FragmentPhaseFirstBinding) {
        observeProfile(view)
    }

    private fun observeProfile(view: FragmentPhaseFirstBinding) {
        with(viewModel) {
            profile.observe(viewLifecycleOwner, Observer { data ->
                if(data != null) {
                    Snackbar.make(view.root, "로딩이 완료되었습니다! 화면을 터치하여 결과를 확인해보세요!", Snackbar.LENGTH_SHORT).show()
                    observePhaseAnimate(view)
                    val nameOfUser = data.userName.substring(0, data.userName.indexOf("#"))
                    view.apply {
                        userNameTextView.text = nameOfUser
                        levelText.text = "${data.level} 레벨"
                        profileImage.setGlideImage(requireContext(), data.iconImage)
                    }
                }else{
                    Snackbar.make(view.root, "서버와 통신 중에 오류가 발생했습니다.", Snackbar.LENGTH_SHORT).show()
                    view.apply {
                        resultCardView.visibility = View.GONE
                    }
                }
            })
        }
    }

    private fun observePhaseAnimate(view: FragmentPhaseFirstBinding) {
        with(viewModel) {
            view.firstPhaseGround.setOnClickListener {
               viewModelScope.launch {
                   when(listPhase) {
                       0 -> {
                           view.textView7.visibility = View.VISIBLE
                       }

                       1 -> {
                           view.textView6.visibility = View.VISIBLE
                       }

                       2 -> {
                           view.resultCardView.visibility = View.VISIBLE
                           delay(1000)
                           view.actionNext.visibility = View.VISIBLE
                       }

                       3 -> {
                           launchNavigation.postValue(PhaseFirstFragmentDirections.toSecondPhase())
                       }
                   }
                   listPhase ++
               }
            }
        }
    }
}