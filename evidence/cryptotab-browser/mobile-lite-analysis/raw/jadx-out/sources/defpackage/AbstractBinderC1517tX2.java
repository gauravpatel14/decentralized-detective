package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: tX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1517tX2 extends AbstractBinderC1095mV2 {
    public static final WeakReference v = new WeakReference(null);
    public WeakReference u;

    public AbstractBinderC1517tX2(byte[] bArr) {
        super(bArr);
        this.u = v;
    }

    @Override // defpackage.AbstractBinderC1095mV2
    public final byte[] X0() {
        byte[] bArrY0;
        synchronized (this) {
            try {
                bArrY0 = (byte[]) this.u.get();
                if (bArrY0 == null) {
                    bArrY0 = Y0();
                    this.u = new WeakReference(bArrY0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrY0;
    }

    public abstract byte[] Y0();
}
