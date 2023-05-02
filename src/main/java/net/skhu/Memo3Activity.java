package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class Memo3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo3);

        Button button = findViewById(R.id.btnSave);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_title = (EditText) findViewById(R.id.editText_title);
                String title = editText_title.getText().toString();
                if (TextUtils.isEmpty(title)) {
                    editText_title.setError("제목을 입력하세요");
                    return;
                }
₩
                EditText editText_content = (EditText) findViewById(R.id.editText_content);
                String content = editText_content.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    editText_content.setError("내용을 입력하세요");
                    return;
                }

                Memo3 memo = new Memo3(title, content, new Date());
                Intent intent = new Intent();
                // Intent 객체에 결과 데이터 넣기
                intent.putExtra("MEMO", memo);
                // setResult 메소드를 호출한다.
                setResult(RESULT_OK, intent);
                // 자식(Memo3Activity)는 종료 -> 결과 데이터가 부모(MainActivity)에 전달된다.
                finish();
            }
        };
        button.setOnClickListener(listener);
    }
}