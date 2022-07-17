package com.cshka.pizzastore_20220710

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        메인 쓰레드(화면) 와 통신하는 핸들러를 생성
        val myHandler = Handler(Looper.getMainLooper()) //Handler를 변수로 - duplicated 된 것 없애는 방법 Looper.getMainLooper()
//        백엔드에서 할일

        myHandler.postDelayed(
            {
//            백엔드 이후에 할 일
//            예시 : 서버에 자동 로그인 기능 - 토크으로 로그인 되는지(뭔가 서버와 통신할 때 작업하는 부분)
//            1500밀리초 이후에 실행될 코드


//            인텐트로 이동한다(분기처리 - 로그인 성공 : MainActivity / 로그인 실패 : - LoginActivity)
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
            finish()

            },
//            지연시킬 시간 - ms 단위로 작성
            1500) //지연 시간 milli second 1.5초
    }
}