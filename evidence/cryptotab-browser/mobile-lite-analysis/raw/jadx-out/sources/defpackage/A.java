package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class A implements InterfaceC1787yS0 {
    public int a;

    public final int a(Cz1 cz1) {
        AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) this;
        int i = abstractC0003Al0.c;
        if (i != -1) {
            return i;
        }
        int iH = cz1.h(this);
        abstractC0003Al0.c = iH;
        return iH;
    }

    public final String b(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public final byte[] c() {
        try {
            AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) this;
            int iH = abstractC0003Al0.h();
            byte[] bArr = new byte[iH];
            boolean z = CG.b;
            AG ag = new AG(iH, bArr);
            abstractC0003Al0.p(ag);
            if (ag.T() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(b("byte array"), e);
        }
    }

    public final C0199Qv d() {
        try {
            AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) this;
            int iH = abstractC0003Al0.h();
            C0199Qv c0199Qv = C0199Qv.v;
            byte[] bArr = new byte[iH];
            boolean z = CG.b;
            AG ag = new AG(iH, bArr);
            abstractC0003Al0.p(ag);
            if (ag.T() == 0) {
                return new C0199Qv(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(b("ByteString"), e);
        }
    }
}
