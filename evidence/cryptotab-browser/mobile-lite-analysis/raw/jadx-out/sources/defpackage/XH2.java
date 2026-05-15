package defpackage;

import com.google.android.gms.internal.measurement.zzd;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XH2 {
    public final SO2 a;
    public IQ2 b;
    public final C0944kC2 c;
    public final O33 d;

    public XH2() {
        SO2 so2 = new SO2();
        this.a = so2;
        this.b = so2.b.a();
        this.c = new C0944kC2();
        this.d = new O33();
        Callable callable = new Callable() { // from class: yB2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new X23(this.a.d);
            }
        };
        C0416bV2 c0416bV2 = so2.d;
        c0416bV2.a.put("internal.registerCallback", callable);
        c0416bV2.a.put("internal.eventLogger", new Callable() { // from class: vF2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new C0588eW2(this.a.c);
            }
        });
    }

    public final void a(OR2 or2) {
        AbstractC1823zD2 abstractC1823zD2;
        SO2 so2 = this.a;
        try {
            this.b = so2.b.a();
            if (so2.a(this.b, (eS2[]) or2.m().toArray(new eS2[0])) instanceof C0823iD2) {
                throw new IllegalStateException("Program loading failed");
            }
            for (JR2 jr2 : or2.l().n()) {
                LW2 lw2M = jr2.m();
                String strL = jr2.l();
                Iterator it = lw2M.iterator();
                while (it.hasNext()) {
                    InterfaceC1601vE2 interfaceC1601vE2A = so2.a(this.b, (eS2) it.next());
                    if (!(interfaceC1601vE2A instanceof C0394bE2)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    IQ2 iq2 = this.b;
                    if (iq2.g(strL)) {
                        InterfaceC1601vE2 interfaceC1601vE2D = iq2.d(strL);
                        if (!(interfaceC1601vE2D instanceof AbstractC1823zD2)) {
                            throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(strL)));
                        }
                        abstractC1823zD2 = (AbstractC1823zD2) interfaceC1601vE2D;
                    } else {
                        abstractC1823zD2 = null;
                    }
                    if (abstractC1823zD2 == null) {
                        throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(strL)));
                    }
                    abstractC1823zD2.a(this.b, Collections.singletonList(interfaceC1601vE2A));
                }
            }
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean b(XB2 xb2) throws zzd {
        C0944kC2 c0944kC2 = this.c;
        try {
            c0944kC2.a = xb2;
            c0944kC2.b = xb2.clone();
            c0944kC2.c.clear();
            this.a.c.f("runtime.counter", new C1369rD2(Double.valueOf(0.0d)));
            this.d.a(this.b.a(), c0944kC2);
            if (c0944kC2.b.equals(c0944kC2.a)) {
                return !c0944kC2.c.isEmpty();
            }
            return true;
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }
}
