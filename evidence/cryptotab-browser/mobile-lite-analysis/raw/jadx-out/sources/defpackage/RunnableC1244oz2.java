package defpackage;

import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.zabq;

/* JADX INFO: renamed from: oz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1244oz2 implements Runnable {
    public final /* synthetic */ e t;

    public RunnableC1244oz2(e eVar) {
        this.t = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zabq zabqVar = this.t.a;
        zabqVar.zac.disconnect(zabqVar.zac.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
