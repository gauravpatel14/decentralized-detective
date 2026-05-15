package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gY0 {
    public final boolean a;
    public final int b;
    public final int c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final String g;

    public gY0(boolean z, int i, int i2, boolean z2, String str, boolean z3, String str2) {
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = z2;
        this.e = str == null ? "" : str;
        this.f = z3;
        this.g = str2 == null ? "" : str2;
    }

    public final int a() {
        if (!this.a) {
            return 1;
        }
        int i = this.b;
        if (i != 0 && i != 4 && i != 5) {
            return 0;
        }
        switch (this.c) {
        }
        return 0;
    }

    public final int b() {
        if (this.a) {
            return C0908jY0.a(this.b, this.c);
        }
        return 6;
    }
}
