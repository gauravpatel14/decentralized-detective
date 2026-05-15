package defpackage;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ss0 implements Closeable {
    public final URL t;
    public C0939k33 u;
    public volatile InputStream v;

    public Ss0(URL url) {
        this.t = url;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            InputStream inputStream = this.v;
            if (inputStream == null) {
                return;
            }
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        } catch (NullPointerException e) {
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", e);
        }
    }
}
