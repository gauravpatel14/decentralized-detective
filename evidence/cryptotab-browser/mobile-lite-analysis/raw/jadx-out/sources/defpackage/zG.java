package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zG {
    public final yG a;
    public int b;
    public int c;
    public int d = 0;

    public zG(yG yGVar) {
        gz0.a(yGVar, "input");
        this.a = yGVar;
        yGVar.b = this;
    }

    public static void R(int i) throws InvalidProtocolBufferException {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.i();
        }
    }

    public static void S(int i) throws InvalidProtocolBufferException {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.i();
        }
    }

    public final void A(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof C1118my0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 2) {
                int iZ = yGVar.z();
                R(iZ);
                int iD = yGVar.d() + iZ;
                do {
                    list.add(Integer.valueOf(yGVar.s()));
                } while (yGVar.d() < iD);
                return;
            }
            if (i != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Integer.valueOf(yGVar.s()));
                if (yGVar.e()) {
                    return;
                } else {
                    iY = yGVar.y();
                }
            } while (iY == this.b);
            this.d = iY;
            return;
        }
        C1118my0 c1118my0 = (C1118my0) list;
        int i2 = this.b & 7;
        if (i2 == 2) {
            int iZ2 = yGVar.z();
            R(iZ2);
            int iD2 = yGVar.d() + iZ2;
            do {
                c1118my0.g(yGVar.s());
            } while (yGVar.d() < iD2);
            return;
        }
        if (i2 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            c1118my0.g(yGVar.s());
            if (yGVar.e()) {
                return;
            } else {
                iY2 = yGVar.y();
            }
        } while (iY2 == this.b);
        this.d = iY2;
    }

    public final long B() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(1);
        return this.a.t();
    }

    public final void C(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof AbstractC1077mJ0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(yGVar.t()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iZ = yGVar.z();
            S(iZ);
            int iD = yGVar.d() + iZ;
            do {
                list.add(Long.valueOf(yGVar.t()));
            } while (yGVar.d() < iD);
            return;
        }
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) list;
        int i2 = this.b & 7;
        if (i2 == 1) {
            do {
                abstractC1077mJ0.g(yGVar.t());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iZ2 = yGVar.z();
        S(iZ2);
        int iD2 = yGVar.d() + iZ2;
        do {
            abstractC1077mJ0.g(yGVar.t());
        } while (yGVar.d() < iD2);
    }

    public final int D() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(0);
        return this.a.u();
    }

    public final void E(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof C1118my0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(yGVar.u()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iD = yGVar.d() + yGVar.z();
            do {
                list.add(Integer.valueOf(yGVar.u()));
            } while (yGVar.d() < iD);
            O(iD);
            return;
        }
        C1118my0 c1118my0 = (C1118my0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                c1118my0.g(yGVar.u());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iD2 = yGVar.d() + yGVar.z();
        do {
            c1118my0.g(yGVar.u());
        } while (yGVar.d() < iD2);
        O(iD2);
    }

    public final long F() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(0);
        return this.a.v();
    }

    public final void G(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof AbstractC1077mJ0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(yGVar.v()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iD = yGVar.d() + yGVar.z();
            do {
                list.add(Long.valueOf(yGVar.v()));
            } while (yGVar.d() < iD);
            O(iD);
            return;
        }
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                abstractC1077mJ0.g(yGVar.v());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iD2 = yGVar.d() + yGVar.z();
        do {
            abstractC1077mJ0.g(yGVar.v());
        } while (yGVar.d() < iD2);
        O(iD2);
    }

    public final String H() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(2);
        return this.a.w();
    }

    public final void I(List list, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iY;
        int iY2;
        if ((this.b & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        boolean z2 = list instanceof vE0;
        yG yGVar = this.a;
        if (!z2 || z) {
            do {
                list.add(z ? J() : H());
                if (yGVar.e()) {
                    return;
                } else {
                    iY = yGVar.y();
                }
            } while (iY == this.b);
            this.d = iY;
            return;
        }
        vE0 ve0 = (vE0) list;
        do {
            ve0.q(e());
            if (yGVar.e()) {
                return;
            } else {
                iY2 = yGVar.y();
            }
        } while (iY2 == this.b);
        this.d = iY2;
    }

    public final String J() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(2);
        return this.a.x();
    }

    public final int K() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(0);
        return this.a.z();
    }

    public final void L(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof C1118my0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(yGVar.z()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iD = yGVar.d() + yGVar.z();
            do {
                list.add(Integer.valueOf(yGVar.z()));
            } while (yGVar.d() < iD);
            O(iD);
            return;
        }
        C1118my0 c1118my0 = (C1118my0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                c1118my0.g(yGVar.z());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iD2 = yGVar.d() + yGVar.z();
        do {
            c1118my0.g(yGVar.z());
        } while (yGVar.d() < iD2);
        O(iD2);
    }

    public final long M() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(0);
        return this.a.A();
    }

    public final void N(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof AbstractC1077mJ0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(yGVar.A()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iD = yGVar.d() + yGVar.z();
            do {
                list.add(Long.valueOf(yGVar.A()));
            } while (yGVar.d() < iD);
            O(iD);
            return;
        }
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                abstractC1077mJ0.g(yGVar.A());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iD2 = yGVar.d() + yGVar.z();
        do {
            abstractC1077mJ0.g(yGVar.A());
        } while (yGVar.d() < iD2);
        O(iD2);
    }

    public final void O(int i) throws InvalidProtocolBufferException {
        if (this.a.d() != i) {
            throw InvalidProtocolBufferException.j();
        }
    }

    public final void P(int i) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if ((this.b & 7) != i) {
            throw InvalidProtocolBufferException.c();
        }
    }

    public final boolean Q() {
        int i;
        yG yGVar = this.a;
        if (yGVar.e() || (i = this.b) == this.c) {
            return false;
        }
        return yGVar.B(i);
    }

    public final int a() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.y();
        }
        int i2 = this.b;
        return (i2 == 0 || i2 == this.c) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i2 >>> 3;
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(0);
        return this.a.j();
    }

    public final void d(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof AbstractC0164Nt;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Boolean.valueOf(yGVar.j()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iD = yGVar.d() + yGVar.z();
            do {
                list.add(Boolean.valueOf(yGVar.j()));
            } while (yGVar.d() < iD);
            O(iD);
            return;
        }
        AbstractC0164Nt abstractC0164Nt = (AbstractC0164Nt) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                abstractC0164Nt.g(yGVar.j());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iD2 = yGVar.d() + yGVar.z();
        do {
            abstractC0164Nt.g(yGVar.j());
        } while (yGVar.d() < iD2);
        O(iD2);
    }

    public final C0199Qv e() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(2);
        return this.a.k();
    }

    public final void f(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iY;
        if ((this.b & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(e());
            yG yGVar = this.a;
            if (yGVar.e()) {
                return;
            } else {
                iY = yGVar.y();
            }
        } while (iY == this.b);
        this.d = iY;
    }

    public final double g() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(1);
        return this.a.l();
    }

    public final void h(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof AbstractC0876j10;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 1) {
                do {
                    list.add(Double.valueOf(yGVar.l()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iZ = yGVar.z();
            S(iZ);
            int iD = yGVar.d() + iZ;
            do {
                list.add(Double.valueOf(yGVar.l()));
            } while (yGVar.d() < iD);
            return;
        }
        AbstractC0876j10 abstractC0876j10 = (AbstractC0876j10) list;
        int i2 = this.b & 7;
        if (i2 == 1) {
            do {
                abstractC0876j10.g(yGVar.l());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iZ2 = yGVar.z();
        S(iZ2);
        int iD2 = yGVar.d() + iZ2;
        do {
            abstractC0876j10.g(yGVar.l());
        } while (yGVar.d() < iD2);
    }

    public final int i() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(0);
        return this.a.m();
    }

    public final void j(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof C1118my0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(yGVar.m()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iD = yGVar.d() + yGVar.z();
            do {
                list.add(Integer.valueOf(yGVar.m()));
            } while (yGVar.d() < iD);
            O(iD);
            return;
        }
        C1118my0 c1118my0 = (C1118my0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                c1118my0.g(yGVar.m());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iD2 = yGVar.d() + yGVar.z();
        do {
            c1118my0.g(yGVar.m());
        } while (yGVar.d() < iD2);
        O(iD2);
    }

    public final Object k(EnumC1415rw2 enumC1415rw2, Class cls, C1191o90 c1191o90) throws InvalidProtocolBufferException.InvalidWireTypeException {
        switch (enumC1415rw2.ordinal()) {
            case 0:
                return Double.valueOf(g());
            case 1:
                return Float.valueOf(p());
            case 2:
                return Long.valueOf(v());
            case 3:
                return Long.valueOf(M());
            case 4:
                return Integer.valueOf(t());
            case 5:
                return Long.valueOf(n());
            case 6:
                return Integer.valueOf(l());
            case 7:
                return Boolean.valueOf(c());
            case 8:
                return J();
            case ConnectionResult.SERVICE_INVALID /* 9 */:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                P(2);
                return x(C0734gn1.c.a(cls), c1191o90);
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                return e();
            case 12:
                return Integer.valueOf(K());
            case 13:
                return Integer.valueOf(i());
            case 14:
                return Integer.valueOf(z());
            case 15:
                return Long.valueOf(B());
            case 16:
                return Integer.valueOf(D());
            case 17:
                return Long.valueOf(F());
        }
    }

    public final int l() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(5);
        return this.a.n();
    }

    public final void m(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof C1118my0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 2) {
                int iZ = yGVar.z();
                R(iZ);
                int iD = yGVar.d() + iZ;
                do {
                    list.add(Integer.valueOf(yGVar.n()));
                } while (yGVar.d() < iD);
                return;
            }
            if (i != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Integer.valueOf(yGVar.n()));
                if (yGVar.e()) {
                    return;
                } else {
                    iY = yGVar.y();
                }
            } while (iY == this.b);
            this.d = iY;
            return;
        }
        C1118my0 c1118my0 = (C1118my0) list;
        int i2 = this.b & 7;
        if (i2 == 2) {
            int iZ2 = yGVar.z();
            R(iZ2);
            int iD2 = yGVar.d() + iZ2;
            do {
                c1118my0.g(yGVar.n());
            } while (yGVar.d() < iD2);
            return;
        }
        if (i2 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            c1118my0.g(yGVar.n());
            if (yGVar.e()) {
                return;
            } else {
                iY2 = yGVar.y();
            }
        } while (iY2 == this.b);
        this.d = iY2;
    }

    public final long n() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(1);
        return this.a.o();
    }

    public final void o(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof AbstractC1077mJ0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(yGVar.o()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iZ = yGVar.z();
            S(iZ);
            int iD = yGVar.d() + iZ;
            do {
                list.add(Long.valueOf(yGVar.o()));
            } while (yGVar.d() < iD);
            return;
        }
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) list;
        int i2 = this.b & 7;
        if (i2 == 1) {
            do {
                abstractC1077mJ0.g(yGVar.o());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iZ2 = yGVar.z();
        S(iZ2);
        int iD2 = yGVar.d() + iZ2;
        do {
            abstractC1077mJ0.g(yGVar.o());
        } while (yGVar.d() < iD2);
    }

    public final float p() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(5);
        return this.a.p();
    }

    public final void q(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof C1746xg0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 2) {
                int iZ = yGVar.z();
                R(iZ);
                int iD = yGVar.d() + iZ;
                do {
                    list.add(Float.valueOf(yGVar.p()));
                } while (yGVar.d() < iD);
                return;
            }
            if (i != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Float.valueOf(yGVar.p()));
                if (yGVar.e()) {
                    return;
                } else {
                    iY = yGVar.y();
                }
            } while (iY == this.b);
            this.d = iY;
            return;
        }
        C1746xg0 c1746xg0 = (C1746xg0) list;
        int i2 = this.b & 7;
        if (i2 == 2) {
            int iZ2 = yGVar.z();
            R(iZ2);
            int iD2 = yGVar.d() + iZ2;
            do {
                c1746xg0.g(yGVar.p());
            } while (yGVar.d() < iD2);
            return;
        }
        if (i2 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            c1746xg0.g(yGVar.p());
            if (yGVar.e()) {
                return;
            } else {
                iY2 = yGVar.y();
            }
        } while (iY2 == this.b);
        this.d = iY2;
    }

    public final Object r(Cz1 cz1, C1191o90 c1191o90) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            Object objJ = cz1.j();
            cz1.i(objJ, this, c1191o90);
            cz1.d(objJ);
            if (this.b == this.c) {
                return objJ;
            }
            throw InvalidProtocolBufferException.i();
        } finally {
            this.c = i;
        }
    }

    public final Object s(Cz1 cz1, C1191o90 c1191o90) throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(3);
        return r(cz1, c1191o90);
    }

    public final int t() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(0);
        return this.a.q();
    }

    public final void u(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof C1118my0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(yGVar.q()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iD = yGVar.d() + yGVar.z();
            do {
                list.add(Integer.valueOf(yGVar.q()));
            } while (yGVar.d() < iD);
            O(iD);
            return;
        }
        C1118my0 c1118my0 = (C1118my0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                c1118my0.g(yGVar.q());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iD2 = yGVar.d() + yGVar.z();
        do {
            c1118my0.g(yGVar.q());
        } while (yGVar.d() < iD2);
        O(iD2);
    }

    public final long v() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(0);
        return this.a.r();
    }

    public final void w(List list) throws InvalidProtocolBufferException {
        int iY;
        int iY2;
        boolean z = list instanceof AbstractC1077mJ0;
        yG yGVar = this.a;
        if (!z) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(yGVar.r()));
                    if (yGVar.e()) {
                        return;
                    } else {
                        iY = yGVar.y();
                    }
                } while (iY == this.b);
                this.d = iY;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iD = yGVar.d() + yGVar.z();
            do {
                list.add(Long.valueOf(yGVar.r()));
            } while (yGVar.d() < iD);
            O(iD);
            return;
        }
        AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                abstractC1077mJ0.g(yGVar.r());
                if (yGVar.e()) {
                    return;
                } else {
                    iY2 = yGVar.y();
                }
            } while (iY2 == this.b);
            this.d = iY2;
            return;
        }
        if (i2 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iD2 = yGVar.d() + yGVar.z();
        do {
            abstractC1077mJ0.g(yGVar.r());
        } while (yGVar.d() < iD2);
        O(iD2);
    }

    public final Object x(Cz1 cz1, C1191o90 c1191o90) throws InvalidProtocolBufferException {
        yG yGVar = this.a;
        int iZ = yGVar.z();
        if (yGVar.a >= 100) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int i = yGVar.i(iZ);
        Object objJ = cz1.j();
        yGVar.a++;
        cz1.i(objJ, this, c1191o90);
        cz1.d(objJ);
        yGVar.a(0);
        yGVar.a--;
        yGVar.h(i);
        return objJ;
    }

    public final Object y(Cz1 cz1, C1191o90 c1191o90) throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(2);
        return x(cz1, c1191o90);
    }

    public final int z() throws InvalidProtocolBufferException.InvalidWireTypeException {
        P(5);
        return this.a.s();
    }
}
