package defpackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.util.SparseArray;
import java.util.HashMap;
import org.chromium.ui.base.WindowAndroid;

/* JADX INFO: renamed from: xy0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1760xy0 {
    public int b;
    public final W3 c;
    public final SparseArray a = new SparseArray();
    public HashMap d = new HashMap();

    public C1760xy0(W3 w3) {
        this.c = w3;
    }

    public final boolean a(int i, int i2, Intent intent) {
        SparseArray sparseArray = this.a;
        InterfaceC0932jv2 interfaceC0932jv2 = (InterfaceC0932jv2) sparseArray.get(i);
        sparseArray.delete(i);
        String str = (String) this.d.remove(Integer.valueOf(i));
        if (interfaceC0932jv2 != null) {
            interfaceC0932jv2.a(intent, i2);
            return true;
        }
        if (str != null && !this.c.a(str)) {
            Lt0 lt0 = WindowAndroid.P;
            C0064Fa2.c(AbstractC1499tM.a, str, 0).e();
        }
        return false;
    }

    public final int b(PendingIntent pendingIntent, InterfaceC0932jv2 interfaceC0932jv2) {
        int i = this.b;
        int i2 = i + 1000;
        this.b = (i + 1) % 100;
        IntentSender intentSender = pendingIntent.getIntentSender();
        Activity activity = (Activity) this.c.a.get();
        if (activity == null) {
            return -1;
        }
        try {
            activity.startIntentSenderForResult(intentSender, i2, new Intent(), 0, 0, 0);
            this.a.put(i2, interfaceC0932jv2);
            this.d.put(Integer.valueOf(i2), null);
            return i2;
        } catch (IntentSender.SendIntentException unused) {
            return -1;
        }
    }
}
