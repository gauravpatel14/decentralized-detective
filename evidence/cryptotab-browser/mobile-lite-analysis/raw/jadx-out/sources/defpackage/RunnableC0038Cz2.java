package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zact;

/* JADX INFO: renamed from: Cz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0038Cz2 implements Runnable {
    public final /* synthetic */ zact t;

    public RunnableC0038Cz2(zact zactVar) {
        this.t = zactVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.zah.zae(new ConnectionResult(4));
    }
}
