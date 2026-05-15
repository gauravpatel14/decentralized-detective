package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gI extends RC0 implements InterfaceC0798hk0 {
    public final /* synthetic */ int u;
    public final /* synthetic */ iI v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gI(iI iIVar, int i) {
        super(0);
        this.u = i;
        this.v = iIVar;
    }

    @Override // defpackage.InterfaceC0798hk0
    public final Object c() {
        switch (this.u) {
            case 0:
                iI iIVar = this.v;
                return new wz1(iIVar.getApplication(), iIVar, iIVar.getIntent() != null ? iIVar.getIntent().getExtras() : null);
            case 1:
                this.v.reportFullyDrawn();
                return C0302Yj2.a;
            case 2:
                iI iIVar2 = this.v;
                return new C0731gk0(iIVar2.y, new gI(iIVar2, 1));
            default:
                final iI iIVar3 = this.v;
                final J41 j41 = new J41(new VH(1, iIVar3));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (lz0.a(Looper.myLooper(), Looper.getMainLooper())) {
                        iIVar3.getLifecycle().a(new ZH(iIVar3, j41));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: hI
                            @Override // java.lang.Runnable
                            public final void run() {
                                iI iIVar4 = iIVar3;
                                J41 j412 = j41;
                                int i = iI.M;
                                iIVar4.getLifecycle().a(new ZH(iIVar4, j412));
                            }
                        });
                    }
                }
                return j41;
        }
    }
}
