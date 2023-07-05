package com.example.m14_final_2210043

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(val result:List<Resultats>) : RecyclerView.Adapter<RvAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view)
        //val TAG: String = "View Holder"

        //val Quote: TextView = itemView.findViewById(R.id.tvQuoteItem)
        //val Author: TextView = itemView.findViewById(R.id.tvAuthorItem)
//
        //init {
        //    itemView.setOnClickListener { v: View ->
        //        val position: Int = AdapterPosition
        //        Snackbar.make(v, "You clicked on ${Quote[position].strEvent}", Snackbar.LENGTH_LONG)
        //            .setAction("Action", null).show()
        //        Log.d(TAG, ": clicked ${items[position].strEvent}")
        //    }
        //}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tvQuoteItem).text = result[position].quote
            findViewById<TextView>(R.id.tvAuthorItem).text = result[position].author
        }
    }

    override fun getItemCount(): Int {
        return result.count()
    }
}


// jai trouver ca sur internet , mais je reussis pas a faire fonctionner

//public class RecyclerViewAdapter {
//    CallbackListener listener;
//
//    public RecyclerViewAdapter (CallbackListener listener){
//        this.listener = listener;
//    }
//
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
//        itemHolder.like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onItemClicked();
//            }
//        });
//
//        public interface CallbackListener{
//            void onItemClicked();
//        }
//    }