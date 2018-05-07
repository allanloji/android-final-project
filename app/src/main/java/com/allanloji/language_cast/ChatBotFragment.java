package com.allanloji.language_cast;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ai.api.AIDataService;
import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;

/**
 * A simple {@link Fragment} subclass.
 */

public class ChatBotFragment extends Fragment implements AIListener{

    public ChatBotFragment() {
        // Required empty public constructor
    }

    private EditText chatText;
    private TextView chatView;
    private Button chatButton;

    private AIService aiService;
    private AIDataService aiDataService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_bot, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final AIConfiguration config =
                new AIConfiguration("a9f8925e4d464c8fbccc21310cd04bf5",
                        AIConfiguration.SupportedLanguages.Spanish,
                        AIConfiguration.RecognitionEngine.System);

        aiDataService = new AIDataService(config);
        aiService = AIService.getService(getActivity(), config);
        aiService.setListener(this);

        chatButton = (Button) getView().findViewById(R.id.chatButton);
        chatText = (EditText) getView().findViewById(R.id.chatText);
        chatView = (TextView) getView().findViewById(R.id.chatView);
        chatView.setMovementMethod(new ScrollingMovementMethod());

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SendRequestTask(aiDataService).execute(chatText.getText().toString());
                chatText.getText().clear();
            }
        });
    }

    public class SendRequestTask extends AsyncTask<String, String, AIResponse> {

        private AIDataService aiDataService;

        public SendRequestTask(AIDataService aiDataService) {
            this.aiDataService = aiDataService;
        }

        @Override
        protected AIResponse doInBackground(String... strings) {
            AIRequest aiRequest = new AIRequest();
            AIResponse aiResponse = null;

            try {
                aiRequest.setQuery(strings[0]);
                aiResponse = aiDataService.request(aiRequest);
            } catch (AIServiceException e) {
                e.printStackTrace();
            }

            return aiResponse;
        }

        @Override
        protected void onPostExecute(AIResponse aiResponse) {
            super.onPostExecute(aiResponse);
            Result result = aiResponse.getResult();
            int message = result.getResolvedQuery().length() ;
            chatView.append("Tu: " + result.getResolvedQuery() + "\r\n");
            chatView.append("ChatBot: " + result.getFulfillment().getSpeech() + "\r\n" + "\r\n");
        }
    }

    @Override
    public void onResult(AIResponse result) {

    }

    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
