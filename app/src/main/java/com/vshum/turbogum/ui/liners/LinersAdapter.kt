package com.vshum.turbogum.ui.liners

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vshum.turbogum.domain.entities.LinersEntity

class LinersAdapter(private val onItemClickListener: (LinersEntity) -> Unit) :
    RecyclerView.Adapter<LinersViewHolder>() {

    private val data = mutableListOf<LinersEntity>()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int) = getItem(position).key

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LinersViewHolder(parent, onItemClickListener)

    override fun onBindViewHolder(holder: LinersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = data.size

    private fun getItem(pos: Int) = data[pos]


    @SuppressLint("NotifyDataSetChanged")
    fun setData(users: List<LinersEntity>) {
        data.clear()            //предыдущие данные исключаются
        data.addAll(users)      //добавление новых данных
        notifyDataSetChanged()  //уведомление о изменении данных
    }
}