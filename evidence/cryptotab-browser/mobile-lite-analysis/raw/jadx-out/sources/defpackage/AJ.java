package defpackage;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AJ extends AbstractC1302q {
    public final ReentrantLock e;
    public Object f;

    public AJ(InterfaceC0926jk0 interfaceC0926jk0) {
        super(interfaceC0926jk0);
        this.e = new ReentrantLock();
        this.f = r.a;
    }

    @Override // defpackage.P
    public final String b() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return "(value=" + this.f + ')';
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.P
    public final Object e(Object obj) {
        InterfaceC0926jk0 interfaceC0926jk0;
        InterfaceC0805hr1 interfaceC0805hr1F;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            C1433sG c1433sGC = c();
            if (c1433sGC != null) {
                return c1433sGC;
            }
            Object obj2 = this.f;
            eT1 et1 = r.a;
            if (obj2 == et1) {
                do {
                    interfaceC0805hr1F = f();
                    if (interfaceC0805hr1F != null) {
                        if (interfaceC0805hr1F instanceof C1433sG) {
                            return interfaceC0805hr1F;
                        }
                    }
                } while (interfaceC0805hr1F.b(obj) == null);
                reentrantLock.unlock();
                interfaceC0805hr1F.g();
                return interfaceC0805hr1F.e();
            }
            Object obj3 = this.f;
            UndeliveredElementException undeliveredElementExceptionA = null;
            if (obj3 != et1 && (interfaceC0926jk0 = this.b) != null) {
                undeliveredElementExceptionA = X41.a(interfaceC0926jk0, obj3, null);
            }
            this.f = obj;
            if (undeliveredElementExceptionA == null) {
                return r.b;
            }
            throw undeliveredElementExceptionA;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.AbstractC1302q
    public final boolean i(C1059m c1059m) {
        ReentrantLock reentrantLock = this.e;
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
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            return this.f == r.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.AbstractC1302q
    public final Object l() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            Object obj = this.f;
            eT1 et1 = r.a;
            if (obj != et1) {
                this.f = et1;
                return obj;
            }
            Object objC = c();
            if (objC == null) {
                objC = r.d;
            }
            return objC;
        } finally {
            reentrantLock.unlock();
        }
    }
}
