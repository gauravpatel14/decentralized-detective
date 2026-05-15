package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: renamed from: jV, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0903jV {
    public int a;
    public long b;
    public long c = 0;
    public final long d;
    public final long e;

    public C0903jV(int i, long j) {
        this.d = j;
        this.e = i;
    }

    public final void a(long j, long j2) {
        if (j % 8 != 0) {
            throw new DeserializationException("Incorrect starting alignment: " + j + ".");
        }
        if (j < this.b) {
            throw new DeserializationException("Trying to access memory out of order.");
        }
        if (j2 < j) {
            throw new DeserializationException("Incorrect memory range.");
        }
        if (j2 > this.d) {
            throw new DeserializationException("Trying to access out of range memory.");
        }
        this.b = (-8) & (j2 + 7);
    }
}
