package com.vshum.turbogum.ui.liners

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.vshum.turbogum.R
import com.vshum.turbogum.databinding.ItemUserBinding
import com.vshum.turbogum.domain.entities.LinersEntity

class LinersViewHolder (parent: ViewGroup, private val onItemClickListener: (linersEntity: LinersEntity) -> Unit) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_liners, parent, false)) {
    private lateinit var linersEntity: LinersEntity


    private val binding = ItemUserBinding.bind(itemView).apply {
        //вместо root можно сделать клик по аватарке "avatarImageView.setOn..."
        root.setOnClickListener {
            //вызываю callback который передан в конструкторе при создании UsersViewHolder
            onItemClickListener.invoke(linersEntity) // 3) воспользовался объектом при нажатии
        }
    }

    fun bind(linersEntity: LinersEntity) {
        this.linersEntity = linersEntity
        binding.avatarImageView.load(linersEntity.imageUrlLiner)
//        binding.loginTextView.text = usersEntity.login
        binding.uidTextView.text = linersEntity.id.toString()
    }
}