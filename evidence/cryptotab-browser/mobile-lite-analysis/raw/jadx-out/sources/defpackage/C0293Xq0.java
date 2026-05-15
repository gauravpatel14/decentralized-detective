package defpackage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: Xq0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0293Xq0 {
    public static ArrayList a(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new En0((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    public final Vp0 b(AbstractC1701wu1 abstractC1701wu1, Map map) throws Throwable {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(Collections.emptyMap());
        URL url = new URL(abstractC1701wu1.u);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int i = abstractC1701wu1.D.a;
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url.getProtocol());
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            int i2 = abstractC1701wu1.t;
            if (i2 == 0) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("Unknown method type.");
                }
                httpURLConnection.setRequestMethod("POST");
                byte[] bArrD = abstractC1701wu1.d();
                if (bArrD != null) {
                    httpURLConnection.setDoOutput(true);
                    if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                        httpURLConnection.setRequestProperty("Content-Type", abstractC1701wu1.e());
                    }
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArrD);
                    dataOutputStream.close();
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (i2 == 4 || ((100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304)) {
                Vp0 vp0 = new Vp0(responseCode, a(httpURLConnection.getHeaderFields()), -1, null);
                httpURLConnection.disconnect();
                return vp0;
            }
            try {
                return new Vp0(responseCode, a(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new C0276Wq0(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
