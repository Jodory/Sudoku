|모바일프로그래밍Sudoku프로젝트||2022-2|
| :- | :- | -: |

**모바일프로그래밍**

**Sudoku프로젝트**



![EMB00008940131d](Aspose.Words.239b3a91-7e92-4d29-a01b-5a78a22ad667.001.jpeg)





|**제출일**|**2022.12.12**|**전공**|**컴퓨터공학부**|
| :-: | :-: | :-: | :-: |
|**과목**|**모바일프로그래밍**|**학번**|**201812419**|
|**담당교수**|**윤익준 교수님**|**이름**|**조성운**|

**

1. **Introduction** 


|<p>**1.1 개요**	</p><p>- 2022-2 모바일프로그래밍 프로젝트를 위해 Sudoku를 개발하였다.</p><p>- 해당 프로젝트는 Android Studio로 개발하였다.</p><p>**1.2 기본 기능**</p><p>- UI Design & Game Initialization</p><p>- CustomButton Implementation</p><p>- Number Pad Implementation</p><p>- Game Rules Implementation</p><p>- Memo Implementation</p><p>- Finish Implementation</p><p>**1.3 추가 기능**</p><p>- Level Implementation</p><p>- Easy: 30 % blind.</p><p>- Normal: 50% blind.</p><p>- Hard: 70% blind</p><p>- BackgroundMusic Implementation</p><p>- 난이도 별 다른 음악 설정</p><p>- 충돌 존재 시 오류  효과음 설정</p><p>- 정답 시 오류 효과음 설정</p><p>- 종료 시 축하 효과음 설정</p><p>- 버튼 선택 시 Toast 추가</p><p>- 정답이면 “정답”출력</p><p>- 충돌 존재 시 “오답”출력</p><p>- 충돌 존재 시 진동으로 알림</p><p>- 종료 시 화면에 Alert Dialog 추가</p><p>- 종료 화면에서 Alert Dialog 추가하여 정말 종료할건지 다시 물어봄</p><p>- 버튼 두개 (OK,NO) 외에 Dialog 외부 클릭해도 닫히지 않게 .setCancelable(false)설정</p><p>- 게임 끝난 후 다시 시작할 수 있게 개발</p>|
| :- |

1. **Results** 

|<p>![](Aspose.Words.239b3a91-7e92-4d29-a01b-5a78a22ad667.002.png) ![](Aspose.Words.239b3a91-7e92-4d29-a01b-5a78a22ad667.003.png)![](Aspose.Words.239b3a91-7e92-4d29-a01b-5a78a22ad667.004.png)</p><p>`	`<초기화면>			<Exit클릭 시>			<Alert Dialog></p><p></p><p>![](Aspose.Words.239b3a91-7e92-4d29-a01b-5a78a22ad667.005.png) ![](Aspose.Words.239b3a91-7e92-4d29-a01b-5a78a22ad667.006.png) ![](Aspose.Words.239b3a91-7e92-4d29-a01b-5a78a22ad667.007.png)</p><p>`	`<난이도 EASY>		          <난이도 NORMAL>		<난이도 HARD></p><p></p>|
| :- |
||











1. **Code description** 

|<p>- Level Implementation</p><p>- Easy: 30 % blind.</p><p>- Normal: 50% blind.</p><p>- Hard: 70% blind</p><p>double random = Math.*random*();<br>if (level == 1)<br>`    `per = 0.3;<br>else if (level == 2)<br>`    `per = 0.5;<br>else if (level == 3)<br>`    `per = 0.7;<br>else<br>`    `per = 0.5;<br><br>if (random < per) {<br>`    `set(0);<br>`    `setClickable(true);<br>`    `textView.setTextColor(Color.*BLUE*);</p><p></p><p>- BackgroundMusic Implementation</p><p>- 난이도 별 다른 음악 설정</p><p>- 충돌 존재 시 오류  효과음 설정</p><p>- 정답 시 오류 효과음 설정</p><p>- 종료 시 축하 효과음 설정</p><p>package com.example.sudoku;<br><br>import android.app.Service;<br>import android.content.Intent;<br>import android.media.MediaPlayer;<br>import android.os.IBinder;<br><br>import androidx.annotation.Nullable;<br><br>public class MusicService extends Service {<br>`    `MediaPlayer mediaPlayer;<br><br>`    `@Nullable<br>`    `@Override<br>`    `public IBinder onBind(Intent intent) {<br>`        `return null;<br>`    `}<br><br><br>`    `@Override<br>`    `public void onCreate() {<br>`        `super.onCreate();<br>`        `if(MainActivity.*level* == 1)<br>`            `mediaPlayer = MediaPlayer.*create*(this, R.raw.*back1*);<br>`        `else if(MainActivity.*level* == 2)<br>`            `mediaPlayer = MediaPlayer.*create*(this, R.raw.*back2*);<br>`        `else if(MainActivity.*level* == 3)<br>`            `mediaPlayer = MediaPlayer.*create*(this, R.raw.*back3*);<br>`        `mediaPlayer.setLooping(true); // 무한 루프<br>`    `}<br><br><br>`    `@Override<br>`    `public int onStartCommand(Intent intent, int flags, int startId) {<br><br>`        `mediaPlayer.start();<br><br>`        `return super.onStartCommand(intent, flags, startId);<br>`    `}<br><br>`    `@Override<br>`    `public void onDestroy() {<br>`        `mediaPlayer.stop();<br>`        `mediaPlayer.release();<br>`        `super.onDestroy();<br>`    `}<br>}</p><p></p><p>MediaPlayer player = MediaPlayer.*create*(getContext(), R.raw.*alert*);<br>player.start();</p><p></p><p>MediaPlayer player = MediaPlayer.*create*(getContext(), R.raw.*correct*);<br>player.start();;</p><p></p><p>MediaPlayer player = MediaPlayer.*create*(getContext(), R.raw.*del*);<br>player.start();</p><p></p><p>- 버튼 선택 시 Toast 추가</p><p>- 정답이면 “정답”출력</p><p>- 충돌 존재 시 “오답”출력</p><p>if (bgColor == Color.*RED*) {<br>`                `Toast t = Toast.*makeText*(getContext(), "오답입니다..ㅜ", Toast.*LENGTH\_SHORT*);<br>`                `t.show();<br>`                `MediaPlayer player = MediaPlayer.*create*(getContext(), R.raw.*alert*);<br>`                `player.start();<br>`            `}<br>`            `else {<br>`                `Toast t = Toast.*makeText*(getContext(), "정답입니다!!!", Toast.*LENGTH\_SHORT*);<br>`                `t.show();<br>`                `MediaPlayer player = MediaPlayer.*create*(getContext(), R.raw.*correct*);<br>`                `player.start();;<br>`            `}<br>`        `}<br>`        `else {<br>`            `if(*buttons*[row][col].value != 0) {<br>`                `Toast t = Toast.*makeText*(getContext(), "정답입니다!!!", Toast.*LENGTH\_SHORT*);<br>`                `t.show();<br>`                `MediaPlayer player = MediaPlayer.*create*(getContext(), R.raw.*correct*);<br>`                `player.start();;<br>`            `}<br>`            `if(*buttons*[row][col].value == 0) {<br>`                `Toast t = Toast.*makeText*(getContext(), "해당 입력 삭제", Toast.*LENGTH\_SHORT*);<br>`                `t.show();<br>`                `MediaPlayer player = MediaPlayer.*create*(getContext(), R.raw.*del*);<br>`                `player.start();<br>`            `}<br>`        `}</p><p></p><p>- 충돌 존재 시 진동으로 알림</p><p>Vibrator vib = (Vibrator)getSystemService(*VIBRATOR\_SERVICE*);<br>vib.vibrate(1000);</p><p></p><p>- 종료 시 화면에 Alert Dialog 추가</p><p>- 종료 화면에서 Alert Dialog 추가하여 정말 종료할건지 다시 물어봄</p><p>- 버튼 두개 (OK,NO) 외에 Dialog 외부 클릭해도 닫히지 않게 .setCancelable(false)설정</p><p>@Override<br>`    `public void onClick(View v) {<br>`        `DialogInterface.OnClickListener ok = new DialogInterface.OnClickListener(){<br>`            `@Override<br>`            `public void onClick(DialogInterface dialog, int which){<br>`                `System.*exit*(0);<br>`                `dismiss();<br>`            `}<br>`        `};<br>`        `AlertDialog.Builder builder = new AlertDialog.Builder(context);<br>`        `builder.setIcon(R.drawable.*ic\_launcher\_background*);<br>`        `builder.setMessage("정말 종료하시겠습니까?");<br>`        `builder.setTitle("알림");<br>`        `builder.setPositiveButton("YES", ok);<br>`        `builder.setNegativeButton("NO", null);<br>`        `builder.setCancelable(false);<br><br>`        `AlertDialog alertDialog;<br>`        `alertDialog=builder.create();<br>`        `alertDialog.show();<br>`    `}<br>});</p><p></p><p>게임 끝난 후 다시 시작할 수 있게 개발</p>|
| :- |

|<p></p><p>![](Aspose.Words.239b3a91-7e92-4d29-a01b-5a78a22ad667.008.png)</p>||8|
| :-: | :-: | :-: |

