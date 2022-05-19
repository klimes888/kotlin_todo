package com.example.todolist.main.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.CustomDialogBinding.bind
import com.example.todolist.databinding.TodoItemBinding
import com.example.todolist.databinding.TodolistListBinding
import com.example.todolist.main.home.controller.TodoHolder
import com.example.todolist.main.home.model.Todo

class RecycleAdapter(deleteItem: (todo:Todo) -> Unit) :RecyclerView.Adapter<TodoHolder>() {
    var listData = mutableListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
            val item = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TodoHolder(item)
        }
        override fun onBindViewHolder(holder: TodoHolder, position: Int) {
            val item = listData[position]
            holder.setData(item)

            holder.binding.removeBtn.setOnClickListener {
                itemClickListener.onClick(it, position)
            }
//            holder.binding.removeBtn.setOnClickListener {
//                deleteItem.invoke()
//            }
//            holder.apply {
//                bind(item)
//            }
        }
        override fun getItemCount(): Int {
            return listData.size
        }

    //
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    private lateinit var itemClickListener : OnItemClickListener

    fun setItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

}

