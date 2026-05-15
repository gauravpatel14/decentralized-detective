package defpackage;

import android.os.Bundle;

/* JADX INFO: renamed from: hC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0759hC2 {
    public final int a;
    public final H62 b = new H62();
    public final int c = 1;
    public final Bundle d;

    public C0759hC2(int i, Bundle bundle) {
        this.a = i;
        this.d = bundle;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(this.c);
        sb.append(" id=");
        sb.append(this.a);
        sb.append(" oneWay=false}");
        return sb.toString();
    }
}
