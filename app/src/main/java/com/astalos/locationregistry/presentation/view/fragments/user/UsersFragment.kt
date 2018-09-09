package com.astalos.locationregistry.presentation.view.fragments.user

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.astalos.locationregistry.R
import com.astalos.locationregistry.domain.entities.User
import com.astalos.locationregistry.domain.repository.Failure
import com.astalos.locationregistry.presentation.view.fragments.BaseFragment
import com.astalos.locationregistry.presentation.viewmodel.UsersViewModel
import kotlinx.android.synthetic.main.fragment_users.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * @author Tomasz Czura on 9/7/18.
 */
class UsersFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_users

    private lateinit var viewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addUserBtn.onClick { showAddUserDialog() }
    }

    private fun showAddUserDialog () {
        val addUserFragment = SaveUserDialogFragment.getInstance()
        addUserFragment.show(fragmentManager, SaveUserDialogFragment::class.java.name)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory)[UsersViewModel::class.java]
        viewModel.users.observe(this, Observer<List<User>> { showUsers(it) })
        viewModel.error.observe(this, Observer<Failure> { handleError(it) })
    }

    private fun handleError(error: Failure?) {

    }

    private fun showUsers(users: List<User>?) {

    }
}