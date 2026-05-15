package org.chromium.ui.base;

import J.N;
import android.R;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.UiModeManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.AttachedSurfaceControl;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import defpackage.AbstractC0911ja;
import defpackage.AbstractC1440sM;
import defpackage.AbstractC1499tM;
import defpackage.AbstractC1872zv;
import defpackage.C0323Zw0;
import defpackage.C0589eX;
import defpackage.C0808hv2;
import defpackage.C0865ik2;
import defpackage.C0927jk2;
import defpackage.C1114mv2;
import defpackage.C1760xy0;
import defpackage.GC0;
import defpackage.InterfaceC0932jv2;
import defpackage.InterfaceC1055lv2;
import defpackage.InterfaceC1175nv2;
import defpackage.L21;
import defpackage.L8;
import defpackage.Lt0;
import defpackage.M21;
import defpackage.M8;
import defpackage.Q3;
import defpackage.Zd;
import defpackage.bU0;
import defpackage.n00;
import defpackage.n61;
import defpackage.o00;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.chromium.ui.permissions.AndroidPermissionDelegate;
import org.chromium.ui.permissions.PermissionCallback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class WindowAndroid implements AndroidPermissionDelegate, n00 {
    public static final Lt0 P = new Lt0(null);
    public final HashSet A;
    public View B;
    public final Zd C;
    public Q3 D;
    public ArrayList E;
    public final C0865ik2 F;
    public float G;
    public boolean H;
    public final n61 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public InterfaceC1055lv2 f33J;
    public final M21 K;
    public boolean L;
    public final M21 M;
    public final boolean N;
    public final M21 O;
    public C1760xy0 t;
    public GC0 u;
    public C0323Zw0 v;
    public long w;
    public final o00 x;
    public boolean y;
    public final Lt0 z;

    public WindowAndroid(Context context) {
        this(context, o00.a(context));
    }

    public static long createForTesting() {
        return new WindowAndroid(AbstractC1499tM.a).getNativePointer();
    }

    private long getNativePointer() {
        Window windowQ;
        if (this.w == 0) {
            int i = this.x.b;
            TypedValue typedValue = new TypedValue();
            Context context = (Context) this.z.get();
            long j_J_ZFIO = N._J_ZFIO(0, (Build.VERSION.SDK_INT >= 29 && (windowQ = q()) != null) ? windowQ.isWideColorGamut() : false, (context == null || !context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) ? 0.0f : typedValue.getDimension(context.getResources().getDisplayMetrics()), i, this);
            this.w = j_J_ZFIO;
            N._V_ZJO(34, false, j_J_ZFIO, this);
        }
        return this.w;
    }

    @Override // defpackage.n00
    public final void b() {
        s();
    }

    @Override // org.chromium.ui.permissions.AndroidPermissionDelegate
    public boolean canRequestPermission(String str) {
        Q3 q3 = this.D;
        if (q3 != null) {
            return q3.canRequestPermission(str);
        }
        Log.w("cr_WindowAndroid", "Cannot determine the request permission state as the context is not an Activity");
        return false;
    }

    public final void clearNativePointer() {
        this.w = 0L;
    }

    @Override // defpackage.n00
    public final void d(float f) {
        long j = this.w;
        if (j != 0) {
            N._V_FJO(2, f, j, this);
        }
    }

    public void destroy() {
        n61 n61Var;
        Window window;
        AttachedSurfaceControl rootSurfaceControl;
        Window window2;
        int i = AbstractC1872zv.a;
        this.y = true;
        this.x.a.remove(this);
        long j = this.w;
        if (j != 0) {
            N._V_JO(283, j, this);
        }
        C0865ik2 c0865ik2 = this.F;
        c0865ik2.getClass();
        C0589eX c0589eX = c0865ik2.a;
        if (!c0589eX.t) {
            Iterator it = new HashSet(c0865ik2.c.keySet()).iterator();
            while (it.hasNext()) {
                ((C0927jk2) it.next()).c(c0865ik2);
            }
            c0865ik2.c = null;
            c0865ik2.b = null;
            c0589eX.t = true;
        }
        this.C.destroy();
        if (Build.VERSION.SDK_INT < 32 || (n61Var = this.I) == null) {
            return;
        }
        if (n61Var.d && (window2 = (Window) n61Var.b.get()) != null) {
            window2.removeOnFrameMetricsAvailableListener(n61Var);
            n61Var.d = false;
        }
        if (!n61Var.c || (window = (Window) n61Var.b.get()) == null || (rootSurfaceControl = window.getRootSurfaceControl()) == null) {
            return;
        }
        rootSurfaceControl.removeOnBufferTransformHintChangedListener(n61Var);
        n61Var.c = false;
    }

    public final int getOverlayTransform() {
        n61 n61Var;
        Window window;
        AttachedSurfaceControl rootSurfaceControl;
        int i = 0;
        if (Build.VERSION.SDK_INT >= 32 && (n61Var = this.I) != null && (window = (Window) n61Var.b.get()) != null && (rootSurfaceControl = window.getRootSurfaceControl()) != null) {
            try {
                int bufferTransformHint = rootSurfaceControl.getBufferTransformHint();
                if (bufferTransformHint == 0) {
                    i = 1;
                } else if (bufferTransformHint == 1) {
                    i = 2;
                } else if (bufferTransformHint == 2) {
                    i = 3;
                } else if (bufferTransformHint == 3) {
                    i = 5;
                } else if (bufferTransformHint == 4) {
                    i = 4;
                } else if (bufferTransformHint == 7) {
                    i = 6;
                }
            } catch (IllegalStateException | NullPointerException unused) {
            }
        }
        if (i != 0) {
            return i;
        }
        int i2 = this.x.i;
        if (i2 == 1) {
            return 4;
        }
        if (i2 != 2) {
            return i2 != 3 ? 1 : 6;
        }
        return 5;
    }

    public final int[] getProgressBarConfig() {
        int[] iArr = new int[5];
        InterfaceC1055lv2 interfaceC1055lv2 = this.f33J;
        if (interfaceC1055lv2 == null) {
            Arrays.fill(iArr, 0);
            return iArr;
        }
        C1114mv2 c1114mv2A = interfaceC1055lv2.a();
        iArr[0] = c1114mv2A.a;
        iArr[1] = c1114mv2A.b;
        iArr[2] = c1114mv2A.c;
        iArr[3] = c1114mv2A.d;
        iArr[4] = c1114mv2A.e;
        return iArr;
    }

    public final float getRefreshRate() {
        return this.x.j;
    }

    @SuppressLint({"NewApi"})
    public final float[] getSupportedRefreshRates() {
        ArrayList arrayList = this.E;
        if (arrayList == null || !this.N) {
            return null;
        }
        float[] fArr = new float[arrayList.size()];
        for (int i = 0; i < this.E.size(); i++) {
            fArr[i] = ((Display.Mode) this.E.get(i)).getRefreshRate();
        }
        return fArr;
    }

    public final void h(float f) {
        if (this.E == null || !this.N) {
            return;
        }
        int modeId = 0;
        if (f != 0.0f) {
            Display.Mode mode = null;
            float f2 = Float.MAX_VALUE;
            for (int i = 0; i < this.E.size(); i++) {
                Display.Mode mode2 = (Display.Mode) this.E.get(i);
                float fAbs = Math.abs(f - mode2.getRefreshRate());
                if (fAbs < f2) {
                    mode = mode2;
                    f2 = fAbs;
                }
            }
            if (f2 > 2.0f) {
                Log.e("cr_WindowAndroid", "Refresh rate not supported : " + f);
            } else {
                modeId = mode.getModeId();
            }
        }
        Window windowQ = q();
        if (windowQ == null) {
            return;
        }
        WindowManager.LayoutParams attributes = windowQ.getAttributes();
        if (attributes.preferredDisplayModeId == modeId) {
            return;
        }
        attributes.preferredDisplayModeId = modeId;
        windowQ.setAttributes(attributes);
    }

    @Override // org.chromium.ui.permissions.AndroidPermissionDelegate
    public boolean hasPermission(String str) {
        Q3 q3 = this.D;
        return q3 != null ? q3.hasPermission(str) : AbstractC0911ja.a(AbstractC1499tM.a, Process.myPid(), Process.myUid(), str) == 0;
    }

    public Lt0 j() {
        return P;
    }

    public int k() {
        return 6;
    }

    public final C0323Zw0 l() {
        if (this.v == null) {
            Window windowQ = q();
            if (windowQ == null) {
                return null;
            }
            this.v = new C0323Zw0(new Lt0(windowQ.getDecorView().getRootView()));
        }
        return this.v;
    }

    @Override // defpackage.n00
    public final void m() {
        s();
    }

    public GC0 n() {
        return this.u;
    }

    public bU0 o() {
        return null;
    }

    public final void onSelectionHandlesStateChanged(boolean z) {
        this.L = z;
        Iterator it = this.M.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((InterfaceC1175nv2) l21.next()).a(z);
            }
        }
    }

    public View p() {
        return null;
    }

    public final Window q() {
        Activity activityA = AbstractC1499tM.a((Context) this.z.get());
        if (activityA == null || activityA.isFinishing()) {
            return null;
        }
        return activityA.getWindow();
    }

    public final boolean r(String str) {
        Q3 q3 = this.D;
        if (q3 != null) {
            return q3.b(str);
        }
        Log.w("cr_WindowAndroid", "Cannot determine the policy permission state as the context is not an Activity");
        return false;
    }

    public final void s() {
        o00 o00Var = this.x;
        Display.Mode mode = o00Var.k;
        List list = o00Var.l;
        if (mode == null || list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (mode.equals(list.get(i))) {
                arrayList.add((Display.Mode) list.get(i));
            } else if (mode.getPhysicalWidth() == ((Display.Mode) list.get(i)).getPhysicalWidth() && mode.getPhysicalHeight() == ((Display.Mode) list.get(i)).getPhysicalHeight() && mode.getRefreshRate() != ((Display.Mode) list.get(i)).getRefreshRate()) {
                arrayList.add((Display.Mode) list.get(i));
            }
        }
        if (arrayList.equals(this.E)) {
            return;
        }
        this.E = arrayList;
        long j = this.w;
        if (j != 0) {
            N._V_JOO(116, j, this, getSupportedRefreshRates());
        }
    }

    @SuppressLint({"NewApi"})
    public final void setPreferredRefreshRate(float f) {
        this.G = f;
        if (this.H) {
            h(f);
        }
    }

    public void setWideColorEnabled(boolean z) {
        Window windowQ;
        if (Build.VERSION.SDK_INT >= 29 && (windowQ = q()) != null) {
            windowQ.setColorMode(z ? 1 : 0);
        }
    }

    public final void t(String[] strArr, PermissionCallback permissionCallback) {
        Q3 q3 = this.D;
        if (q3 == null) {
            Log.w("cr_WindowAndroid", "Cannot request permissions as the context is not an Activity");
            return;
        }
        int i = q3.v;
        int i2 = i + 1000;
        q3.v = (i + 1) % 100;
        SparseArray sparseArray = q3.u;
        sparseArray.put(i2, new M8(q3, strArr, permissionCallback));
        Activity activity = (Activity) q3.w.get();
        if (activity == null) {
            sparseArray.delete(i2);
            q3.t.post(new L8(q3, strArr, permissionCallback));
            return;
        }
        activity.requestPermissions(strArr, i2);
        for (String str : strArr) {
            if (TextUtils.equals(str, "android.permission.POST_NOTIFICATIONS")) {
                AbstractC1440sM.a.edit().putLong("AndroidPermissionRequestTimestamp::android.permission.POST_NOTIFICATIONS", System.currentTimeMillis()).apply();
                return;
            }
        }
    }

    public final boolean u(Intent intent, InterfaceC0932jv2 interfaceC0932jv2, Integer num) {
        C1760xy0 c1760xy0 = this.t;
        if (c1760xy0 == null) {
            Objects.toString(intent);
            int i = AbstractC1872zv.a;
            return false;
        }
        int i2 = c1760xy0.b;
        int i3 = i2 + 1000;
        c1760xy0.b = (i2 + 1) % 100;
        Activity activity = (Activity) c1760xy0.c.a.get();
        if (activity == null) {
            i3 = -1;
        } else {
            try {
                activity.startActivityForResult(intent, i3);
                c1760xy0.a.put(i3, interfaceC0932jv2);
                c1760xy0.d.put(Integer.valueOf(i3), num == null ? null : AbstractC1499tM.a.getString(num.intValue()));
            } catch (ActivityNotFoundException unused) {
                i3 = -1;
            }
        }
        return i3 >= 0;
    }

    public final void v(Animator animator) {
        if (this.B == null) {
            return;
        }
        if (animator.isStarted()) {
            throw new IllegalArgumentException("Already started.");
        }
        if (!this.A.add(animator)) {
            throw new IllegalArgumentException("Already Added.");
        }
        animator.start();
        if (this.B.willNotDraw()) {
            this.B.setWillNotDraw(false);
        }
        animator.addListener(new C0808hv2(this));
    }

    public WindowAndroid(Context context, o00 o00Var) {
        int i;
        n61 n61Var;
        UiModeManager uiModeManager;
        this.u = GC0.u;
        this.A = new HashSet();
        this.C = new Zd();
        this.F = new C0865ik2();
        boolean z = true;
        this.H = true;
        this.K = new M21();
        this.M = new M21();
        this.O = new M21();
        int i2 = AbstractC1872zv.a;
        this.z = new Lt0(context);
        this.x = o00Var;
        o00Var.a.put(this, null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29 || ((uiModeManager = (UiModeManager) context.getSystemService("uimode")) != null && uiModeManager.getCurrentModeType() == 4)) {
            z = false;
        }
        this.N = z;
        s();
        if (Build.VERSION.RELEASE.equals("8.0.0") || AbstractC1499tM.a(context) == null) {
            i = i3;
            n61Var = null;
        } else {
            i = i3;
            n61Var = null;
            o00Var.c(null, null, null, null, null, null, null, null, Boolean.valueOf(context.getResources().getConfiguration().isScreenWideColorGamut()), null, null, null, null, null);
        }
        if (i >= 32) {
            this.I = q() == null ? n61Var : new n61(this);
        }
    }
}
