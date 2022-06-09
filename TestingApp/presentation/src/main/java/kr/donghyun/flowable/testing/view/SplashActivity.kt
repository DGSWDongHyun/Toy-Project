package kr.donghyun.flowable.testing.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kr.donghyun.flowable.testing.R
import kr.donghyun.flowable.testing.base.BaseActivity
import kr.donghyun.flowable.testing.databinding.ActivitySplashBinding
import kr.donghyun.flowable.testing.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    override val layoutRes: Int
        get() = R.layout.activity_splash
    override val viewModel: SplashViewModel
        get() = ViewModelProvider(this)[SplashViewModel::class.java]

    override fun onViewCreated(view: ActivitySplashBinding) { }
}