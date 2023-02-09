package com.vshum.turbogum.ui.liners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.vshum.turbogum.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.vshum.turbogum.domain.entities.LinersEntity
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: LinersAdapter

    private val viewModel: LinersViewModel by viewModel()

    private val viewModelDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        viewModelDisposable.addAll(
            viewModel.progressLiveData.subscribe{ showProgress(it) },
            viewModel.usersLiveData.subscribe{ showUsers(it) },
            viewModel.errorLiveData.subscribe{ showError(it) },
        )
    }

    override fun onDestroy() {
        viewModelDisposable.dispose()
        super.onDestroy()
    }


    private fun initViews() {
        binding.refreshButton.setOnClickListener {
            viewModel.onRefresh()
        }
        initRecyclerView()
        showProgress(false)
    }

    private fun openProfileScreen(user: LinersEntity) {
//        val bundle = Bundle()
//        bundle.putParcelable("profile", user)
//        val intent = Intent(this, ProfileActivity::class.java)
//        intent.putExtras(bundle)
//        startActivity(intent)
    }


    private fun showUsers(users: List<LinersEntity>) {
        adapter.setData(users)
    }

    private fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    private fun showProgress(inProgress: Boolean) {
        binding.progressBar.isVisible = inProgress
        binding.usersRecyclerView.isVisible = !inProgress
    }

    private fun initRecyclerView() {
        adapter = LinersAdapter {
            openProfileScreen(it)
        }
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter
    }
}