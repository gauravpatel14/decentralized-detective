package org.chromium.ui.resources;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.SparseArray;
import defpackage.AO1;
import defpackage.BO1;
import defpackage.C1620vU1;
import defpackage.C1677wU1;
import defpackage.bv1;
import defpackage.e50;
import org.chromium.ui.base.WindowAndroid;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ResourceManager {
    public final SparseArray a;
    public final SparseArray b;
    public final float c;
    public long d;

    public ResourceManager(Resources resources, int i, long j) {
        SparseArray sparseArray = new SparseArray();
        this.a = sparseArray;
        this.b = new SparseArray();
        this.c = 1.0f / resources.getDisplayMetrics().density;
        sparseArray.put(0, new BO1(0, this, new AO1(resources)));
        sparseArray.put(1, new e50(1, this));
        sparseArray.put(2, new e50(2, this));
        sparseArray.put(3, new C1677wU1(3, this, new C1620vU1(i)));
        this.d = j;
    }

    public static ResourceManager create(WindowAndroid windowAndroid, long j) {
        Context context = (Context) windowAndroid.z.get();
        if (context == null) {
            throw new IllegalStateException("Context should not be null during initialization.");
        }
        Point point = windowAndroid.x.c;
        return new ResourceManager(context.getResources(), Math.min(point.x, point.y), j);
    }

    public final e50 a() {
        return (e50) this.a.get(1);
    }

    public final void b(int i, int[] iArr, int[] iArr2) {
        bv1 bv1Var = (bv1) this.a.get(i);
        for (int i2 : iArr2) {
            bv1Var.c(i2);
        }
        for (int i3 : iArr) {
            bv1Var.a(i3);
        }
    }

    public final void destroy() {
        this.d = 0L;
    }

    public final long getNativePtr() {
        return this.d;
    }

    public final void preloadResource(int i, int i2) {
        bv1 bv1Var = (bv1) this.a.get(i);
        if (bv1Var != null) {
            bv1Var.c(i2);
        }
    }

    public final void resourceRequested(int i, int i2) {
        bv1 bv1Var = (bv1) this.a.get(i);
        if (bv1Var != null) {
            bv1Var.a(i2);
        }
    }
}
