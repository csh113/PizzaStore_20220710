package com.cshka.pizzastore_20220710

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.willy.ratingbar.ScaleRatingBar
import kotlinx.android.synthetic.main.activity_detail_sotre.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.phoneNumTxt
import kotlinx.android.synthetic.main.store_list_item.*
import kotlinx.android.synthetic.main.store_list_item.scoreTxt
import java.util.jar.Manifest
import kotlin.math.min

class DetailSotreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_sotre)

//        Intent의 첨부된 데이터 받아오는 코드
        val storeData = intent.getSerializableExtra("storeData") as StoreData
//        val storeRatingBar = row.findViewById<ScaleRatingBar>(R.id.storeRatingBar) 필요없음

//        받아온 데이터를 참조해서 UI에 반영
        storeNameTxt.text = storeData.name
        scoreTxt.text = "(${storeData.score.toString()})"
        phoneNumTxt.text = storeData.phoneNum
        detailRatingBar.rating = storeData.score.toFloat()


//        주문하기 버튼을 눌렀을 때 - Dial
        callBtn.setOnClickListener {
//            TedPermission 추가
            val pl = object : PermissionListener { //object 꼭 필수로 추가할 함수가 있음. pl : Permission Listener
//                권한 획득 성공시 진행 코드
                override fun onPermissionGranted() {
                    var myUri = Uri.parse("tel:${phoneNumTxt.text}")
                    val myIntent = Intent( Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

//                권한 획득 실패시 진행 코드
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(this@DetailSotreActivity, "권한이 없습니다.", Toast.LENGTH_SHORT).show()
//                  Deny한 경우 - 설정에서 따로 변경해야 함
                }
                /* 유의사항
                간단하게 권한을 물어보고 싶을때 사용

                일부 권한의 경우, 추가 코드 작업 필요함.
                앱을 사용할때, 여러개의 권한이 필요하다고 해서, 앱 시작점 (SplashActivity)에서 몰아서 권한을 물어보는 코드는 지양하자.

                각각의 권한이 실제로 필요한 순간에 권한을 요청하자.
                * GPS등 일부 권한의 경우 추가 코드 작업 필요
                * SplashActivity에서 몰아서 권한 물어보기 X - 안드로이드 오류의 주원인
                * 각각의 권한이 실제 필요 시에 권한 요청하기
                * */


            }

            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(android.Manifest.permission.CALL_PHONE)
                .check()

//            1. 주문하기 - Dial
//            val myIntent = Intent( Intent.ACTION_DIAL, myUri)

//        2. 주문하기 버튼을 눌렀을 때 -> 전화걸기 까지 - Call
//            val myIntent = Intent( Intent.ACTION_CALL, myUri)
//            에러남 - 권한 설정 문제 [close App] - 사용자의 허가 필요

//            3. 문자 전송

//            val myIntent = Intent( Intent.ACTION_SENDTO, myUri)
//            myIntent.putExtra("sms_body", "자동입력시켜줄내용")
/*            문자 공유하기 - 자동으로 링크 보내주는 것 -> 스미싱 때문에 활용 안함.
*               활용처 : 지정된 번호로 정해둔 내용을 문자로 보내면 본인인증 - 공인인증 같은 것
*               요즘은 push 알림을 많이 쓴다
* */

//            4. 인터넷 창 띄우는 (VIEW)
//            myUri = Uri.parse("https://naver.com")
//            val myIntent = Intent( Intent.ACTION_VIEW, myUri)

//            이용약관 주소 넣으면 - pdf로 뜨게

//            광고 링크 + 앱 다운로드 링크
//            5. 플레이스토이 링크 띄우기 (VIEW)
//            id=앱id값 복사해서 붙여주기
//            myUri = Uri.parse("market://details?id=앱id값")
//            myUri = Uri.parse("market://details?id=com.kakao.talk")
//            val myIntent = Intent( Intent.ACTION_VIEW, myUri)
//            (강제) 업데이트 하러 가기

//            6. (응용) 갤러리로 가서 사진 가져오기
//            사진을 가지러 화면으로 이동해서 -> 갖고 돌아온 이후의 처리까지 필요
//            intent(3) 사용법 같이 활용 -> TedPermission등으로 권한을 먼저 획득해야 한다.
//            방법을 외워서 사용하는게 아니고, 기능 존재만 인지하고 > 어떤 상황에서 꺼내다 쓰면 유용한지를 기억하자.
            /*val myIntent = Intent( Intent.ACTION_PICK, myUri)
            myIntent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
            startActivityForResult(myIntent, REQ_CODE_GALLERY)*/

        }

    }
}