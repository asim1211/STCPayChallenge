package com.example.stcpaychallenge.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.stcpaychallenge.common.ProgressBarInterface
import com.example.stcpaychallenge.extensions.observeNonNull
import com.example.stcpaychallenge.model.Results

open class BaseFragment : Fragment() {

    protected fun <T> LiveData<T>.observeHandleProgress(
        owner: LifecycleOwner = viewLifecycleOwner,
        block: (result: T) -> Unit
    ) {
        this.observeNonNull(owner) {
            if (it is Results.Error<*>) (activity as? ProgressBarInterface)?.showProgress(false)
            if (it is Results.Success<*>) (activity as? ProgressBarInterface)?.showProgress(false)
            if (it is Results.Loading<*>) (activity as? ProgressBarInterface)?.showProgress()
            block(it)
        }
    }
}