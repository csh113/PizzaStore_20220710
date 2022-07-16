package com.cshka.pizzastore_20220710

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

//        하나의 입력값으로 받고 버튼 한개로 할 때
        changeBtn.setOnClickListener {
            val inputData = changedPhoneNumEdt.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("data", inputData) // 입력값 변수 명 "data" - 수화물
            setResult(RESULT_OK, resultIntent)
            finish()
        }

//        두개로 했을때는 아래 코드로 하기
        /*changeBtn.setOnClickListener {
            val inputNick = changedNickEdt.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nick", inputNick) // 입력값 변수 명 "nick" - 수화물
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        changeBtn.setOnClickListener {
            val inputPhoneNum = changedPhoneNumEdt.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("phoneNum", inputPhoneNum)
            setResult(RESULT_OK, resultIntent)
            finish()
        }*/
    }
}