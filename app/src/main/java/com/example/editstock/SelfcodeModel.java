package com.example.editstock;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.support.constraint.Constraints.TAG;

public class SelfcodeModel {
    protected List<List<String>> getData() {
        //获取一组股票的数据
        OkHttpClient client = new OkHttpClient();
        String url = "http://hq.sinajs.cn/list=sz300033,sz300034,sz300035,sz300036,sz300037,sz300038,sz300039,sz300040,sz300041,sz300042,sz300043,sz300044,sz300045,sz300046" +
                ",sz300047,sz300048,sz300049,sz300050,sz300051,sz300052,sz300053,sz300054,sz300055,sz300056,sz300057,sz300058,sz300059";
        Request request = new Request.Builder().url(url).build();
        String result;
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        List<List<String>> allDataList = new ArrayList<>();
        String[] stockInfoArray = result.split(";\\n");
        for (String current : stockInfoArray) {
            Log.d(TAG, "getData: " + current);
            if (current.length() < 21) continue;
            String stockCode = current.substring(13, 19);
            current = current.substring(21);
            String[] splitStockData = current.split(",");
            List<String> currentStockData = new ArrayList<>(Arrays.asList(splitStockData));
            currentStockData.add(0, stockCode);
            allDataList.add(currentStockData);
        }
        return allDataList;
    }

}
