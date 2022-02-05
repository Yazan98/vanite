package io.vortex.android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import io.vortex.android.keys.VortexViewModelState
import io.vortex.android.base.VortexViewModelReadyState
import kotlinx.coroutines.launch

/**
 * This ViewModel Type is Only To Pass ViewModel with ReadyState Generic Type and Layout In Constructor
 *
 * Note: Full Implementation in VortexFragment, VortexBaseFragment
 */
abstract class VortexFragmentReadyState<VM: VortexViewModelReadyState>(@LayoutRes private val layoutRes: Int) : VortexBaseFragment() {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getController().getStateHandler().observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                onStateChanged(it)
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    protected abstract suspend fun onStateChanged(newState: VortexViewModelState)
    protected abstract fun getController(): VM
    override fun getLayoutRes(): Int {
        return layoutRes
    }

}
