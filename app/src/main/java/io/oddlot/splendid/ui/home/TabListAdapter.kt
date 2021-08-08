package io.oddlot.splendid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import io.oddlot.splendid.R
import io.oddlot.splendid.data.Tab
import io.oddlot.splendid.databinding.LayoutTabRowWorkingBinding

class TabListAdapter(val tabs: List<Tab>) : RecyclerView.Adapter<TabListAdapter.TabViewHolder>() {

    class TabViewHolder(val binding: LayoutTabRowWorkingBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tab: Tab) {
            binding.tabName.text = tab.name
            binding.tabCurrency.text = tab.currency
            binding.tabBalance.text = tab.balance.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = LayoutTabRowWorkingBinding.inflate(inflater, parent, false)

        return TabViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: TabViewHolder, position: Int) {
        val tab = tabs[position]

        holder.bind(tab)
        holder.binding.root.setOnClickListener {

            it.findNavController().navigate(R.id.action_navigation_home_to_tabFragment)
        }
    }

    override fun getItemCount(): Int  = tabs.size
}