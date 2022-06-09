package kr.donghyun.flowable.testing.base

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.donghyun.flowable.testing.viewmodel.util.SingleLiveEvent
import kotlin.reflect.KClass

open class BaseViewModel : ViewModel() {
    private val _finishActivity = SingleLiveEvent<Boolean>()
    private val _eventMyActivity = SingleLiveEvent<Pair<KClass<*>, Bundle?>>()

    val finishActivity : MutableLiveData<Boolean>
        get() = _finishActivity
    val startFinishActivity: MutableLiveData<Pair<KClass<*>, Bundle?>>
        get() = _eventMyActivity

}