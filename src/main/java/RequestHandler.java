import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class RequestHandler extends Application {
    final static OkHttpClient okHttpClient = new OkHttpClient();

    public static String detectCityId(String cityName) throws IOException {

//        URL url = new URL("https://gb.ru");
//        URLConnection urlConnection = url.openConnection();
//
//        HttpURLConnection httpURLConnection = (HttpURLConnection)  urlConnection;
//
//        System.out.println(httpURLConnection.getResponseCode());
//
//        Map<String, List<String>> headers = httpURLConnection.getHeaderFields();
//        for (String k :headers.keySet()) {
//            System.out.println("Ключ " + k + ". Значение: " + headers.get(k));
//        }

        String apiKey = "n4Hnt1jjtt55kFm5gubfGWugokMiS2Ri";
        String locationKey = "292254";
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cites")
                .addPathSegment("search")
                .addQueryParameter("apiKey", "n4Hnt1jjtt55kFm5gubfGWugokMiS2Ri")
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept","application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

//        System.out.println(response.headers());
//        System.out.println(response.code());

        String json = response.body().string();

        return json;
    }
}
