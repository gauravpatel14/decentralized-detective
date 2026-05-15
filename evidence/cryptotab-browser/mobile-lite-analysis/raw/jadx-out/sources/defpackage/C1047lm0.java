package defpackage;

import android.os.Bundle;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: renamed from: lm0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1047lm0 implements xN {
    public final C1108mm0 a;

    public C1047lm0(C1108mm0 c1108mm0) {
        this.a = c1108mm0;
    }

    @Override // defpackage.xN
    public final Object a(G62 g62) throws IOException {
        this.a.getClass();
        Bundle bundle = (Bundle) g62.i(IOException.class);
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null || (string = bundle.getString("unregistered")) != null) {
            return string;
        }
        String string2 = bundle.getString("error");
        if ("RST".equals(string2)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string2 != null) {
            throw new IOException(string2);
        }
        String strValueOf = String.valueOf(bundle);
        Log.w("FirebaseInstanceId", S3.a(new StringBuilder(strValueOf.length() + 21), "Unexpected response: ", strValueOf), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}
