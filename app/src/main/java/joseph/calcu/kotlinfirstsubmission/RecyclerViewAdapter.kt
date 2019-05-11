package joseph.calcu.kotlinfirstsubmission

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(var list : MutableList<LeagueItem>, var listener : (LeagueItem) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.LeagueViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(LeagueItemUi().createView(AnkoContext.Companion.create(parent.context,parent)))
    }


    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(list[position],listener)
    }

    class LeagueViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var imageView : ImageView
        var textView : TextView

        init{
            imageView = itemView.findViewById(LeagueItemUi.imageId)
            textView=itemView.findViewById(LeagueItemUi.nameId)
        }
        fun bindItem(items:LeagueItem,listener:(LeagueItem)->Unit)
        {
            textView.text = items.leaguename
            items.image?.let{Picasso.get().load(it).into(imageView)}
            itemView.setOnClickListener(){
                listener(items)

            }
        }
    }

}