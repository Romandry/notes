package ua.javabegin.examples.notes.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ua.javabegin.examples.notes.R
import ua.javabegin.examples.notes.databinding.FragmentMainBinding
import ua.javabegin.examples.notes.models.AppNote
import ua.javabegin.examples.notes.utilites.APP_ACTIVITY

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding ? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: MainFragmentViewModel

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter
    private lateinit var mObserverList: Observer<List<AppNote>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {

        mAdapter = MainAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter

        mObserverList = Observer {
            val list = it.asReversed()
            mAdapter.setList(list)
        }

        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mViewModel.allNotes.observe(this, mObserverList)

        mBinding.btnAddNote.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mViewModel.allNotes.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }

    companion object {
        fun click(note: AppNote) {
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_noteFragment, bundle)
        }
    }

}