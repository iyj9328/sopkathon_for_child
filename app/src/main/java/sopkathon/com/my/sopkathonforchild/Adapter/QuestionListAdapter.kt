package sopkathon.com.my.sopkathonforchild.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import sopkathon.com.my.sopkathonforchild.Data.Question
import sopkathon.com.my.sopkathonforchild.R

class QuestionListAdapter(val ctx: Context, val dataList:ArrayList<Question>) :RecyclerView.Adapter<QuestionListAdapter.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view: View= LayoutInflater.from(ctx).inflate(R.layout.listview_item,p0,false)
        return Holder(view)
    }

    override fun getItemCount():  Int = dataList.size



    override fun onBindViewHolder(p0: Holder, p1: Int) {

        p0.category_name.text=dataList[p1].category
        p0.categoryq.text=dataList[p1].category_question
        p0.question_date.text=dataList[p1].date
        p0.question_name.text=dataList[p1].question
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category_name=itemView.findViewById(R.id.txt_category) as TextView
        var categoryq=itemView.findViewById(R.id.txt_categoryq) as TextView
        var question_name=itemView.findViewById(R.id.txt_question) as TextView
        var question_date=itemView.findViewById(R.id.date) as TextView
    }

}