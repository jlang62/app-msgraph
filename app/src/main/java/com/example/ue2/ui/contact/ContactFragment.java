package com.example.ue2.ui.contact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ue2.R;

public class ContactFragment extends Fragment {
    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_contact, container,false);

        editTextTo=(EditText)view.findViewById(R.id.editText1);
        editTextSubject=(EditText)view.findViewById(R.id.editText2);
        editTextMessage=(EditText)view.findViewById(R.id.editText3);

        send=(Button)view.findViewById(R.id.button1);

        send.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                Log.i("Send Email", "Email submitted");
            }

        });
        return view;
    }
}