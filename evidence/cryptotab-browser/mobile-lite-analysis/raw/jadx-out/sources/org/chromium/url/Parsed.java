package org.chromium.url;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Parsed {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final Parsed q;
    public final boolean r;

    public Parsed(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z, Parsed parsed) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
        this.i = i9;
        this.j = i10;
        this.k = i11;
        this.l = i12;
        this.m = i13;
        this.n = i14;
        this.o = i15;
        this.p = i16;
        this.r = z;
        this.q = parsed;
    }

    public static Parsed a(int i, String[] strArr) {
        return new Parsed(Integer.parseInt(strArr[i]), Integer.parseInt(strArr[i + 1]), Integer.parseInt(strArr[i + 2]), Integer.parseInt(strArr[i + 3]), Integer.parseInt(strArr[i + 4]), Integer.parseInt(strArr[i + 5]), Integer.parseInt(strArr[i + 6]), Integer.parseInt(strArr[i + 7]), Integer.parseInt(strArr[i + 8]), Integer.parseInt(strArr[i + 9]), Integer.parseInt(strArr[i + 10]), Integer.parseInt(strArr[i + 11]), Integer.parseInt(strArr[i + 12]), Integer.parseInt(strArr[i + 13]), Integer.parseInt(strArr[i + 14]), Integer.parseInt(strArr[i + 15]), Boolean.parseBoolean(strArr[i + 16]), Boolean.parseBoolean(strArr[i + 17]) ? a(i + 18, strArr) : null);
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append((char) 0);
        sb.append(this.b);
        sb.append((char) 0);
        sb.append(this.c);
        sb.append((char) 0);
        sb.append(this.d);
        sb.append((char) 0);
        sb.append(this.e);
        sb.append((char) 0);
        sb.append(this.f);
        sb.append((char) 0);
        sb.append(this.g);
        sb.append((char) 0);
        sb.append(this.h);
        sb.append((char) 0);
        sb.append(this.i);
        sb.append((char) 0);
        sb.append(this.j);
        sb.append((char) 0);
        sb.append(this.k);
        sb.append((char) 0);
        sb.append(this.l);
        sb.append((char) 0);
        sb.append(this.m);
        sb.append((char) 0);
        sb.append(this.n);
        sb.append((char) 0);
        sb.append(this.o);
        sb.append((char) 0);
        sb.append(this.p);
        sb.append((char) 0);
        sb.append(this.r);
        sb.append((char) 0);
        Parsed parsed = this.q;
        sb.append(parsed != null);
        if (parsed != null) {
            sb.append((char) 0);
            sb.append(parsed.b());
        }
        return sb.toString();
    }
}
