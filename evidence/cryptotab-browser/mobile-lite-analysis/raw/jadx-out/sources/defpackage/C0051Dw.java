package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: Dw, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0051Dw {
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final ArrayList f = new ArrayList(1);

    public C0051Dw(int i, int i2, int i3, int i4, String str) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public final synchronized boolean a(int i) {
        if (this.f.size() >= 256) {
            return false;
        }
        this.f.add(Integer.valueOf(i));
        return true;
    }
}
