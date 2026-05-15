package defpackage;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: tW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC1516tW2 implements Callable {
    public final /* synthetic */ Context a;

    public CallableC1516tW2(Context context) {
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.a.getSharedPreferences("google_sdk_flags", 0);
    }
}
