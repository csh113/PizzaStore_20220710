package com.cshka.pizzastore_20220710.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cshka.pizzastore_20220710.ProfileActivity
import com.cshka.pizzastore_20220710.R
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    val REQ_FOR_NICKNAME = 1000
    val REQ_FOR_PHONENUM = 1001

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        changeNickBtn.setOnClickListener {
            val myIntent = Intent(requireContext(), ProfileActivity::class.java)
            Log.d("nick 버튼 >> ", changeNickBtn.toString())
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }

        changePhoneNumBtn.setOnClickListener {
            val myIntent = Intent(requireContext(), ProfileActivity::class.java)
            Log.d("전화번호 버튼 >> ", changePhoneNumBtn.toString())
            startActivityForResult(myIntent, REQ_FOR_PHONENUM)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
       /* if (requestCode == REQ_FOR_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {
                val changedNick = data?.getStringExtra("data") //한개 입력값으로 받기 위해 수화문 nick->input으로 바꿈
                nicknameTxt.text = changedNick
            }
        }
        if (requestCode == REQ_FOR_PHONENUM) {
            if (resultCode == Activity.RESULT_OK) { // activity_profile의 "변경하기" 버튼
                val changedNick = data?.getStringExtra("data") //한개 입력값으로 받기 위해 수화문 nick->input으로 바꿈
                nicknameTxt.text = changedNick
            }
        }*/

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQ_FOR_NICKNAME) {
                val changedNick = data?.getStringExtra("data") //한개 입력값으로 받기 위해 수화문 nick->input으로 바꿈
                nicknameTxt.text = changedNick
            }

            if (requestCode == REQ_FOR_PHONENUM) {
                val changedNick = data?.getStringExtra("data") //한개 입력값으로 받기 위해 수화문 nick->input으로 바꿈
                phoneNumTxt.text = changedNick
            }
        }
    }
}