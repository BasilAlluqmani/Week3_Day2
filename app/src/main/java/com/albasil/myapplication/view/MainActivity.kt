package com.albasil.myapplication.view



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.albasil.myapplication.R
import com.albasil.myapplication.data.Question

class MainActivity : AppCompatActivity() {



    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton:Button

    private lateinit var questionText: TextView


    private var currentIndex=0


    private val questionBank= listOf(
        //الكلاس الي انشاته
        //ياخذ السوال و القيمة
        Question(R.string.jeddahQuistions,false),
        Question(R.string.asiaQuistions,false),
        Question(R.string.africaQuistions,false),
        Question(R.string.auropaQuistions,false),
        Question(R.string.americaQuistions,false)

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton=findViewById(R.id.btnTrue)

        falseButton=findViewById(R.id.btnFalse)
        nextButton=findViewById(R.id.btnNext)

        questionText=findViewById(R.id.textQuestion)

        trueButton.setOnClickListener {
            //view->view or it
            //show message
        //    Toast.makeText(this,getString(R.string._false),Toast.LENGTH_LONG).show()

            showToase(R.string._false)

        }

        falseButton.setOnClickListener {
            showToase(R.string._true)

            /*view->view
            Toast.makeText(this,getText(R.string._true),Toast.LENGTH_LONG).show()*/
        }

        val questionResId=questionBank[currentIndex].textResId
        questionText.setText(questionResId)

        nextButton.setOnClickListener {
            currentIndex=(currentIndex+1) % questionBank.size

            val questionResId=questionBank[currentIndex].textResId
            questionText.setText(questionResId)
        }


    }
    fun showToase(message:Int){
        Toast.makeText(this,getString(message),Toast.LENGTH_LONG).show()
    }
}