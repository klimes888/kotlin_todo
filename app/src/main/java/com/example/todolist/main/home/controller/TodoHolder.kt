package com.example.todolist.main.home.controller

import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TodoItemBinding
import com.example.todolist.main.home.model.Todo
import com.example.todolist.main.home.view.RecycleAdapter

class TodoHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun setData(props: Todo){
        binding.tvTodo.text = props.todo
        binding.textView.text = "작성자"
        binding.imgTodo.setImageResource(props.image)
    }

}