package defpackage;

import android.os.Bundle;

/* JADX INFO: renamed from: l13, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0999l13 {
    public final int a;
    public final H62 b = new H62();
    public final int c;
    public final Bundle d;

    public AbstractC0999l13(int i, int i2, Bundle bundle) {
        this.a = i;
        this.c = i2;
        this.d = bundle;
    }

    public abstract void a(Bundle bundle);

    public abstract boolean b();

    public final String toString() {
        boolean zB = b();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(this.c);
        sb.append(" id=");
        sb.append(this.a);
        sb.append(" oneWay=");
        sb.append(zB);
        sb.append("}");
        return sb.toString();
    }
}
