package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class GA2 extends Handler {
    private final Looper zaa;

    public GA2(Looper looper) {
        super(looper);
        this.zaa = Looper.getMainLooper();
    }

    public GA2(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zaa = Looper.getMainLooper();
    }
}
