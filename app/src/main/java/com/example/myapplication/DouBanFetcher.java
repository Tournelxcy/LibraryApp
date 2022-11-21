package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
public class DouBanFetcher extends BookFetcher{
    private static final String TAG = "DouBanFetcher";
    private Book mBook;
    private boolean success = false;
    @Override
    public void getBookInfo(final Context context, final String isbn){
        mContext = context;
        Retrofit mRetrofit;
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/book/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DB_API api = mRetrofit.create(DB_API.class);
        Call<DouBanJson> call = api.getDBResult(isbn);
        call.enqueue(new Callback<DouBanJson>() {
            @Override
            public void onResponse(Call<DouBanJson> call, Response<DouBanJson> response) {
                if(response.code() == 200) {
                    Log.i(TAG, "获取豆瓣信息成功，id = " + response.body().getId()
                            +"，标题 = " + response.body().getTitle());
                    success = true;
                    mBook = new Book();
                    mBook.setTitle(response.body().getTitle());
                    mBook.setId(Long.parseLong(response.body().getId(),10));
                    mBook.setIsbn(isbn);
                    if(response.body().getAuthor().size()!=0){
                        mBook.setAuthors(response.body().getAuthor());
                    }else{
                        mBook.setAuthors(null);
                    }
                    if(response.body().getTranslator().size()!=0){
                        mBook.setTranslators(response.body().getTranslator());
                    }else{
                        mBook.setTranslators(null);
                    }
                    mBook.setPublisher(response.body().getPublisher());
                    DateFormat df = new SimpleDateFormat("yyyy-MM");
                    Date pubDate = new Date();
                    try {
                        pubDate = df.parse(response.body().getPubdate());
                    }catch (ParseException pe){
                        Log.e(TAG,"解析日期异常"+pe);
                    }
                    mBook.setPubtime(pubDate);
                    String imageURL = response.body().getImages().getLarge();
                    getAndSaveImg(imageURL,mBook.getId());
                }else{
                    Log.w(TAG,"意外的响应代码" + response.code() + ", isbn = " + isbn);
                    Log.i(TAG,"意外的响应代码" + response.code() + ", isbn = " + isbn);
                    Toast.makeText(context,R.string.fetcher_response_unmatched,Toast.LENGTH_LONG).show();
                    success = false;
                }
            }
            @Override
            public void onFailure(Call<DouBanJson> call, Throwable t) {
                Log.w(TAG,"获取豆瓣信息失败， " + t.toString());
                Toast.makeText(context,R.string.fetcher_response_unmatched,Toast.LENGTH_LONG).show();
                success = false;
            }
        });
    }
    private interface DB_API{
        @GET ("isbn/{isbn}")
        Call<DouBanJson> getDBResult(@Path("isbn") String isbn);
    }
}
