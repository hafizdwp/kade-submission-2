package me.hafizdwp.kade_submission_2.mvvm

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import me.hafizdwp.kade_submission_2.R
import me.hafizdwp.kade_submission_2.base.BaseFragment
import me.hafizdwp.kade_submission_2.databinding.MainFragmentBinding
import me.hafizdwp.kade_submission_2.util.obtainViewModel
import me.hafizdwp.kade_submission_2.util.withArgs

/**
 * @author hafizdwp
 * 30/10/2019
 **/
class MainFragment : BaseFragment<MainActivity, MainFragmentBinding, MainViewModel>() {

    companion object {
        fun newInstance() = MainFragment().withArgs { }
    }

    override val bindLayoutRes: Int
        get() = R.layout.main_fragment
    override val mLifecycleOwner: LifecycleOwner
        get() = this@MainFragment
    override val mViewModel: MainViewModel
        get() = obtainViewModel()

    override fun onSetupBindingVariable(): MainFragmentBinding {
        return mViewBinding.apply {

        }
    }

    override fun onViewReady() {

    }

    override fun start() {
        mViewModel.getExample()
    }

    override fun setupObserver(): MainViewModel? = mViewModel.apply {
        data.observe {
            mViewBinding.data = it
        }
    }
}