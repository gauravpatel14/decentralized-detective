package defpackage;

/* JADX INFO: renamed from: wo2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1695wo2 {
    public final UJ1 a = new UJ1(0);
    public final EJ0 b = new EJ0();

    public final void a(ps1 ps1Var, C0251Ur1 c0251Ur1) {
        UJ1 uj1 = this.a;
        C1638vo2 c1638vo2A = (C1638vo2) uj1.get(ps1Var);
        if (c1638vo2A == null) {
            c1638vo2A = C1638vo2.a();
            uj1.put(ps1Var, c1638vo2A);
        }
        c1638vo2A.c = c0251Ur1;
        c1638vo2A.a |= 8;
    }

    public final C0251Ur1 b(ps1 ps1Var, int i) {
        C1638vo2 c1638vo2;
        C0251Ur1 c0251Ur1;
        UJ1 uj1 = this.a;
        int iD = uj1.d(ps1Var);
        if (iD >= 0 && (c1638vo2 = (C1638vo2) uj1.i(iD)) != null) {
            int i2 = c1638vo2.a;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                c1638vo2.a = i3;
                if (i == 4) {
                    c0251Ur1 = c1638vo2.b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    c0251Ur1 = c1638vo2.c;
                }
                if ((i3 & 12) == 0) {
                    uj1.g(iD);
                    c1638vo2.a = 0;
                    c1638vo2.b = null;
                    c1638vo2.c = null;
                    C1638vo2.d.b(c1638vo2);
                }
                return c0251Ur1;
            }
        }
        return null;
    }

    public final void c(ps1 ps1Var) {
        C1638vo2 c1638vo2 = (C1638vo2) this.a.get(ps1Var);
        if (c1638vo2 == null) {
            return;
        }
        c1638vo2.a &= -2;
    }

    public final void d(ps1 ps1Var) {
        EJ0 ej0 = this.b;
        int iG = ej0.g() - 1;
        while (true) {
            if (iG < 0) {
                break;
            }
            if (ps1Var == ej0.h(iG)) {
                Object[] objArr = ej0.v;
                Object obj = objArr[iG];
                Object obj2 = FJ0.a;
                if (obj != obj2) {
                    objArr[iG] = obj2;
                    ej0.t = true;
                }
            } else {
                iG--;
            }
        }
        C1638vo2 c1638vo2 = (C1638vo2) this.a.remove(ps1Var);
        if (c1638vo2 != null) {
            c1638vo2.a = 0;
            c1638vo2.b = null;
            c1638vo2.c = null;
            C1638vo2.d.b(c1638vo2);
        }
    }
}
