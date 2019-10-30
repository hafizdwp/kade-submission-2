package me.hafizdwp.kade_submission_2.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import me.hafizdwp.kade_submission_2.R
import me.hafizdwp.kade_submission_2.base.BaseActivity
import me.hafizdwp.kade_submission_2.databinding.MainActivityBinding

class MainActivity : BaseActivity<MainActivityBinding>() {

    override val bindLayoutRes: Int
        get() = R.layout.main_activity
    override val bindFragmentContainerId: Int?
        get() = null
    override val bindFragmentInstance: Fragment?
        get() = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
