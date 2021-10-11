package com.albasil.myapplication.view



import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.albasil.myapplication.R
import com.albasil.myapplication.data.Question

class MainActivity : AppCompatActivity() {



    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton:Button
    private lateinit var previosButton:Button

    private lateinit var questionText: TextView


    private var currentIndex=0


    private val questionBank= listOf(
        //الكلاس الي انشاته
        //ياخذ السوال و القيمة
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toast1=Toast.makeText(this,"Helloooo:)",Toast.LENGTH_SHORT)

        toast1.setGravity(Gravity.CENTER,5,5)

        val _toast1:TextView = toast1.view!!.findViewById(android.R.id.message)
        _toast1.setTextColor(Color.CYAN)
        _toast1.setTextSize(16F)
        toast1.show()




        trueButton=findViewById(R.id.btnTrue)
        falseButton=findViewById(R.id.btnFalse)
        nextButton=findViewById(R.id.btnNext)
        previosButton=findViewById(R.id.btnPrevious)
        questionText=findViewById(R.id.textQuestion)




        trueButton.setOnClickListener {
            //view->view or it

            checkAnswer(true)

        }

        falseButton.setOnClickListener {
            checkAnswer(false)

}

        viewQutestion()

        nextButton.setOnClickListener {
            currentIndex=(currentIndex+1) % questionBank.size

            viewQutestion()
        }

        previosButton.setOnClickListener {

            currentIndex=(currentIndex-1) % questionBank.lastIndex
            Toast.makeText(this,"$currentIndex",Toast.LENGTH_SHORT).show()

            viewQutestion()


        }


    }


    fun viewQutestion(){
        val questionResId=questionBank[currentIndex].textResId
        questionText.setText(questionResId)
    }

    private fun checkAnswer(check: Boolean) {
        //cheack if true or false

        val correctAnswer=questionBank[currentIndex].answer
        val messageAnswer=if (check == correctAnswer)R.string._true else R.string._false

       // showToase(messageAnswer)
        val toast1=Toast.makeText(this,getString(messageAnswer),Toast.LENGTH_SHORT)
        val _toast1:TextView = toast1.view!!.findViewById(android.R.id.message)
        toast1.setGravity(Gravity.CENTER,5,5)
        if (check==correctAnswer){
            _toast1.setTextColor(Color.GREEN)
            _toast1.setTextSize(24F)
            toast1.show()
        }else{
            _toast1.setTextColor(Color.RED)
            _toast1.setTextSize(24F)
            toast1.show()
        } }
    fun showToase(message:Int){







    }
}