package kr.donghyun.flowable.testing.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kr.donghyun.flowable.testing.R
import kr.donghyun.flowable.testing.base.BaseActivity
import kr.donghyun.flowable.testing.databinding.ActivitySearchResultBinding
import kr.donghyun.flowable.testing.viewmodel.SearchResultViewModel

class SearchResultActivity : BaseActivity<ActivitySearchResultBinding, SearchResultViewModel>() {
    override val layoutRes: Int
        get() = R.layout.activity_search_result
    override val viewModel: SearchResultViewModel
        get() = ViewModelProvider(this)[SearchResultViewModel::class.java]

    override fun onViewCreated(view: ActivitySearchResultBinding) {
        with(viewModel) {
            getSearchedProfile(region = intent.getStringExtra("region")!!, battleTag = intent.getStringExtra("battleTag")!!)
        }
    }
}