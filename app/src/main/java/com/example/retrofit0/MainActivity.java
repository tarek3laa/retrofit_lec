package com.example.retrofit0;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private static final String TAG = "Main";
    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        api.getAll().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.d(TAG, "onResponse: z");
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: d");
                    posts = response.body();
                    String text = "";
                    for (int i = 0; i < posts.size(); i++) {
                        text += posts.get(i).getId() + "\n";
                        text += posts.get(i).getUserId() + "\n";
                        text += posts.get(i).getTitle() + "\n";
                        text += posts.get(i).getBody() + "\n";
                        text += "\n\n";

                    }
                    textView.setText(text);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT);
            }
        });

    }
}
