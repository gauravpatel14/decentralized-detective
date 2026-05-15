package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessaging;

/* JADX INFO: renamed from: xf0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1745xf0 {
    public final InterfaceC1390rR1 a;
    public boolean b;
    public Boolean c;
    public final /* synthetic */ FirebaseMessaging d;

    public C1745xf0(FirebaseMessaging firebaseMessaging, InterfaceC1390rR1 interfaceC1390rR1) {
        this.d = firebaseMessaging;
        this.a = interfaceC1390rR1;
    }

    public final synchronized void a() {
        try {
            if (this.b) {
                return;
            }
            Boolean boolC = c();
            this.c = boolC;
            if (boolC == null) {
                C1687wf0 c1687wf0 = new C1687wf0();
                C0753h80 c0753h80 = (C0753h80) this.a;
                c0753h80.a(c0753h80.c, c1687wf0);
            }
            this.b = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean b() {
        boolean z;
        boolean zBooleanValue;
        try {
            a();
            Boolean bool = this.c;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                C0488cf0 c0488cf0 = this.d.a;
                c0488cf0.a();
                KT kt = (KT) c0488cf0.g.get();
                synchronized (kt) {
                    z = kt.a;
                }
                zBooleanValue = z;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zBooleanValue;
    }

    public final Boolean c() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        C0488cf0 c0488cf0 = this.d.a;
        c0488cf0.a();
        Context context = c0488cf0.a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
