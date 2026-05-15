package defpackage;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ve extends AbstractC1302q {
    public final int e;
    public final int f;
    public final ReentrantLock g;
    public Object[] h;
    public int i;
    private volatile /* synthetic */ int size;

    public Ve(int i, int i2, InterfaceC0926jk0 interfaceC0926jk0) {
        super(interfaceC0926jk0);
        this.e = i;
        this.f = i2;
        if (i < 1) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.g = new ReentrantLock();
        int iMin = Math.min(i, 8);
        Object[] objArr = new Object[iMin];
        Arrays.fill(objArr, 0, iMin, r.a);
        this.h = objArr;
        this.size = 0;
    }

    @Override // defpackage.P
    public final String b() {
        return "(buffer:capacity=" + this.e + ",size=" + this.size + ')';
    }

    @Override // defpackage.P
    public final Object e(Object obj) {
        InterfaceC0805hr1 interfaceC0805hr1F;
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            int i = this.size;
            C1433sG c1433sGC = c();
            if (c1433sGC != null) {
                return c1433sGC;
            }
            int i2 = this.e;
            eT1 et1 = r.b;
            eT1 et12 = null;
            if (i < i2) {
                this.size = i + 1;
            } else {
                int iB = aM1.b(this.f);
                if (iB == 0) {
                    et12 = r.c;
                } else if (iB != 1) {
                    if (iB != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    et12 = et1;
                }
            }
            if (et12 != null) {
                return et12;
            }
            if (i == 0) {
                do {
                    interfaceC0805hr1F = f();
                    if (interfaceC0805hr1F != null) {
                        if (interfaceC0805hr1F instanceof C1433sG) {
                            this.size = i;
                            return interfaceC0805hr1F;
                        }
                    }
                } while (interfaceC0805hr1F.b(obj) == null);
                this.size = i;
                reentrantLock.unlock();
                interfaceC0805hr1F.g();
                return interfaceC0805hr1F.e();
            }
            m(i, obj);
            return et1;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.AbstractC1302q
    public final boolean i(C1059m c1059m) {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            return super.i(c1059m);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.AbstractC1302q
    public final boolean j() {
        return false;
    }

    @Override // defpackage.AbstractC1302q
    public final boolean k() {
        return this.size == 0;
    }

    @Override // defpackage.AbstractC1302q
    public final Object l() {
        xE1 xe1G;
        Object objW;
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            int i = this.size;
            Object obj = r.d;
            if (i == 0) {
                C1433sG c1433sGC = c();
                if (c1433sGC != null) {
                    obj = c1433sGC;
                }
                return obj;
            }
            Object[] objArr = this.h;
            int i2 = this.i;
            Object obj2 = objArr[i2];
            objArr[i2] = null;
            this.size = i - 1;
            boolean z = false;
            if (i != this.e || (xe1G = g()) == null) {
                xe1G = null;
                objW = obj;
            } else {
                objW = xe1G.w();
                z = true;
            }
            if (objW != obj && !(objW instanceof C1433sG)) {
                this.size = i;
                Object[] objArr2 = this.h;
                objArr2[(this.i + i) % objArr2.length] = objW;
            }
            this.i = (this.i + 1) % this.h.length;
            if (z) {
                xe1G.getClass();
            }
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void m(int i, Object obj) {
        int i2 = this.e;
        if (i >= i2) {
            Object[] objArr = this.h;
            int i3 = this.i;
            objArr[i3 % objArr.length] = null;
            objArr[(i + i3) % objArr.length] = obj;
            this.i = (i3 + 1) % objArr.length;
            return;
        }
        Object[] objArr2 = this.h;
        if (i >= objArr2.length) {
            int iMin = Math.min(objArr2.length * 2, i2);
            Object[] objArr3 = new Object[iMin];
            for (int i4 = 0; i4 < i; i4++) {
                Object[] objArr4 = this.h;
                objArr3[i4] = objArr4[(this.i + i4) % objArr4.length];
            }
            Arrays.fill(objArr3, i, iMin, r.a);
            this.h = objArr3;
            this.i = 0;
        }
        Object[] objArr5 = this.h;
        objArr5[(this.i + i) % objArr5.length] = obj;
    }
}
