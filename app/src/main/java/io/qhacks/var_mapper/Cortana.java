package io.qhacks.var_mapper;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by vishv on 2/4/2018.
 */

public class Cortana {

    public String getVoice(String message){
        SendPostRequest request = new SendPostRequest();
        request.doInBackground(new String[] { message } );
        return "";
    }

    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){}

        protected String doInBackground(String[] arg0) {

            try {

                URL url = new URL("https://speech.platform.bing.com/synthesize"); // here is your URL path

//                JSONObject postDataParams = new JSONObject();
//                //postDataParams.put("Ocp-Apim-Subscription-Key:", "c24500061b5f40529c8e599c04f5c8c6");
//                postDataParams.put("Content-Type", "application/ssml+xml");
//                postDataParams.put("X-Microsoft-OutputFormat", "ssml-16khz-16bit-mono-tts");
//                postDataParams.put("Authorization: Bearer", "wbaJ1mdKx2nP1MY/ioA9U/V+oG2xkERPJHoTK7Nd5PLO4hezDOEIPthqiVfpmpwRryMFDkqNsKykNIg1xHoeeQ==");
//                //postDataParams.put("X-Search-AppId", "50f32b40-7921-45f8-b60d-d8a209537d26");
//                //postDataParams.put("", "");


                String speakSSML = "<speak version=\"1.0\" xmlns=\"http://www.w3.org/2001/10/synthesis\" xml:lang=\"en-US\"><voice name=\"Microsoft Server Speech Text to Speech Voice (fr-FR, Hortense)\">\" + arg0[0] + \"</voice></speak>";



                //Log.e("params",postDataParams.toString());


                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);


                conn.setRequestProperty("Content-Type", "application/ssml+xml");
                conn.setRequestProperty("X-Microsoft-OutputFormat", "ssml-16khz-16bit-mono-tts");
                conn.setRequestProperty("Authorization: Bearer", "wbaJ1mdKx2nP1MY/ioA9U/V+oG2xkERPJHoTK7Nd5PLO4hezDOEIPthqiVfpmpwRryMFDkqNsKykNIg1xHoeeQ==");


                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(speakSSML);

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new
                            InputStreamReader(
                            conn.getInputStream()));

                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }

        }

        @Override
        protected void onPostExecute(String result) {
            System.out.println(result);
        }

        public String getPostDataString(JSONObject params) throws Exception {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            Iterator<String> itr = params.keys();

            while(itr.hasNext()){

                String key= itr.next();
                Object value = params.get(key);

                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(key, "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(value.toString(), "UTF-8"));

            }
            return result.toString();
        }
    }
}
