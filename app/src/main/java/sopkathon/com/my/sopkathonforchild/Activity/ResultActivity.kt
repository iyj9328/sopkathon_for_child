package sopkathon.com.my.sopkathonforchild.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*
import sopkathon.com.my.sopkathonforchild.Adapter.QuestionListAdapter
import sopkathon.com.my.sopkathonforchild.Data.Question
import sopkathon.com.my.sopkathonforchild.R

class ResultActivity : AppCompatActivity() {
    lateinit var questionListAdapter: QuestionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var dataList: ArrayList<Question> = ArrayList()
        dataList.add(Question(
                "음식",
                "음식 질문","2019.5.6","무슨 음식을 제일 좋아하니?"))
        dataList.add(Question(
                "학교",
                "학교 질문","2019.5.7","학교 생활은 어떻니?"))
        dataList.add(Question(
                "사랑",
                "사랑 질문","2019.5.8","엄마를 사랑하니?"))

        questionListAdapter= QuestionListAdapter(this,dataList)
        rv_question_all.adapter=questionListAdapter

        val lm = LinearLayoutManager(this)
        rv_question_all.layoutManager = lm
        //rv_question_all.setHasFixedSize(true)


    }


}
