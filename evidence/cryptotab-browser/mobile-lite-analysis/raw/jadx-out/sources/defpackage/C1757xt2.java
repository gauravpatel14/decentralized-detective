package defpackage;

import android.util.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: xt2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1757xt2 {
    public final C1807yt2 a;
    public final C1871zt2 b;

    public C1757xt2(C1807yt2 c1807yt2, C1871zt2 c1871zt2) {
        this.a = c1807yt2;
        this.b = c1871zt2;
    }

    public final void a(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        C1807yt2 c1807yt2 = this.a;
        if (c1807yt2 != null) {
            jsonWriter.name("total");
            jsonWriter.beginObject();
            jsonWriter.name("label").value("");
            jsonWriter.name("amount");
            C1700wt2 c1700wt2 = c1807yt2.a;
            c1700wt2.getClass();
            jsonWriter.beginObject();
            jsonWriter.name("currency").value(c1700wt2.a);
            jsonWriter.name("value").value(c1700wt2.b);
            jsonWriter.endObject();
            jsonWriter.endObject();
        } else {
            jsonWriter.name("total").nullValue();
        }
        jsonWriter.name("supportedMethods").beginArray();
        C1871zt2 c1871zt2 = this.b;
        jsonWriter.value(c1871zt2.a);
        jsonWriter.endArray();
        jsonWriter.name("data").value(c1871zt2.b);
        jsonWriter.endObject();
    }
}
