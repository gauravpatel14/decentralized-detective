package defpackage;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QV implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ RV b;

    public /* synthetic */ QV(RV rv, int i) {
        this.a = i;
        this.b = rv;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String string;
        switch (this.a) {
            case 0:
                RV rv = this.b;
                synchronized (rv) {
                    ((Mn0) rv.a.get()).h(System.currentTimeMillis(), ((C1680wW) rv.c.get()).a());
                    break;
                }
                return null;
            default:
                RV rv2 = this.b;
                synchronized (rv2) {
                    try {
                        Mn0 mn0 = (Mn0) rv2.a.get();
                        ArrayList arrayListC = mn0.c();
                        mn0.b();
                        JSONArray jSONArray = new JSONArray();
                        for (int i = 0; i < arrayListC.size(); i++) {
                            C1346qi c1346qi = (C1346qi) arrayListC.get(i);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("agent", c1346qi.a);
                            jSONObject.put("dates", new JSONArray((Collection) c1346qi.b));
                            jSONArray.put(jSONObject);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("heartbeats", jSONArray);
                        jSONObject2.put("version", "2");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                        try {
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                            try {
                                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                                gZIPOutputStream.close();
                                base64OutputStream.close();
                                string = byteArrayOutputStream.toString("UTF-8");
                            } catch (Throwable th) {
                                try {
                                    gZIPOutputStream.close();
                                    break;
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                base64OutputStream.close();
                                break;
                            } catch (Throwable unused2) {
                            }
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return string;
        }
    }
}
