package co.ilovato.ederapp;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

/**
 * Created by eder on 16/08/2015.
 */
public class httpHandler {
    public String post(String posturl){
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(posturl);

            //AÑADIR PARAMETROS
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("data","Variable 1"));
            params.add(new BasicNameValuePair("info","Other msg"));
            httppost.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            String text = EntityUtils.toString(entity);

            return text;

        }
        catch (Exception e) {
            return "ERROR";
        }
    }
}
