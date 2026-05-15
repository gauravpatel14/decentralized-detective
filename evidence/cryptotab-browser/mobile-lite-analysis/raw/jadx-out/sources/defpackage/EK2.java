package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import java.util.HashSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EK2 implements InterfaceC0452cD2 {
    public final C0905jW2 a;

    public EK2(C0905jW2 c0905jW2) {
        this.a = c0905jW2;
    }

    @Override // defpackage.InterfaceC0452cD2
    public final Object zza() {
        Context context = this.a.a.a;
        ("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + "] ").concat("AppUpdateListenerRegistry");
        new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS");
        C0569eI2 c0569eI2 = new C0569eI2();
        new HashSet();
        context.getApplicationContext();
        return c0569eI2;
    }
}
