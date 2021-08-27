package com.example.newsapp.ViewModel;

import android.nfc.Tag;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.Model.GetMainObj;
import com.example.newsapp.Model.GetModel;
import com.example.newsapp.Network.GetApi;
import com.example.newsapp.Network.RetrofitCall;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static android.content.ContentValues.TAG;
public class MainViewModel extends ViewModel {
    private RetrofitCall retrofitCall;
    private GetApi getApi;
    private MutableLiveData<List<GetModel>> dataList;
    private String api_key="02a50775a2fc445bb056fae4a9950bd2";
    public MainViewModel(){
        dataList=new MutableLiveData<>();
    }
    public LiveData<List<GetModel>> getMainObjLiveData() {
        return dataList;
    }
    public void makeApiCallForCategories(String category) {
        getApi = RetrofitCall.getApiInterface();
        Call<GetMainObj> call = getApi.getcategoryobj("us",category,api_key);
        call.enqueue(new Callback<GetMainObj>() {
            @Override
            public void onResponse(Call<GetMainObj> call, Response<GetMainObj> response) {
                if(response.isSuccessful()){
                    dataList.postValue(response.body().getArticles());
                }
            }
            @Override
            public void onFailure(Call<GetMainObj> call, Throwable t) {
                Log.i(TAG,"OOPS",t);
            }
        });
    }
    public void makeApiCall(){
        getApi = RetrofitCall.getApiInterface();
        Call <GetMainObj> call=getApi.getmainobj("us",api_key);
        call.enqueue(new Callback<GetMainObj>() {
            @Override
            public void onResponse(Call<GetMainObj> call, Response<GetMainObj> response) {
                dataList.postValue(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<GetMainObj> call, Throwable t) {
                Log.i(TAG,"OOPS",t);
            }
        });
    }

}
