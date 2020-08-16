package com.cjc.threaddemo;

import android.os.AsyncTask;
import android.text.PrecomputedText;

/**
 * Created by CC
 **/
public class DownTask extends AsyncTask<Void, Integer, Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            while (true) {
                //int downloadPercent = doDownload();
                int downloadPercent = 0;
                publishProgress(downloadPercent);
                if (downloadPercent >= 100) {
                    break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
