package defpackage;

import com.google.android.gms.internal.measurement.zzkm;
import java.io.IOException;

/* JADX INFO: renamed from: aW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0360aW2 implements Cloneable {
    public final AbstractC1852zW2 t;
    public AbstractC1852zW2 u;
    public boolean v = false;

    public AbstractC0360aW2(AbstractC1852zW2 abstractC1852zW2) {
        this.t = abstractC1852zW2;
        this.u = (AbstractC1852zW2) abstractC1852zW2.k(4);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AbstractC0360aW2 clone() {
        AbstractC0360aW2 abstractC0360aW2 = (AbstractC0360aW2) this.t.k(5);
        abstractC0360aW2.b(e());
        return abstractC0360aW2;
    }

    public final void b(AbstractC1852zW2 abstractC1852zW2) {
        if (this.v) {
            f();
            this.v = false;
        }
        AbstractC1852zW2 abstractC1852zW22 = this.u;
        C0482cY2.c.a(abstractC1852zW22.getClass()).h(abstractC1852zW22, abstractC1852zW2);
    }

    public final void c(byte[] bArr, int i, KV2 kv2) throws zzkm {
        if (this.v) {
            f();
            this.v = false;
        }
        try {
            InterfaceC0784hY2 interfaceC0784hY2A = C0482cY2.c.a(this.u.getClass());
            AbstractC1852zW2 abstractC1852zW2 = this.u;
            HU2 hu2 = new HU2();
            kv2.getClass();
            interfaceC0784hY2A.i(abstractC1852zW2, bArr, 0, i, hu2);
        } catch (zzkm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzkm.d();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
    
        if (r1 != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.AbstractC1852zW2 d() {
        /*
            r3 = this;
            zW2 r0 = r3.e()
            r1 = 1
            java.lang.Object r2 = r0.k(r1)
            java.lang.Byte r2 = (java.lang.Byte) r2
            byte r2 = r2.byteValue()
            if (r2 != r1) goto L12
            goto L28
        L12:
            if (r2 == 0) goto L29
            cY2 r1 = defpackage.C0482cY2.c
            java.lang.Class r2 = r0.getClass()
            hY2 r1 = r1.a(r2)
            boolean r1 = r1.d(r0)
            r2 = 2
            r0.k(r2)
            if (r1 == 0) goto L29
        L28:
            return r0
        L29:
            com.google.android.gms.internal.measurement.zzmk r0 = new com.google.android.gms.internal.measurement.zzmk
            java.lang.String r1 = "Message was missing required fields.  (Lite runtime could not determine which fields were missing)."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC0360aW2.d():zW2");
    }

    public final AbstractC1852zW2 e() {
        if (this.v) {
            return this.u;
        }
        AbstractC1852zW2 abstractC1852zW2 = this.u;
        C0482cY2.c.a(abstractC1852zW2.getClass()).b(abstractC1852zW2);
        this.v = true;
        return this.u;
    }

    public final void f() {
        AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) this.u.k(4);
        C0482cY2.c.a(abstractC1852zW2.getClass()).h(abstractC1852zW2, this.u);
        this.u = abstractC1852zW2;
    }
}
