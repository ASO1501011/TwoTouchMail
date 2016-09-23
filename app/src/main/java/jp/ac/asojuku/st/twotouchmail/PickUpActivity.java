package jp.ac.asojuku.st.twotouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PickUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);
        Button btnSend = (Button) this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgplace = (RadioGroup) findViewById(R.id.rg_place);
                int checkedId = rgplace.getCheckedRadioButtonId();
                String strPlace = ((RadioButton) findViewById(checkedId)).getText().toString();
                EditText edit01 = (EditText) findViewById(R.id.editText);
                String title = edit01.getText().toString();
                Resources res = getResources();
                //授業課題 randomでメールアドレスを選択
                int ram = (int)(Math.random()*5);
                Uri uri = Uri.parse("");
                switch(ram){
                    case 0:
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
                        break;
                    case 1:
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail_to2).toString());
                        break;
                    case 2:
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail_to3).toString());
                        break;
                    case 3:
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail_to4).toString());
                        break;
                    case 4:
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail_to5).toString());
                        break;
                    default:
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
                        break;
                }
                Log.e("int",Integer.toString(ram));
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra(Intent.EXTRA_SUBJECT,title);
                intent.putExtra(Intent.EXTRA_TEXT,strPlace + "に迎えに来て");
                startActivity(intent);
            }
        });
    }
}







