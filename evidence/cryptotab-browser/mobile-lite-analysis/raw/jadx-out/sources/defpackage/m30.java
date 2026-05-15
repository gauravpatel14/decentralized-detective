package defpackage;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.View;
import org.chromium.ui.dragdrop.DropDataAndroid;
import org.chromium.ui.dragdrop.DropDataProviderImpl;
import org.chromium.url.GURL;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class m30 implements View.OnDragListener {
    public long A;
    public l30 B;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public int x;
    public float y;
    public float z;

    public static int a(DropDataAndroid dropDataAndroid) {
        if (dropDataAndroid.a()) {
            return 4;
        }
        GURL gurl = dropDataAndroid.b;
        if (GURL.k(gurl) && !TextUtils.isEmpty(dropDataAndroid.a)) {
            return 1;
        }
        if (dropDataAndroid.b()) {
            return 2;
        }
        return !GURL.k(gurl) ? 3 : 0;
    }

    public static String b(DropDataAndroid dropDataAndroid) {
        boolean zIsEmpty = TextUtils.isEmpty(dropDataAndroid.a);
        GURL gurl = dropDataAndroid.b;
        if (zIsEmpty) {
            return gurl.i();
        }
        return dropDataAndroid.a + "\n" + gurl.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARN: Type inference failed for: r5v5, types: [byte[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.view.View r10, android.view.View.DragShadowBuilder r11, org.chromium.ui.dragdrop.DropDataAndroid r12) {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m30.c(android.view.View, android.view.View$DragShadowBuilder, org.chromium.ui.dragdrop.DropDataAndroid):boolean");
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        l30 l30Var;
        DragAndDropPermissions dragAndDropPermissionsC;
        if (!this.v) {
            l30 l30Var2 = this.B;
            if (l30Var2 != null && l30Var2.e() && dragEvent.getAction() == 3 && (l30Var = this.B) != null && (dragAndDropPermissionsC = l30Var.c(dragEvent)) != null) {
                dragAndDropPermissionsC.release();
            }
            return false;
        }
        int action = dragEvent.getAction();
        if (action == 1) {
            this.y = dragEvent.getX();
            this.z = dragEvent.getY();
        } else if (action == 3) {
            this.w = true;
            float f = this.y;
            float f2 = this.z;
            float x = dragEvent.getX() - f;
            float y = dragEvent.getY() - f2;
            Gr1.h(Math.round((float) Math.sqrt((y * y) + (x * x))), 51, "Android.DragDrop.FromWebContent.DropInWebContent.DistanceDip");
            Gr1.k(SystemClock.elapsedRealtime() - this.A, "Android.DragDrop.FromWebContent.DropInWebContent.Duration");
        } else if (action == 4) {
            boolean result = dragEvent.getResult();
            if (!this.w) {
                Gr1.k(SystemClock.elapsedRealtime() - this.A, "Android.DragDrop.FromWebContent.Duration.".concat(result ? "Success" : "Canceled"));
                Gr1.h(this.x, 5, "Android.DragDrop.FromWebContent.TargetType");
            }
            boolean z = !this.w && result;
            Bundle bundle = new Bundle();
            bundle.putBoolean("imageIsInUse", z);
            try {
                AbstractC1499tM.a.getContentResolver().call(DropDataProviderImpl.n, "onDragEnd", "", bundle);
            } catch (IllegalArgumentException | NullPointerException unused) {
            }
            this.u = 0;
            this.t = 0;
            this.x = 0;
            this.v = false;
            this.w = false;
            this.A = -1L;
        }
        return false;
    }
}
