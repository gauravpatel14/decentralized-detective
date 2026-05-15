package org.chromium.content.app;

import J.N;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import defpackage.AbstractC1499tM;
import defpackage.Ar0;
import defpackage.Br0;
import defpackage.C1869zr0;
import defpackage.OE0;
import java.util.List;
import org.chromium.base.UnguessableToken;
import org.chromium.content.common.SurfaceWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ContentChildProcessServiceDelegate {
    public IBinder a;
    public Br0 b;
    public int c;
    public long d;
    public SparseArray e;

    public final void a(Context context) {
        boolean z;
        OE0 oe0 = OE0.h;
        synchronized (oe0.e) {
            z = oe0.f;
        }
        if (z) {
            OE0 oe02 = OE0.h;
            synchronized (oe02.e) {
                oe02.c();
            }
            N._V_O(48, this);
            return;
        }
        oe0.d.b();
        synchronized (oe0.e) {
            try {
                if (oe0.b != 0 && context != AbstractC1499tM.a) {
                    throw new IllegalStateException("Attempt to load again from alternate context.");
                }
                oe0.e(context.getApplicationInfo(), false);
            } catch (Throwable th) {
                throw th;
            }
        }
        oe0.b = 2;
        OE0 oe03 = OE0.h;
        synchronized (oe03.e) {
            oe03.c();
        }
        N._V_O(48, this);
    }

    public final void b(Bundle bundle, List list, IBinder iBinder) {
        this.a = iBinder;
        Br0 br0 = null;
        br0 = null;
        br0 = null;
        if (list != null && !list.isEmpty()) {
            IBinder iBinder2 = (IBinder) list.get(0);
            int i = Ar0.t;
            if (iBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("org.chromium.content.common.IGpuProcessCallback");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof Br0)) {
                    C1869zr0 c1869zr0 = new C1869zr0();
                    c1869zr0.t = iBinder2;
                    br0 = c1869zr0;
                } else {
                    br0 = (Br0) iInterfaceQueryLocalInterface;
                }
            }
        }
        this.b = br0;
        this.c = bundle.getInt("com.google.android.apps.chrome.extra.cpu_count");
        this.d = bundle.getLong("com.google.android.apps.chrome.extra.cpu_features");
        OE0.h.d.d(bundle);
    }

    public final void forwardSurfaceForSurfaceRequest(UnguessableToken unguessableToken, Surface surface) {
        Br0 br0 = this.b;
        try {
            if (br0 == null) {
                Log.e("cr_ContentCPSDelegate", "No callback interface has been provided.");
            } else {
                br0.P(unguessableToken, surface);
            }
        } catch (RemoteException e) {
            Log.e("cr_ContentCPSDelegate", "Unable to call forwardSurfaceForSurfaceRequest: %s", e);
        } finally {
            surface.release();
        }
    }

    public final SurfaceWrapper getViewSurface(int i) {
        Br0 br0 = this.b;
        if (br0 == null) {
            Log.e("cr_ContentCPSDelegate", "No callback interface has been provided.");
            return null;
        }
        try {
            return br0.e0(i);
        } catch (RemoteException e) {
            Log.e("cr_ContentCPSDelegate", "Unable to call getViewSurface: %s", e);
            return null;
        }
    }

    public final void setFileDescriptorsIdsToKeys(int[] iArr, String[] strArr) {
        this.e = new SparseArray();
        for (int i = 0; i < iArr.length; i++) {
            this.e.put(iArr[i], strArr[i]);
        }
    }
}
