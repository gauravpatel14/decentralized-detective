package defpackage;

import android.graphics.Insets;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bx0 {
    public static final bx0 e = new bx0(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public bx0(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static bx0 a(bx0 bx0Var, bx0 bx0Var2) {
        return b(Math.max(bx0Var.a, bx0Var2.a), Math.max(bx0Var.b, bx0Var2.b), Math.max(bx0Var.c, bx0Var2.c), Math.max(bx0Var.d, bx0Var2.d));
    }

    public static bx0 b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new bx0(i, i2, i3, i4);
    }

    public static bx0 c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return ax0.a(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bx0.class != obj.getClass()) {
            return false;
        }
        bx0 bx0Var = (bx0) obj;
        return this.d == bx0Var.d && this.a == bx0Var.a && this.c == bx0Var.c && this.b == bx0Var.b;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "Insets{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
