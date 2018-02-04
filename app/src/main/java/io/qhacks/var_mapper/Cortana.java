//package io.qhacks.var_mapper;
//
//import android.content.Context;
//import android.media.AudioFormat;
//
//import org.json.JSONObject;
//
//import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.Iterator;
//
//
//import javax.net.ssl.HttpsURLConnection;
//
///**
// * Created by vishv on 2/4/2018.
// */
//
//public class Cortana {
//
//    private Context context;
//
//    public byte[] getVoice(String message, Context context){
//        this.context = context;
//        Send request = new Send();
//        return request.doInBackground(new String[] { message } );
//    }
//
//    public class Send {
//
//        public byte[] doInBackground(String[] arg0) {
//
//            try {
//
////                URL url = new URL("https://speech.platform.bing.com/synthesize"); // here is your URL path
////
//////                JSONObject postDataParams = new JSONObject();
//////                //postDataParams.put("Ocp-Apim-Subscription-Key:", "c24500061b5f40529c8e599c04f5c8c6");
//////                postDataParams.put("Content-Type", "application/ssml+xml");
//////                postDataParams.put("X-Microsoft-OutputFormat", "ssml-16khz-16bit-mono-tts");
//////                postDataParams.put("Authorization: Bearer", "wbaJ1mdKx2nP1MY/ioA9U/V+oG2xkERPJHoTK7Nd5PLO4hezDOEIPthqiVfpmpwRryMFDkqNsKykNIg1xHoeeQ==");
//////                //postDataParams.put("X-Search-AppId", "50f32b40-7921-45f8-b60d-d8a209537d26");
//////                //postDataParams.put("", "");
////
////
////                String speakSSML = "<speak version=\"1.0\" xmlns=\"http://www.w3.org/2001/10/synthesis\" xml:lang=\"en-US\"><voice name=\"Microsoft Server Speech Text to Speech Voice (fr-FR, Hortense)\">\" + arg0[0] + \"</voice></speak>";
////
////
////
////                //Log.e("params",postDataParams.toString());
////
////
////                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////                conn.setReadTimeout(15000 /* milliseconds */);
////                conn.setConnectTimeout(15000 /* milliseconds */);
////                conn.setRequestMethod("POST");
////                conn.setDoInput(true);
////                conn.setDoOutput(true);
////
////
////                conn.setRequestProperty("Content-Type", "application/ssml+xml");
////                conn.setRequestProperty("Authorization: Bearer", "wbaJ1mdKx2nP1MY/ioA9U/V+oG2xkERPJHoTK7Nd5PLO4hezDOEIPthqiVfpmpwRryMFDkqNsKykNIg1xHoeeQ==");
////
////                conn.setRequestProperty("X-Microsoft-OutputFormat", "ssml-16khz-16bit-mono-tts");
////
////                OutputStream os = conn.getOutputStream();
////                BufferedWriter writer = new BufferedWriter(
////                        new OutputStreamWriter(os, "UTF-8"));
////                writer.write(speakSSML);
////
////                writer.flush();
////                writer.close();
////                os.close();
////
////                int responseCode=conn.getResponseCode();
////
////                if (responseCode == HttpsURLConnection.HTTP_OK) {
////
////                    BufferedReader in=new BufferedReader(new
////                            InputStreamReader(
////                            conn.getInputStream()));
////
////                    StringBuffer sb = new StringBuffer("");
////                    String line="";
////
////                    while((line = in.readLine()) != null) {
////
////                        sb.append(line);
////                        break;
////                    }
////
////                    in.close();
////                    return sb.toString();
////
////                }
////                else {
////                    return new String("false : "+responseCode);
////                }
//                //Authentication auth = new Authentication("Your api key goes here");
//                URL url = new URL("https://speech.platform.bing.com/synthesize");
//                String speakSSML = "<speak version=\"1.0\" xmlns=\"http://www.w3.org/2001/10/synthesis\" xml:lang=\"en-US\"><voice name=\"Microsoft Server Speech Text to Speech Voice (fr-FR, Hortense)\">\" + arg0[0] + \"</voice></speak>";
//
//                Authentication auth = new Authentication("c24500061b5f40529c8e599c04f5c8c6");
//                String accessToken = auth.GetAccessToken();
//
//                HttpsURLConnection webRequest = (HttpsURLConnection) url.openConnection();
//                webRequest.setDoInput(true);
//                webRequest.setDoOutput(true);
//                webRequest.setConnectTimeout(5000);
//                webRequest.setReadTimeout(15000);
//                webRequest.setRequestMethod("POST");
//
//                webRequest.setRequestProperty("Content-Type", "application/ssml+xml");
//                webRequest.setRequestProperty("X-Microsoft-OutputFormat", "raw-8khz-8bit-mono-mulaw");
//                webRequest.setRequestProperty("Authorization", "Bearer " + accessToken);
//                webRequest.setRequestProperty("X-Search-AppId", "07D3234E49CE426DAA29772419F436CA");
//                webRequest.setRequestProperty("X-Search-ClientID", "1ECFAE91408841A480F00935DC390960");
//                webRequest.setRequestProperty("User-Agent", "TTSAndroid");
//                webRequest.setRequestProperty("Accept", "*/*");
//
//               // String body = speakSSML;
//                String body = XmlDom.createDom("en-US", "Gender.Female", "Microsoft Server Speech Text to Speech Voice (en-US, ZiraRUS)", arg0[0]);
//                byte[] bytes = body.getBytes();
//                webRequest.setRequestProperty("content-length", String.valueOf(bytes.length));
//                webRequest.connect();
//
//                DataOutputStream dop = new DataOutputStream(webRequest.getOutputStream());
//                dop.write(bytes);
//                dop.flush();
//                dop.close();
//
//                int responseCode=webRequest.getResponseCode();
//                InputStream inSt = webRequest.getInputStream();
//                ByteArray ba = new ByteArray();
//
//                int rn2 = 0;
//                int bufferLength = 4096;
//                byte[] buf2 = new byte[bufferLength];
//                while ((rn2 = inSt.read(buf2, 0, bufferLength)) > 0) {
//                    ba.cat(buf2, 0, rn2);
//                }
//
//                inSt.close();
//                webRequest.disconnect();
//
//playMp3(ba.getArray());
//
//                return ba.getArray();
//            }
//            catch(Exception e){
//                return null;
//            }
//
//        }
//
//
//
//        private void playMp3(byte[] mp3SoundByteArray)
//        {
//            try
//            {
//
//                byte[] data = ... //It's loaded from somewhere
////If you're loading from a file you can just store the format as an AudioInputStream object =  Audiosystem.getAudioInputStream(...) then
////   call object.getFormat() which will return a AudioFormat object
//                AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100.0f, 16, 1, 2, 44100.0f, false);
//                Clip clip = AudioSystem.getClip(); //generates a generic audio clip check API doc for more info
//                clip.open(format, data, 0, data.length);
//                clip.start();
//
////                String outputWave = ".\\output.pcm";
////
////                File outputAudio = new File(outputWave);
////
////                FileOutputStream fstream = new FileOutputStream(outputAudio);
////
////                fstream.write(audioBuffer);
////
////                fstream.flush();
////
////                fstream.close();
////
////
////
////
////
////                // specify the audio format
////
////                AudioFormat audioFormat = new AudioFormat(
////
////                        AudioFormat.Encoding.PCM_SIGNED,
////
////                        16000,
////
////                        16,
////
////                        1,
////
////                        1 * 2,
////
////                        16000,
////
////                        false);
////
////
////
////                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(outputWave));
////
////
////
////                DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,
////
////                        audioFormat, AudioSystem.NOT_SPECIFIED);
////
////                SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem
////
////                        .getLine(dataLineInfo);
////
////                sourceDataLine.open(audioFormat);
////
////                sourceDataLine.start();
////
////                System.out.println("start to play the wave:");
////
////              /*
////
////               * read the audio data and send to mixer
////
////               */
////
////                int count;
////
////                byte tempBuffer[] = new byte[4096];
////
////                while ((count = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) >0) {
////
////                    sourceDataLine.write(tempBuffer, 0, count);
////
////                }
////
////
////
////                sourceDataLine.drain();
////
////                sourceDataLine.close();
////
////                audioInputStream.close();
//            }
//            catch (IOException ex)
//            {
//                String s = ex.toString();
//                ex.printStackTrace();
//            }
//        }
//
//
//        public String getPostDataString(JSONObject params) throws Exception {
//
//            StringBuilder result = new StringBuilder();
//            boolean first = true;
//
//            Iterator<String> itr = params.keys();
//
//            while(itr.hasNext()){
//
//                String key= itr.next();
//                Object value = params.get(key);
//
//                if (first)
//                    first = false;
//                else
//                    result.append("&");
//
//                result.append(URLEncoder.encode(key, "UTF-8"));
//                result.append("=");
//                result.append(URLEncoder.encode(value.toString(), "UTF-8"));
//
//            }
//            return result.toString();
//        }
//    }
//}
