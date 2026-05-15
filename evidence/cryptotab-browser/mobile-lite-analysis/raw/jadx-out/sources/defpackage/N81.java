package defpackage;

import android.graphics.Color;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class N81 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public boolean f;
    public int g;
    public int h;
    public float[] i;

    public N81(int i, int i2) {
        this.a = Color.red(i);
        this.b = Color.green(i);
        this.c = Color.blue(i);
        this.d = i;
        this.e = i2;
    }

    public final void a() {
        if (this.f) {
            return;
        }
        int i = this.d;
        int iF = AbstractC1721xH.f(4.5f, -1, i);
        int iF2 = AbstractC1721xH.f(3.0f, -1, i);
        if (iF != -1 && iF2 != -1) {
            this.h = AbstractC1721xH.i(-1, iF);
            this.g = AbstractC1721xH.i(-1, iF2);
            this.f = true;
            return;
        }
        int iF3 = AbstractC1721xH.f(4.5f, -16777216, i);
        int iF4 = AbstractC1721xH.f(3.0f, -16777216, i);
        if (iF3 == -1 || iF4 == -1) {
            this.h = iF != -1 ? AbstractC1721xH.i(-1, iF) : AbstractC1721xH.i(-16777216, iF3);
            this.g = iF2 != -1 ? AbstractC1721xH.i(-1, iF2) : AbstractC1721xH.i(-16777216, iF4);
            this.f = true;
        } else {
            this.h = AbstractC1721xH.i(-16777216, iF3);
            this.g = AbstractC1721xH.i(-16777216, iF4);
            this.f = true;
        }
    }

    public final float[] b() {
        if (this.i == null) {
            this.i = new float[3];
        }
        AbstractC1721xH.a(this.a, this.b, this.c, this.i);
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || N81.class != obj.getClass()) {
            return false;
        }
        N81 n81 = (N81) obj;
        return this.e == n81.e && this.d == n81.d;
    }

    public final int hashCode() {
        return (this.d * 31) + this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(N81.class.getSimpleName());
        sb.append(" [RGB: #");
        sb.append(Integer.toHexString(this.d));
        sb.append("] [HSL: ");
        sb.append(Arrays.toString(b()));
        sb.append("] [Population: ");
        sb.append(this.e);
        sb.append("] [Title Text: #");
        a();
        sb.append(Integer.toHexString(this.g));
        sb.append("] [Body Text: #");
        a();
        sb.append(Integer.toHexString(this.h));
        sb.append(']');
        return sb.toString();
    }
}
