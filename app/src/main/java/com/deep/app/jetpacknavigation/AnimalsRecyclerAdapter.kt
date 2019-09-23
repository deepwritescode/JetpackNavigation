package com.deep.app.jetpacknavigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class AnimalsRecyclerAdapter : RecyclerView.Adapter<AnimalsRecyclerAdapter.ViewHolder>() {

    var callbacks: Callback? = null

    private lateinit var recycler: RecyclerView
    private lateinit var layoutInflater: LayoutInflater

    private val data: MutableList<Animal> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recycler = recyclerView
        layoutInflater = LayoutInflater.from(recyclerView.context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.list_item_animal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = data[position]

        val drawable = if (animal.family == "cats") {
            R.drawable.ic_cat
        } else {
            R.drawable.ic_dog
        }

        holder.name.text = animal.name
        holder.image.setImageDrawable(ContextCompat.getDrawable(recycler.context, drawable))
        holder.itemView.setOnClickListener {
            handleItemClick(it)
        }
    }

    private fun handleItemClick(it: View) {
        val pos = recycler.getChildAdapterPosition(it)
        callbacks?.onClick(data[pos])
    }

    fun addAll(position: Int = data.size, list: List<Animal>) {
        this.data.addAll(position, list)
        this.notifyItemRangeInserted(position, list.size)
    }

    fun addItem(position: Int = data.size, animal: Animal) {
        this.data.add(position, animal)
        notifyItemInserted(position)
    }

    fun removeItem(animal: Animal) {
        val position = this.data.indexOf(animal)
        if (position != -1) {
            this.data.remove(animal)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: AppCompatImageView = itemView.findViewById(R.id.image)
        val name: AppCompatTextView = itemView.findViewById(R.id.name)
    }

    interface Callback {
        fun onClick(animal: Animal)
    }
}