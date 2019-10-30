package me.hafizdwp.kade_submission_2.util

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.hafizdwp.kade_submission_2.util.ViewModelFactory.Companion.getInstance

/**
 * @author hafizdwp
 * 29/10/2019
 **/

inline fun <reified T : ViewModel> AppCompatActivity.obtainViewModel() =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(T::class.java)

inline fun <reified VM : ViewModel> Fragment.obtainViewModel() =
        ViewModelProviders.of(requireActivity(), getInstance(requireActivity().application)).get(VM::class.java)

/**
 * Fragment ez argument
 * */
fun <T : Fragment> T.withArgs(
        argsBuilder: Bundle.() -> Unit): T =
        this.apply {
            arguments = Bundle().apply(argsBuilder)
        }

fun RecyclerView.dividerItemDecoration(): DividerItemDecoration {
    return DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
}