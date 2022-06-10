package kr.donghyun.flowable.testing.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kr.donghyun.flowable.testing.BR

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity(){

    lateinit var viewDataBinding : VB

    abstract val layoutRes : Int
    abstract val viewModel : VM

    abstract fun onViewCreated(view : VB)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        performBinding()
        onViewCreated(viewDataBinding)
    }


    private fun performBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutRes)

        viewModel.startActivity.observe(this, Observer { activityInfo ->
            val intent = Intent(this, activityInfo.first.java).apply {
                if(activityInfo.second != null)
                    putExtras(activityInfo.second!!)
            }
            startActivity(intent)
        })

        viewModel.finishActivity.observe(this, Observer { isFinished ->
            if(isFinished) {
                finish()
            }
        })

        viewModel.startFinishActivity.observe(this, Observer { isNewActivity ->
            val intent = Intent(this@BaseActivity, isNewActivity.first.java)
            if(isNewActivity.second != null)
                intent.putExtras(isNewActivity.second!!)
            finish()
            startActivity(intent)
        })

        viewDataBinding.run {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.viewModel, viewModel)
            executePendingBindings()
        }
    }
}