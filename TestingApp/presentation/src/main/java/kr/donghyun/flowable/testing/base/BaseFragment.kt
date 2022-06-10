package kr.donghyun.flowable.testing.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kr.donghyun.flowable.testing.BR

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    private lateinit var viewDataBinding: VB

    abstract val layoutRes: Int
    abstract val viewModel: VM

    abstract fun onViewCreated(view: VB)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        performBinding(inflater, container)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreated(viewDataBinding)
    }

    private fun performBinding(inflater: LayoutInflater, container: ViewGroup?) {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)

        viewDataBinding.run {
            lifecycleOwner = this@BaseFragment
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
        }

        viewModel.launchNavigation.observe(viewLifecycleOwner, Observer { launchInfo ->
            findNavController().navigate(launchInfo)
        })
    }
}