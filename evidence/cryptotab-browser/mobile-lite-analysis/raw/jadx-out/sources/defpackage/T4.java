package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class T4 {
    public final C0178Or1 d;
    public final Ai1 a = new Ai1(30);
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public int f = 0;
    public final i51 e = new i51(this);

    public T4(C0178Or1 c0178Or1) {
        this.d = c0178Or1;
    }

    public final boolean a(int i) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            S4 s4 = (S4) arrayList.get(i2);
            int i3 = s4.a;
            if (i3 == 8) {
                if (f(s4.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = s4.b;
                int i5 = s4.d + i4;
                while (i4 < i5) {
                    if (f(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public final void b() {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.d.d((S4) arrayList.get(i));
        }
        k(arrayList);
        this.f = 0;
    }

    public final void c() {
        b();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            S4 s4 = (S4) arrayList.get(i);
            int i2 = s4.a;
            C0178Or1 c0178Or1 = this.d;
            if (i2 == 1) {
                c0178Or1.d(s4);
                c0178Or1.g(s4.b, s4.d);
            } else if (i2 == 2) {
                c0178Or1.d(s4);
                int i3 = s4.b;
                int i4 = s4.d;
                RecyclerView recyclerView = c0178Or1.a;
                recyclerView.X(i3, true, i4);
                recyclerView.E0 = true;
                recyclerView.B0.c += i4;
            } else if (i2 == 4) {
                c0178Or1.d(s4);
                c0178Or1.f(s4.b, s4.d, s4.c);
            } else if (i2 == 8) {
                c0178Or1.d(s4);
                c0178Or1.h(s4.b, s4.d);
            }
        }
        k(arrayList);
        this.f = 0;
    }

    public final void d(S4 s4) {
        int i;
        Ai1 ai1;
        int i2 = s4.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iL = l(s4.b, i2);
        int i3 = s4.b;
        int i4 = s4.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + s4);
            }
            i = 1;
        }
        int i5 = 1;
        int i6 = 1;
        while (true) {
            int i7 = s4.d;
            ai1 = this.a;
            if (i5 >= i7) {
                break;
            }
            int iL2 = l((i * i5) + s4.b, s4.a);
            int i8 = s4.a;
            if (i8 == 2 ? iL2 != iL : !(i8 == 4 && iL2 == iL + 1)) {
                S4 s4H = h(i8, iL, i6, s4.c);
                e(s4H, i3);
                s4H.c = null;
                ai1.b(s4H);
                if (s4.a == 4) {
                    i3 += i6;
                }
                i6 = 1;
                iL = iL2;
            } else {
                i6++;
            }
            i5++;
        }
        Object obj = s4.c;
        s4.c = null;
        ai1.b(s4);
        if (i6 > 0) {
            S4 s4H2 = h(s4.a, iL, i6, obj);
            e(s4H2, i3);
            s4H2.c = null;
            ai1.b(s4H2);
        }
    }

    public final void e(S4 s4, int i) {
        C0178Or1 c0178Or1 = this.d;
        c0178Or1.d(s4);
        int i2 = s4.a;
        if (i2 != 2) {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            c0178Or1.f(i, s4.d, s4.c);
        } else {
            int i3 = s4.d;
            RecyclerView recyclerView = c0178Or1.a;
            recyclerView.X(i, true, i3);
            recyclerView.E0 = true;
            recyclerView.B0.c += i3;
        }
    }

    public final int f(int i, int i2) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        while (i2 < size) {
            S4 s4 = (S4) arrayList.get(i2);
            int i3 = s4.a;
            if (i3 == 8) {
                int i4 = s4.b;
                if (i4 == i) {
                    i = s4.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (s4.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = s4.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = s4.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += s4.d;
                }
            }
            i2++;
        }
        return i;
    }

    public final boolean g() {
        return this.b.size() > 0;
    }

    public final S4 h(int i, int i2, int i3, Object obj) {
        S4 s4 = (S4) this.a.a();
        if (s4 != null) {
            s4.a = i;
            s4.b = i2;
            s4.d = i3;
            s4.c = obj;
            return s4;
        }
        S4 s42 = new S4();
        s42.a = i;
        s42.b = i2;
        s42.d = i3;
        s42.c = obj;
        return s42;
    }

    public final void i(S4 s4) {
        this.c.add(s4);
        int i = s4.a;
        C0178Or1 c0178Or1 = this.d;
        if (i == 1) {
            c0178Or1.g(s4.b, s4.d);
            return;
        }
        if (i == 2) {
            int i2 = s4.b;
            int i3 = s4.d;
            RecyclerView recyclerView = c0178Or1.a;
            recyclerView.X(i2, false, i3);
            recyclerView.E0 = true;
            return;
        }
        if (i == 4) {
            c0178Or1.f(s4.b, s4.d, s4.c);
        } else if (i == 8) {
            c0178Or1.h(s4.b, s4.d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + s4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.T4.j():void");
    }

    public final void k(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            S4 s4 = (S4) arrayList.get(i);
            s4.c = null;
            this.a.b(s4);
        }
        arrayList.clear();
    }

    public final int l(int i, int i2) {
        int i3;
        int i4;
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            S4 s4 = (S4) arrayList.get(size);
            int i5 = s4.a;
            if (i5 == 8) {
                int i6 = s4.b;
                int i7 = s4.d;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            s4.b = i6 + 1;
                            s4.d = i7 + 1;
                        } else if (i2 == 2) {
                            s4.b = i6 - 1;
                            s4.d = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        s4.d = i7 + 1;
                    } else if (i2 == 2) {
                        s4.d = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        s4.b = i6 + 1;
                    } else if (i2 == 2) {
                        s4.b = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = s4.b;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= s4.d;
                    } else if (i5 == 2) {
                        i += s4.d;
                    }
                } else if (i2 == 1) {
                    s4.b = i8 + 1;
                } else if (i2 == 2) {
                    s4.b = i8 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            S4 s42 = (S4) arrayList.get(size2);
            int i9 = s42.a;
            Ai1 ai1 = this.a;
            if (i9 == 8) {
                int i10 = s42.d;
                if (i10 == s42.b || i10 < 0) {
                    arrayList.remove(size2);
                    s42.c = null;
                    ai1.b(s42);
                }
            } else if (s42.d <= 0) {
                arrayList.remove(size2);
                s42.c = null;
                ai1.b(s42);
            }
        }
        return i;
    }
}
