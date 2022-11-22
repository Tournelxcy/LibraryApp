package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;
import android.os.Environment;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.os.Handler;
public abstract class BookFetcher{
    private static final String TAG = "BookFetcher";
    protected Context mContext;
    protected Book mBook;
    protected Handler mHandler;

    protected abstract void getBookInfo(Context context, String isbn);
}