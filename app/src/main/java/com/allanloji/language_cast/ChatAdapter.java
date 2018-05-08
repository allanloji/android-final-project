package com.allanloji.language_cast;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.allanloji.language_cast.pojo.ChatModel;
import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<ChatModel> {

    private Context context;

    public ChatAdapter(@NonNull Context context, int resource, @NonNull List<ChatModel> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;
        convertView = null;
        ChatModel chatModel = getItem(position);
        if (convertView == null){
            if (chatModel.isSend()){
                view = LayoutInflater.from(context).inflate(R.layout.list_item_message_person,parent,false);
            }else {
                view = LayoutInflater.from(context).inflate(R.layout.list_item_message_robot,parent,false);
            }
        }

        BubbleTextView text_message = view.findViewById(R.id.text_message);
        text_message.setText(chatModel.getMessage());
        return view;
    }
}
