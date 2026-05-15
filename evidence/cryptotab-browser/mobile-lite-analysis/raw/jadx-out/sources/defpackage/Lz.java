package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Lz extends Mz {
    public final int i;
    public final C0978kf j;
    public int k;

    public Lz(Handler handler, Runnable runnable, String str, String str2, String str3) {
        super(handler, runnable, str, str2, str3, false);
        this.j = new C0978kf(0);
        this.i = 98;
    }

    @Override // defpackage.Mz
    public final C0619fA c(Context context, Bundle bundle, Iz iz) {
        C0619fA c0619fAF = f(context, bundle);
        if (c0619fAF == null) {
            return null;
        }
        this.j.add(c0619fAF);
        c0619fAF.k(this.g, iz);
        return c0619fAF;
    }

    @Override // defpackage.Mz
    public final void d(C0619fA c0619fA) {
        this.j.remove(c0619fA);
    }

    @Override // defpackage.Mz
    public final int e() {
        return -1;
    }

    public final C0619fA f(Context context, Bundle bundle) {
        if (this.j.v >= this.i) {
            Log.w("cr_ChildConnAllocator", "Ran out of UIDs to allocate.");
            return null;
        }
        String str = this.d;
        ComponentName componentName = new ComponentName(str, this.e);
        String str2 = this.f;
        ComponentName componentName2 = str2 != null ? new ComponentName(str, str2) : null;
        String string = Integer.toString(this.k);
        this.k++;
        this.h.getClass();
        return new C0619fA(context, componentName, componentName2, bundle, string);
    }
}
