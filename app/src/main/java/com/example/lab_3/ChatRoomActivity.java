package com.example.lab_3;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlabs.R;

import java.util.ArrayList;

public class ChatRoomActivity extends AppCompatActivity {

    private static final String TAG = "ChatRoomActivity";


    private ListView chatListView;
    private EditText chatText;
    private Button btnSend, btnReceive;
    private String typedMessage;

    private ArrayList<ChatMessage> mMessageArrayList = new ArrayList<ChatMessage>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room_activity);
        Log.e(TAG, "onCreate: started");


        btnSend = (Button) findViewById(R.id.BtnSend);
        btnReceive = (Button) findViewById(R.id.BtnReceive);
        chatText = (EditText) findViewById(R.id.chatText);
        chatListView = (ListView) findViewById(R.id.chatListView);

    }


    public void sendChatMessage(View args0) {
        typedMessage = chatText.getText().toString();
        ChatMessage chatMessage = new ChatMessage(true,false,typedMessage);
        mMessageArrayList.add(chatMessage);
        ChatListAdapter chatAdapter = new ChatListAdapter();
        chatListView.setAdapter(chatAdapter);
        chatText.setText("");
        chatAdapter.notifyDataSetChanged();
    }


    public void receiveChatMessage(View args0) {
        typedMessage = chatText.getText().toString();
        ChatMessage chatMessage = new ChatMessage(false,true,typedMessage);
        mMessageArrayList.add(chatMessage);
        ChatListAdapter chatAdapter = new ChatListAdapter();
        chatListView.setAdapter(chatAdapter);
        chatText.setText("");
        chatAdapter.notifyDataSetChanged();
    }


    private class ChatListAdapter extends BaseAdapter {

        private static final String TAG = "ChatListAdapter";
        private Context mContext;
        private String mMessage;
        private int mResource;

        public int getCount() {
            return mMessageArrayList.size();
        } //This function tells how many objects to show

        public Object getItem(int position) {
            return mMessageArrayList.get(position);
        }  //This returns the string at position p

        public long getItemId(int p) {
            return p;
        } //This returns the database id of the item at position p

        public View getView(int p, View customView, ViewGroup parent) {
            View thisRow = customView;

            if (mMessageArrayList.get(p).isRight()) {
                thisRow = getLayoutInflater().inflate(R.layout.sent_message, null);
                TextView sendTextView = (TextView) thisRow.findViewById(R.id.msgSent);
                sendTextView.setText(mMessageArrayList.get(p).getMessage());
            } else if (mMessageArrayList.get(p).isLeft()) {
                thisRow = getLayoutInflater().inflate(R.layout.recieved_message, null);
                TextView receiveTextView = (TextView) thisRow.findViewById(R.id.msgReceived);
                receiveTextView.setText(mMessageArrayList.get(p).getMessage());
            }
            return thisRow;

        }
    }

}
