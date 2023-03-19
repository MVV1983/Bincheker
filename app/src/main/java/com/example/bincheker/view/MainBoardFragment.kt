package com.example.bincheker.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bincheker.R
import com.example.bincheker.view.adapters.BinRecyclerAdapter
import com.example.bincheker.viewmodel.BinsViewModel

class MainBoardFragment : Fragment() {

    private val mViewModel: BinsViewModel = BinsViewModel()
    private var adapter = BinRecyclerAdapter()

    private lateinit var button: Button
    private lateinit var changeableNumber: EditText
    private lateinit var paintResults: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_board, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeableNumber = view.findViewById(R.id.inputNumber)
        button = view.findViewById(R.id.sendButton)!!
        paintResults = view.findViewById(R.id.testResults)!!
        initRecycler()

        button.setOnClickListener {
            mViewModel.getDataFromApi(changeableNumber.text.toString()).toString()
            closeKeyboard()
        }

        initObserver()
    }

    private fun initRecycler() { //private fun initRecycler(data: FullData)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.setHasFixedSize(true)
    }

    private fun initObserver() {
        mViewModel.apply {
            detailsBinData.observe(viewLifecycleOwner) {
                adapter.setData(listOf(it))
                adapter.notifyDataSetChanged()
            }
        }
        mViewModel.apply {
            error.observe(viewLifecycleOwner){
                Toast.makeText(context,it,Toast.LENGTH_LONG).show()
            }
        }
    }

    //private fun getDataInform(data: FullData) {
    //   paintResults.text = data.country.name
    // }

    private fun closeKeyboard() {
        val imm: InputMethodManager =
            (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }
}