package io.oddlot.splendid.ui.tab

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robinhood.ticker.TickerUtils
import io.oddlot.splendid.R
import io.oddlot.splendid.databinding.ActivityMainBinding
import io.oddlot.splendid.databinding.FragmentTabDetailsBinding

class TabDetailsFragment : Fragment() {
    private lateinit var binding: FragmentTabDetailsBinding

    companion object {
        fun newInstance() = TabDetailsFragment()
    }

    private lateinit var viewModel: TabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabDetailsBinding.inflate(layoutInflater)
//        binding.tabBalance.setCharacterLists(TickerUtils.provideNumberList())
//        binding.tabBalance.text = "123.4"

        return inflater.inflate(R.layout.fragment_tab_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TabViewModel::class.java)
        // TODO: Use the ViewModel
    }

}