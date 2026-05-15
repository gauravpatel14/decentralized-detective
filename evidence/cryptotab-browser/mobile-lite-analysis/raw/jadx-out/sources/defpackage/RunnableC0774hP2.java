package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: renamed from: hP2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0774hP2 implements Runnable {
    public final InterfaceC0409bP2 t;
    public final int u;
    public final IOException v;
    public final byte[] w;
    public final String x;
    public final Map y;

    public /* synthetic */ RunnableC0774hP2(String str, InterfaceC0409bP2 interfaceC0409bP2, int i, IOException iOException, byte[] bArr, Map map) {
        Preconditions.checkNotNull(interfaceC0409bP2);
        this.t = interfaceC0409bP2;
        this.u = i;
        this.v = iOException;
        this.w = bArr;
        this.x = str;
        this.y = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.a(this.x, this.u, this.v, this.w, this.y);
    }
}
