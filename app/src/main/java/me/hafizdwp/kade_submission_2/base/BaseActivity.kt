package me.hafizdwp.kade_submission_2.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * @author hafizdwp
 * 29/10/2019
 **/
abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    @get:LayoutRes
    abstract val bindLayoutRes: Int
    @get:IdRes
    abstract val bindFragmentContainerId: Int?
    abstract val bindFragmentInstance: Fragment?

    lateinit var mActivityBinding: B


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding = DataBindingUtil.setContentView(this, bindLayoutRes)

        if (bindFragmentContainerId != null && bindFragmentInstance != null)
            setupFragment()
    }

    open fun setupFragment() {
        inflateFragment(bindFragmentContainerId!!, bindFragmentInstance!!)
    }

    private fun inflateFragment(frameId: Int,
                                fragment: Fragment) {
        supportFragmentManager.transact {
            replace(frameId, fragment)
        }
    }

    private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
        beginTransaction().apply {
            action()
        }.commit()
    }
}