package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: renamed from: cO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC0466cO0 extends Handler {
    public final /* synthetic */ C0526dO0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0466cO0(C0526dO0 c0526dO0) {
        super(Looper.getMainLooper());
        this.a = c0526dO0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        int i2 = message.arg1;
        Object obj = message.obj;
        Bundle bundlePeekData = message.peekData();
        C0526dO0 c0526dO0 = this.a;
        bt1 bt1Var = (bt1) c0526dO0.j.get(i2);
        if (bt1Var == null) {
            Log.w("MR2Provider", "Pending callback not found for control request.");
            return;
        }
        c0526dO0.j.remove(i2);
        if (i == 3) {
            bt1Var.a((Bundle) obj);
        } else {
            if (i != 4) {
                return;
            }
            if (bundlePeekData != null) {
                bundlePeekData.getString("error");
            }
            Objects.toString((Bundle) obj);
        }
    }
}
