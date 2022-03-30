package com.example.splashscreen;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;



public class TimeThread extends AsyncTask<Integer,Integer,Integer> {
    private Context context;
   // private long finalDuration, updateDuration ;//every updateDuration secs user will be updated

    private Handler handler;
    int res;

    public TimeThread(Context context , Handler handler){
        this.context=context;
        this.handler=handler;
        //this.finalDuration=finalDuration;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Integer doInBackground(Integer... integers) {


        for (int i =0;i<=100;i++){

            try {
                Thread.sleep(1*1000);
                publishProgress(res);
                res=i;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i!=100) {
               publishProgress(res);
            }
        }
        return res;
    }

    @Override
    protected void onProgressUpdate(Integer... value) {
        super.onProgressUpdate(value);

        Message message = new Message();
        message.arg1=2;
        message.obj=value;
        handler.sendMessage(message);
    }

    @Override
    protected void onPostExecute(Integer res) {
        super.onPostExecute(res);
        Message message = new Message();
        message.arg1=1;
        message.obj= res;
        handler.sendMessage(message);
    }

}
