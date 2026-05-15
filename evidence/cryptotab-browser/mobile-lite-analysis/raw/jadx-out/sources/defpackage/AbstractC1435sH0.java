package defpackage;

/* JADX INFO: renamed from: sH0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1435sH0 {
    public final K21 t;
    public boolean u;
    public int v = -1;
    public final /* synthetic */ AbstractC1493tH0 w;

    public AbstractC1435sH0(AbstractC1493tH0 abstractC1493tH0, K21 k21) {
        this.w = abstractC1493tH0;
        this.t = k21;
    }

    public final void d(boolean z) {
        if (z == this.u) {
            return;
        }
        this.u = z;
        int i = z ? 1 : -1;
        AbstractC1493tH0 abstractC1493tH0 = this.w;
        int i2 = abstractC1493tH0.c;
        abstractC1493tH0.c = i + i2;
        if (!abstractC1493tH0.d) {
            abstractC1493tH0.d = true;
            while (true) {
                try {
                    int i3 = abstractC1493tH0.c;
                    if (i2 == i3) {
                        break;
                    }
                    boolean z2 = i2 == 0 && i3 > 0;
                    boolean z3 = i2 > 0 && i3 == 0;
                    if (z2) {
                        abstractC1493tH0.e();
                    } else if (z3) {
                        abstractC1493tH0.f();
                    }
                    i2 = i3;
                } catch (Throwable th) {
                    abstractC1493tH0.d = false;
                    throw th;
                }
            }
            abstractC1493tH0.d = false;
        }
        if (this.u) {
            abstractC1493tH0.c(this);
        }
    }

    public boolean f(InterfaceC0762hF0 interfaceC0762hF0) {
        return false;
    }

    public abstract boolean g();

    public void e() {
    }
}
