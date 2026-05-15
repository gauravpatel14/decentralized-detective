package defpackage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Process;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import org.chromium.ui.permissions.AndroidPermissionDelegate;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Q3 implements AndroidPermissionDelegate {
    public final Handler t = new Handler();
    public final SparseArray u = new SparseArray();
    public int v;
    public final WeakReference w;

    public Q3(WeakReference weakReference) {
        this.w = weakReference;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(int r9, java.lang.String[] r10, int[] r11) {
        /*
            r8 = this;
            android.util.SparseArray r0 = r8.u
            java.lang.Object r1 = r0.get(r9)
            M8 r1 = (defpackage.M8) r1
            r0.delete(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2 = 0
            r3 = r2
        L17:
            int r4 = r10.length
            r5 = 1
            if (r3 >= r4) goto L58
            r4 = r11[r3]
            if (r4 != 0) goto L25
            r4 = r10[r3]
            r9.add(r4)
            goto L55
        L25:
            r4 = r10[r3]
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 30
            if (r6 >= r7) goto L2e
            goto L4e
        L2e:
            if (r1 == 0) goto L43
            java.util.HashMap r6 = r1.b
            java.lang.Object r7 = r6.get(r4)
            if (r7 == 0) goto L43
            java.lang.Object r6 = r6.get(r4)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            goto L44
        L43:
            r6 = r2
        L44:
            if (r6 != 0) goto L4e
            boolean r4 = r8.c(r4)
            if (r4 == 0) goto L4d
            goto L4e
        L4d:
            r5 = r2
        L4e:
            if (r5 == 0) goto L55
            r4 = r10[r3]
            r0.add(r4)
        L55:
            int r3 = r3 + 1
            goto L17
        L58:
            android.content.SharedPreferences r3 = defpackage.AbstractC1440sM.a
            android.content.SharedPreferences$Editor r3 = r3.edit()
            java.util.Iterator r9 = r9.iterator()
        L62:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L76
            java.lang.Object r4 = r9.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = defpackage.uf1.a(r4)
            r3.remove(r4)
            goto L62
        L76:
            java.util.Iterator r9 = r0.iterator()
        L7a:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L8e
            java.lang.Object r0 = r9.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = defpackage.uf1.a(r0)
            r3.putBoolean(r0, r5)
            goto L7a
        L8e:
            r3.apply()
            if (r1 == 0) goto L9c
            org.chromium.ui.permissions.PermissionCallback r9 = r1.a
            if (r9 != 0) goto L98
            goto L9c
        L98:
            r9.b(r11, r10)
            return r5
        L9c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Q3.a(int, java.lang.String[], int[]):boolean");
    }

    public final boolean b(String str) {
        Activity activity = (Activity) this.w.get();
        if (activity == null) {
            return false;
        }
        return activity.getPackageManager().isPermissionRevokedByPolicy(str, activity.getPackageName());
    }

    public final boolean c(String str) {
        Activity activity = (Activity) this.w.get();
        if (activity == null) {
            return false;
        }
        return activity.shouldShowRequestPermissionRationale(str);
    }

    @Override // org.chromium.ui.permissions.AndroidPermissionDelegate
    public final boolean canRequestPermission(String str) {
        if (hasPermission(str)) {
            return true;
        }
        if (b(str)) {
            return false;
        }
        if (!c(str)) {
            return !AbstractC1440sM.a.getBoolean(uf1.a(str), false);
        }
        SharedPreferences.Editor editorEdit = AbstractC1440sM.a.edit();
        editorEdit.remove(uf1.a(str));
        editorEdit.apply();
        return true;
    }

    @Override // org.chromium.ui.permissions.AndroidPermissionDelegate
    public final boolean hasPermission(String str) {
        boolean z = AbstractC0911ja.a(AbstractC1499tM.a, Process.myPid(), Process.myUid(), str) == 0;
        if (z) {
            SharedPreferences.Editor editorEdit = AbstractC1440sM.a.edit();
            editorEdit.remove(uf1.a(str));
            editorEdit.apply();
        }
        return z;
    }
}
