package ua.javabegin.examples.notes.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*
import ua.javabegin.examples.notes.R
import ua.javabegin.examples.notes.models.AppNote

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()

    fun setList(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }

    class MainHolder(view: View):RecyclerView.ViewHolder(view) {
        val nameNote: TextView = view.note_name
        val nameText: TextView = view.note_text
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
//        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)

        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.nameNote.text = mListNotes[position].name
        holder.nameText.text = mListNotes[position].text
    }

    override fun getItemCount(): Int = mListNotes.size
}