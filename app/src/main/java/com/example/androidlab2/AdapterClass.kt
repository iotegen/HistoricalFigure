package com.example.androidlab2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlab2.databinding.RecyclerItemBinding
import com.example.androidlab2.model.HistoricalFigure

class AdapterClass() :
    RecyclerView.Adapter<AdapterClass.ViewHolder>() {
    private val items: ArrayList<HistoricalFigure> = arrayListOf()

    fun setHistoricalFigures(historicalfiguresList: List<HistoricalFigure>) {
        val diffResult = DiffUtil.calculateDiff(CatDiffCallBack(items, historicalfiguresList))
        items.clear()
        items.addAll(historicalfiguresList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterClass.ViewHolder {
        return ViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterClass.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: RecyclerItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(historicalfigure: HistoricalFigure) {
            with(binding) {


                name.text = historicalfigure.name
                title.text = historicalfigure.title
                born.text = historicalfigure.info.born
                died.text = historicalfigure.info.died
                if(historicalfigure.info.years != null) {
                    years.text = historicalfigure.info.years
                } else if (historicalfigure.info.yearsActive != null) {
                    years.text = historicalfigure.info.yearsActive
                }
                region.text=historicalfigure.info.region
            }
        }

    }

    class CatDiffCallBack(
        private val oldList: List<HistoricalFigure>,
        private val newList: List<HistoricalFigure>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].name == newList[newItemPosition].name
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }
}