package defpackage;

/* JADX INFO: renamed from: Sv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0228Sv2 {
    public final C0383aw2 a;
    public bx0[] b;

    public AbstractC0228Sv2() {
        this(new C0383aw2());
    }

    public final void a() {
        bx0[] bx0VarArr = this.b;
        if (bx0VarArr != null) {
            bx0 bx0VarF = bx0VarArr[0];
            bx0 bx0VarF2 = bx0VarArr[1];
            C0383aw2 c0383aw2 = this.a;
            if (bx0VarF2 == null) {
                bx0VarF2 = c0383aw2.a.f(2);
            }
            if (bx0VarF == null) {
                bx0VarF = c0383aw2.a.f(1);
            }
            g(bx0.a(bx0VarF, bx0VarF2));
            bx0 bx0Var = this.b[4];
            if (bx0Var != null) {
                f(bx0Var);
            }
            bx0 bx0Var2 = this.b[5];
            if (bx0Var2 != null) {
                d(bx0Var2);
            }
            bx0 bx0Var3 = this.b[6];
            if (bx0Var3 != null) {
                h(bx0Var3);
            }
        }
    }

    public abstract C0383aw2 b();

    public void c(int i, bx0 bx0Var) {
        char c;
        if (this.b == null) {
            this.b = new bx0[9];
        }
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                bx0[] bx0VarArr = this.b;
                if (i2 != 1) {
                    c = 2;
                    if (i2 == 2) {
                        c = 1;
                    } else if (i2 != 4) {
                        c = '\b';
                        if (i2 == 8) {
                            c = 3;
                        } else if (i2 == 16) {
                            c = 4;
                        } else if (i2 == 32) {
                            c = 5;
                        } else if (i2 == 64) {
                            c = 6;
                        } else if (i2 == 128) {
                            c = 7;
                        } else if (i2 != 256) {
                            throw new IllegalArgumentException(AbstractC1214oR1.a(i2, "type needs to be >= FIRST and <= LAST, type="));
                        }
                    }
                } else {
                    c = 0;
                }
                bx0VarArr[c] = bx0Var;
            }
        }
    }

    public abstract void e(bx0 bx0Var);

    public abstract void g(bx0 bx0Var);

    public AbstractC0228Sv2(C0383aw2 c0383aw2) {
        this.a = c0383aw2;
    }

    public void d(bx0 bx0Var) {
    }

    public void f(bx0 bx0Var) {
    }

    public void h(bx0 bx0Var) {
    }
}
