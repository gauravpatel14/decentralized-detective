package defpackage;

import android.os.Build;
import java.util.PriorityQueue;

/* JADX INFO: renamed from: Na2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0154Na2 {
    public static C0154Na2 d;
    public final PriorityQueue a = new PriorityQueue(new C0079Ga2());
    public final InterfaceC0099Ia2 b;
    public C0064Fa2 c;

    public C0154Na2() {
        if (Build.VERSION.SDK_INT < 30) {
            this.b = new C0111Ja2(this, new RunnableC0089Ha2(this));
        } else {
            this.b = new C0138Ma2(new RunnableC0089Ha2(this));
        }
    }

    public final void a() {
        C0064Fa2 c0064Fa2 = (C0064Fa2) this.a.poll();
        this.c = c0064Fa2;
        if (c0064Fa2 != null) {
            c0064Fa2.a.show();
            this.b.b(this.c);
        }
    }
}
