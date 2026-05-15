package com.google.firebase;

import android.content.Context;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import defpackage.C0488cf0;
import defpackage.C0541df0;
import defpackage.C1523ti;
import defpackage.C1623vW;
import defpackage.C1680wW;
import defpackage.Jn0;
import defpackage.Kn0;
import defpackage.LC0;
import defpackage.Ln0;
import defpackage.NV;
import defpackage.RV;
import defpackage.TE0;
import defpackage.TH;
import defpackage.TW;
import defpackage.UH;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String a(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        TH thA = UH.a(C1680wW.class);
        thA.a(new TW(2, 0, C1523ti.class));
        thA.e = new C1623vW();
        arrayList.add(thA.b());
        TH th = new TH(RV.class, new Class[]{Kn0.class, Ln0.class});
        th.a(new TW(1, 0, Context.class));
        th.a(new TW(1, 0, C0488cf0.class));
        th.a(new TW(2, 0, Jn0.class));
        th.a(new TW(1, 1, C1680wW.class));
        th.e = new NV();
        arrayList.add(th.b());
        arrayList.add(TE0.a("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(TE0.a("fire-core", "20.1.1"));
        arrayList.add(TE0.a("device-name", a(Build.PRODUCT)));
        arrayList.add(TE0.a("device-model", a(Build.DEVICE)));
        arrayList.add(TE0.a("device-brand", a(Build.BRAND)));
        arrayList.add(TE0.b("android-target-sdk", new C0541df0(0)));
        arrayList.add(TE0.b("android-min-sdk", new C0541df0(1)));
        arrayList.add(TE0.b("android-platform", new C0541df0(2)));
        arrayList.add(TE0.b("android-installer", new C0541df0(3)));
        try {
            LC0.u.getClass();
            str = "2.0.20";
        } catch (NoClassDefFoundError unused) {
            str = null;
        }
        if (str != null) {
            arrayList.add(TE0.a("kotlin", str));
        }
        return arrayList;
    }
}
