package defpackage;

import J.N;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import org.chromium.ui.resources.ResourceManager;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bv1 {
    public final int a;
    public final ResourceManager b;

    public bv1(int i, ResourceManager resourceManager) {
        this.a = i;
        this.b = resourceManager;
    }

    public abstract void a(int i);

    public final void b(int i, Zu1 zu1) {
        ResourceManager resourceManager = this.b;
        if (zu1 == null) {
            return;
        }
        Bitmap bitmapC = zu1.c();
        int i2 = this.a;
        if (bitmapC == null) {
            if (zu1.e()) {
                long j = resourceManager.d;
                if (j != 0) {
                    N._V_IIJO(13, i2, i, j, resourceManager);
                    return;
                }
                return;
            }
            return;
        }
        SparseArray sparseArray = resourceManager.b;
        SparseArray sparseArray2 = (SparseArray) sparseArray.get(i2);
        if (sparseArray2 == null) {
            sparseArray2 = new SparseArray();
            sparseArray.put(i2, sparseArray2);
        }
        dE0 de0 = new dE0();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        XZ0 xz0B = zu1.b();
        if (xz0B != null) {
            rect2 = xz0B.b;
            rect = xz0B.a;
        }
        Rect rectA = zu1.a();
        float f = rect.left;
        float f2 = resourceManager.c;
        new RectF(f * f2, rect.top * f2, rect.right * f2, rect.bottom * f2);
        new RectF(rectA.left * f2, rectA.top * f2, rectA.right * f2, rectA.bottom * f2);
        new RectF(rect2.left * f2, rect2.top * f2, rect2.right * f2, rect2.bottom * f2);
        sparseArray2.put(i, de0);
        long j2 = resourceManager.d;
        if (j2 == 0) {
            return;
        }
        N._V_IIIIJJOO(0, i2, i, zu1.a().width(), zu1.a().height(), j2, zu1.d(), resourceManager, bitmapC);
    }

    public abstract void c(int i);
}
