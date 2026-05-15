package defpackage;

/* JADX INFO: renamed from: Qz, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0203Qz {
    public long a = 0;
    public C0203Qz b;

    public final void a(int i) {
        if (i < 64) {
            this.a &= ~(1 << i);
            return;
        }
        C0203Qz c0203Qz = this.b;
        if (c0203Qz != null) {
            c0203Qz.a(i - 64);
        }
    }

    public final int b(int i) {
        C0203Qz c0203Qz = this.b;
        if (c0203Qz == null) {
            return i >= 64 ? Long.bitCount(this.a) : Long.bitCount(this.a & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.a & ((1 << i) - 1));
        }
        return Long.bitCount(this.a) + c0203Qz.b(i - 64);
    }

    public final void c() {
        if (this.b == null) {
            this.b = new C0203Qz();
        }
    }

    public final boolean d(int i) {
        if (i < 64) {
            return (this.a & (1 << i)) != 0;
        }
        c();
        return this.b.d(i - 64);
    }

    public final void e(int i, boolean z) {
        if (i >= 64) {
            c();
            this.b.e(i - 64, z);
            return;
        }
        long j = this.a;
        boolean z2 = (Long.MIN_VALUE & j) != 0;
        long j2 = (1 << i) - 1;
        this.a = ((j & (~j2)) << 1) | (j & j2);
        if (z) {
            h(i);
        } else {
            a(i);
        }
        if (z2 || this.b != null) {
            c();
            this.b.e(0, z2);
        }
    }

    public final boolean f(int i) {
        if (i >= 64) {
            c();
            return this.b.f(i - 64);
        }
        long j = 1 << i;
        long j2 = this.a;
        boolean z = (j2 & j) != 0;
        long j3 = j2 & (~j);
        this.a = j3;
        long j4 = j - 1;
        this.a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        C0203Qz c0203Qz = this.b;
        if (c0203Qz != null) {
            if (c0203Qz.d(0)) {
                h(63);
            }
            this.b.f(0);
        }
        return z;
    }

    public final void g() {
        this.a = 0L;
        C0203Qz c0203Qz = this.b;
        if (c0203Qz != null) {
            c0203Qz.g();
        }
    }

    public final void h(int i) {
        if (i < 64) {
            this.a |= 1 << i;
        } else {
            c();
            this.b.h(i - 64);
        }
    }

    public final String toString() {
        if (this.b == null) {
            return Long.toBinaryString(this.a);
        }
        return this.b.toString() + "xx" + Long.toBinaryString(this.a);
    }
}
