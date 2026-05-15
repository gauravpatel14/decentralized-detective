package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UR1 {
    public static void a(Runnable runnable, RR1... rr1Arr) {
        Runnable runnable2;
        final TR1 tr1 = new TR1();
        int i = AbstractC1872zv.a;
        tr1.b = runnable;
        Callback callback = new Callback() { // from class: SR1
            @Override // org.chromium.base.Callback
            /* JADX INFO: renamed from: onResult */
            public final void a0(Object obj) {
                Runnable runnable3;
                TR1 tr12 = tr1;
                int i2 = AbstractC1872zv.a;
                int i3 = tr12.a - 1;
                tr12.a = i3;
                if (i3 == 0 && (runnable3 = tr12.b) != null) {
                    runnable3.run();
                    tr12.b = null;
                }
            }
        };
        int i2 = 0;
        for (RR1 rr1 : rr1Arr) {
            if (!rr1.o()) {
                i2++;
                if (rr1 instanceof F21) {
                    new C0331a51((F21) rr1, callback);
                } else if (rr1 instanceof d51) {
                    ((d51) rr1).p(callback);
                } else if (rr1 instanceof PT1) {
                    ((PT1) rr1).p(callback);
                }
            }
        }
        tr1.a = i2;
        if (i2 == 0 && (runnable2 = tr1.b) != null) {
            runnable2.run();
            tr1.b = null;
        }
    }
}
