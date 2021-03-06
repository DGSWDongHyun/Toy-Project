package kr.donghyun.flowable.testing.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kr.donghyun.flowable.testing.R
import kr.donghyun.flowable.testing.base.BaseActivity
import kr.donghyun.flowable.testing.databinding.ActivityMainBinding
import kr.donghyun.flowable.testing.databinding.FragmentBottomExitBinding
import kr.donghyun.flowable.testing.databinding.FragmentBottomSelectRegionBinding
import kr.donghyun.flowable.testing.view.extensions.setGlideImage
import kr.donghyun.flowable.testing.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutRes: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel
        get() = ViewModelProvider(this)[MainViewModel::class.java]

    lateinit var bottomRegionDialog : BottomSheetDialog
    lateinit var bottomExitDialog : BottomSheetDialog
    lateinit var loadingSnackbar: Snackbar

    override fun onViewCreated(view: ActivityMainBinding) {
        changeStateView(view)
        loadingStateChange(view)
    }

    private fun bottomExit() {
        if(this::bottomExitDialog.isInitialized) {
            bottomExitDialog.show()
        }else{
            val sheetView = FragmentBottomExitBinding.inflate(LayoutInflater.from(this))
            bottomExitDialog = BottomSheetDialog(this, R.style.RoundedBottomSheet).apply {
                setContentView(sheetView.root)
                sheetView.apply {
                    exitButton.setOnClickListener {
                        viewModel.finishActivity.postValue(true)
                    }
                }
            }
            bottomExitDialog.show()
        }
    }

    private fun loadingStateChange(view: ActivityMainBinding) {
        viewModel.isLoading.observe(this, Observer { isLoading ->
            if(isLoading) {
                if(this::loadingSnackbar.isInitialized) {
                    if(!loadingSnackbar.isShown) {
                        loadingSnackbar.show()
                    }
                }else{
                    loadingSnackbar = Snackbar.make(view.root, "?????? ????????? ?????? ????????????.. ????????? ??????????????????.", Snackbar.LENGTH_INDEFINITE).apply {
                        show()
                    }
                }
            }else{
                if(this::loadingSnackbar.isInitialized) {
                    if(loadingSnackbar.isShown) {
                        loadingSnackbar.dismiss()
                    }
                }
            }
        })
    }

    private fun changeStateView(view: ActivityMainBinding) {
        with(viewModel) {

            profile.observe(this@MainActivity, Observer { data ->
                if(data != null) {
                    val nameOfUser = data.userName.substring(0, data.userName.indexOf("#"))
                    if(!data.isPrivate) {
                        view.apply {
                            userNameTextView.text = nameOfUser
                            levelText.text = "${data.level} ??????"
                            profileImage.setGlideImage(this@MainActivity, data.iconImage)
                            userName.text = Html.fromHtml(getString(R.string.average_score, nameOfUser), Html.FROM_HTML_MODE_LEGACY)
                            tierImage.setGlideImage(this@MainActivity, data.ratingIcon)
                            view.resultCardView.setOnClickListener {
                                startActivity.postValue(Pair(SearchResultActivity::class, Bundle().apply {
                                    putString("region", searchRegion.value!!)
                                    putString("battleTag", searchBattleTag.value!!)
                                }))
                            }
                        }
                    }else{
                        view.apply {
                            userNameTextView.text = nameOfUser
                            profileImage.setGlideImage(this@MainActivity, data.iconImage)
                            levelText.text = "${data.level} ??????"
                            userName.text = getString(R.string.locked_profile)
                            tierImage.visibility = View.GONE
                            afterText.visibility = View.GONE
                            view.resultCardView.setOnClickListener {
                                Snackbar.make(view.root, getString(R.string.locked_profile), Snackbar.LENGTH_SHORT).show()
                            }
                        }
                    }
                    view.resultCardView.visibility = View.VISIBLE
                }else{
                    Snackbar.make(view.root, "????????? ?????? ?????? ????????? ??????????????????.", Snackbar.LENGTH_SHORT).show()
                    view.apply {
                        resultCardView.visibility = View.GONE
                    }
                }
            })

            view.inputBattleTag.setOnEditorActionListener { v, actionId, event ->
                if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                    viewModel.getSearchedProfile()
                }
                true
            }
        }
    }

    override fun onBackPressed() {
        bottomExit()
    }
}