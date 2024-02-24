package com.muratguzel.kriptopara.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muratguzel.kriptopara.R
import com.muratguzel.kriptopara.model.CyriptoModel

class CyriptoAdapter(
    private val cyriptoList: ArrayList<CyriptoModel>,
    private val listener: Listener
) :
    RecyclerView.Adapter<CyriptoAdapter.RowHolder>() {
    interface Listener {
        fun onItemClick(cyriptoModel: CyriptoModel)
    }

    private val colors: Array<String> = arrayOf(
        "#33cc5a", "#00d2ff", "#ff00ff", "#e0af1f", "#ff0006", "#0009ff", "#ffa500", "#808080"
    )

    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textName: TextView = itemView.findViewById(R.id.textName)
        val TextPrice: TextView = itemView.findViewById(R.id.textPrice)
        fun bind(
            cyriptoModel: CyriptoModel,
            colors: Array<String>,
            position: Int,
            listener: Listener
        ) {
            itemView.setOnClickListener {
                listener.onItemClick(cyriptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            textName.text = cyriptoModel.currency
            TextPrice.text = cyriptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cyripto_row, parent, false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return cyriptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cyriptoList[position], colors, position, listener)
    }
}