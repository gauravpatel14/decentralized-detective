package defpackage;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MP2 {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final /* synthetic */ TP2 e;

    public /* synthetic */ MP2(TP2 tp2, long j) {
        this.e = tp2;
        Preconditions.checkNotEmpty("health_monitor");
        Preconditions.checkArgument(j > 0);
        this.a = "health_monitor:start";
        this.b = "health_monitor:count";
        this.c = "health_monitor:value";
        this.d = j;
    }

    public final void a() {
        TP2 tp2 = this.e;
        tp2.g();
        long jCurrentTimeMillis = tp2.a.n.currentTimeMillis();
        SharedPreferences.Editor editorEdit = tp2.k().edit();
        editorEdit.remove(this.b);
        editorEdit.remove(this.c);
        editorEdit.putLong(this.a, jCurrentTimeMillis);
        editorEdit.apply();
    }
}
