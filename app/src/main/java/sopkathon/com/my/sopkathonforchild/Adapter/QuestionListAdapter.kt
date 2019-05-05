package sopkathon.com.my.sopkathonforchild.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
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
        p0.question_date.text=dataList[p1].date
        p0.question_name.text=dataList[p1].question

        p0.ans_button.setOnClickListener {
            if(p0.question_ans.visibility == View.GONE){
                p0.question_ans.visibility = View.VISIBLE
            }
            else p0.question_ans.visibility = View.GONE
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category_name=itemView.findViewById(R.id.txt_category) as TextView
        var question_name=itemView.findViewById(R.id.txt_cateques) as TextView
        var question_ans=itemView.findViewById(R.id.txt_cateans) as TextView
        var question_date=itemView.findViewById(R.id.date) as TextView
        var ans_button = itemView.findViewById(R.id.btn_ans) as Button
    }


}