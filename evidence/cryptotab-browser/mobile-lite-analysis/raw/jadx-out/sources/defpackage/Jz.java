package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jz extends Mz {
    public final /* synthetic */ int i = 0;
    public final Object j;
    public final Object k;

    public Jz(Handler handler, Runnable runnable, String str, String str2, boolean z, int i) {
        super(handler, runnable, str, str2, null, z);
        this.j = new C0619fA[i];
        this.k = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            ((ArrayList) this.k).add(Integer.valueOf(i2));
        }
    }

    @Override // defpackage.Mz
    public final C0619fA c(Context context, Bundle bundle, Iz iz) {
        Object obj = this.j;
        C0619fA c0619fA = null;
        Object obj2 = this.k;
        switch (this.i) {
            case 0:
                Lz lz = (Lz) obj;
                C0619fA c0619fAF = lz.f(context, bundle);
                if (c0619fAF != null) {
                    boolean z = lz.g;
                    try {
                        TraceEvent.a("ChildProcessConnection.tryStart", null);
                        if (c0619fAF.c(z)) {
                            c0619fAF.f = iz;
                            TraceEvent.b("ChildProcessConnection.tryStart");
                            lz.j.add(c0619fAF);
                            c0619fA = c0619fAF;
                        }
                    } finally {
                        TraceEvent.b("ChildProcessConnection.tryStart");
                    }
                }
                return c0619fA != null ? c0619fA : ((Lz) obj2).c(context, bundle, iz);
            default:
                ArrayList arrayList = (ArrayList) obj2;
                if (arrayList.isEmpty()) {
                    Log.w("cr_ChildConnAllocator", "Ran out of services to allocate.");
                    return null;
                }
                int iIntValue = ((Integer) arrayList.remove(0)).intValue();
                ComponentName componentName = new ComponentName(this.d, this.e + iIntValue);
                this.h.getClass();
                C0619fA c0619fA2 = new C0619fA(context, componentName, null, bundle, null);
                ((C0619fA[]) obj)[iIntValue] = c0619fA2;
                int i = AbstractC1872zv.a;
                c0619fA2.k(this.g, iz);
                return c0619fA2;
        }
    }

    @Override // defpackage.Mz
    public final void d(C0619fA c0619fA) {
        Object obj = this.k;
        Object obj2 = this.j;
        switch (this.i) {
            case 0:
                Lz lz = (Lz) obj2;
                if (!lz.j.contains(c0619fA)) {
                    Lz lz2 = (Lz) obj;
                    if (lz2.j.contains(c0619fA)) {
                        lz2.d(c0619fA);
                    }
                } else {
                    lz.d(c0619fA);
                }
                break;
            default:
                C0619fA[] c0619fAArr = (C0619fA[]) obj2;
                int iIndexOf = Arrays.asList(c0619fAArr).indexOf(c0619fA);
                if (iIndexOf != -1) {
                    c0619fAArr[iIndexOf] = null;
                    ((ArrayList) obj).add(Integer.valueOf(iIndexOf));
                    int i = AbstractC1872zv.a;
                } else {
                    Log.e("cr_ChildConnAllocator", "Unable to find connection to free.");
                }
                break;
        }
    }

    @Override // defpackage.Mz
    public final int e() {
        switch (this.i) {
            case 0:
                return -1;
            default:
                return ((C0619fA[]) this.j).length;
        }
    }

    public Jz(Handler handler, Runnable runnable, String str) {
        super(handler, runnable, str, "org.chromium.content.app.SandboxedProcessService", null, false);
        this.j = new Lz(handler, runnable, str, "org.chromium.content.app.SandboxedProcessService0", null);
        this.k = new Lz(handler, runnable, str, "org.chromium.content.app.SandboxedProcessService1", null);
    }
}
