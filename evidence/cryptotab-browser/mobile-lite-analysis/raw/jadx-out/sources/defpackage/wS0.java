package defpackage;

import org.chromium.mojo.bindings.DeserializationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class wS0 {
    public static final MT e = new MT(24, 0);
    public static final MT f = new MT(32, 1);
    public final MT a;
    public final int b;
    public final int c;
    public long d;

    public wS0(int i) {
        this.a = e;
        this.b = i;
        this.c = 0;
        this.d = 0L;
    }

    public final boolean a(int i) {
        return (this.c & i) == i;
    }

    public final boolean b(int i) {
        return (this.c & 7) == i;
    }

    public final boolean c(int i, int i2) {
        return this.b == i && b(i2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || wS0.class != obj.getClass()) {
            return false;
        }
        wS0 ws0 = (wS0) obj;
        MT mt = this.a;
        MT mt2 = ws0.a;
        return (mt == mt2 ? true : mt == null ? false : mt.equals(mt2)) && this.c == ws0.c && this.d == ws0.d && this.b == ws0.b;
    }

    public final int hashCode() {
        MT mt = this.a;
        int iHashCode = ((((mt == null ? 0 : mt.hashCode()) + 31) * 31) + this.c) * 31;
        long j = this.d;
        return ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.b;
    }

    public wS0(int i, int i2, long j) {
        this.a = f;
        this.b = i;
        this.c = i2;
        this.d = j;
    }

    public wS0(ER0 er0) {
        C0965kV c0965kV = new C0965kV(er0);
        MT mtF = c0965kV.f();
        this.a = mtF;
        int i = mtF.b;
        if (i >= 0) {
            int i2 = mtF.a;
            if (i2 < 24) {
                throw new DeserializationException(AbstractC1214oR1.a(i2, "Incorrect message size, expecting at least 24, but got: "));
            }
            if (i == 0 && i2 != 24) {
                throw new DeserializationException(AbstractC1214oR1.a(i2, "Incorrect message size for a message with 0 fields, expecting 24, but got: "));
            }
            if (i == 1 && i2 != 32) {
                throw new DeserializationException(AbstractC1214oR1.a(i2, "Incorrect message size for a message with 1 fields, expecting 32, but got: "));
            }
            if (c0965kV.n(8) == 0) {
                this.b = c0965kV.n(12);
                int iN = c0965kV.n(16);
                this.c = iN;
                if ((iN & 3) == 0) {
                    this.d = 0L;
                    return;
                } else {
                    if (i2 >= 32) {
                        this.d = c0965kV.q(24);
                        return;
                    }
                    throw new DeserializationException(AbstractC1214oR1.a(i2, "Incorrect message size, expecting at least 32 for a message with a request identifier, but got: "));
                }
            }
            throw new DeserializationException("Non-zero interface ID, expecting zero since associated interfaces are not yet supported.");
        }
        throw new DeserializationException(AbstractC1214oR1.a(i, "Incorrect number of fields, expecting at least 0, but got: "));
    }
}
