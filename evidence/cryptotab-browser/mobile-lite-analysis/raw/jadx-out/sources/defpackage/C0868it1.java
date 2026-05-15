package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: renamed from: it1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0868it1 {
    public final Context a;
    public final bm0 b;
    public final PackageManager d;
    public boolean f;
    public final ArrayList e = new ArrayList();
    public final C0740gt1 g = new C0740gt1(this);
    public final RunnableC0806ht1 h = new RunnableC0806ht1(this);
    public final Handler c = new Handler();

    public C0868it1(Context context, bm0 bm0Var) {
        this.a = context;
        this.b = bm0Var;
        this.d = context.getPackageManager();
    }

    public final void a() {
        ArrayList arrayList;
        bm0 bm0Var;
        int i;
        if (this.f) {
            ArrayList<ServiceInfo> arrayList2 = new ArrayList();
            int i2 = Build.VERSION.SDK_INT;
            PackageManager packageManager = this.d;
            if (i2 >= 30) {
                Intent intent = new Intent("android.media.MediaRoute2ProviderService");
                ArrayList arrayList3 = new ArrayList();
                Iterator<ResolveInfo> it = packageManager.queryIntentServices(intent, 0).iterator();
                while (it.hasNext()) {
                    arrayList3.add(it.next().serviceInfo);
                }
                arrayList2 = arrayList3;
            }
            Iterator<ResolveInfo> it2 = packageManager.queryIntentServices(new Intent("android.media.MediaRouteProviderService"), 0).iterator();
            int i3 = 0;
            while (true) {
                boolean zHasNext = it2.hasNext();
                arrayList = this.e;
                boolean z = true;
                bm0Var = this.b;
                if (!zHasNext) {
                    break;
                }
                ServiceInfo serviceInfo = it2.next().serviceInfo;
                if (serviceInfo != null) {
                    if ((C1087mP0.c == null ? false : C1087mP0.c().o) && !arrayList2.isEmpty()) {
                        for (ServiceInfo serviceInfo2 : arrayList2) {
                            if (!serviceInfo.packageName.equals(serviceInfo2.packageName) || !serviceInfo.name.equals(serviceInfo2.name)) {
                            }
                        }
                    }
                    String str = serviceInfo.packageName;
                    String str2 = serviceInfo.name;
                    int size = arrayList.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            i4 = -1;
                            break;
                        }
                        ComponentName componentName = ((ServiceConnectionC0608et1) arrayList.get(i4)).B;
                        if (componentName.getPackageName().equals(str) && componentName.getClassName().equals(str2)) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i4 < 0) {
                        ServiceConnectionC0608et1 serviceConnectionC0608et1 = new ServiceConnectionC0608et1(this.a, new ComponentName(serviceInfo.packageName, serviceInfo.name));
                        serviceConnectionC0608et1.I = new C0674ft1(this, serviceConnectionC0608et1);
                        if (!serviceConnectionC0608et1.E) {
                            serviceConnectionC0608et1.E = true;
                            serviceConnectionC0608et1.k();
                        }
                        i = i3 + 1;
                        arrayList.add(i3, serviceConnectionC0608et1);
                        bm0Var.a(serviceConnectionC0608et1, false);
                    } else if (i4 >= i3) {
                        ServiceConnectionC0608et1 serviceConnectionC0608et12 = (ServiceConnectionC0608et1) arrayList.get(i4);
                        if (!serviceConnectionC0608et12.E) {
                            serviceConnectionC0608et12.E = true;
                            serviceConnectionC0608et12.k();
                        }
                        if (serviceConnectionC0608et12.G == null) {
                            if (!serviceConnectionC0608et12.E || (serviceConnectionC0608et12.x == null && serviceConnectionC0608et12.D.isEmpty())) {
                                z = false;
                            }
                            if (z) {
                                serviceConnectionC0608et12.j();
                                serviceConnectionC0608et12.g();
                            }
                        }
                        i = i3 + 1;
                        Collections.swap(arrayList, i4, i3);
                    }
                    i3 = i;
                }
            }
            if (i3 < arrayList.size()) {
                for (int size2 = arrayList.size() - 1; size2 >= i3; size2--) {
                    ServiceConnectionC0608et1 serviceConnectionC0608et13 = (ServiceConnectionC0608et1) arrayList.get(size2);
                    hP0 hp0D = bm0Var.d(serviceConnectionC0608et13);
                    if (hp0D != null) {
                        serviceConnectionC0608et13.getClass();
                        C1087mP0.b();
                        serviceConnectionC0608et13.w = null;
                        serviceConnectionC0608et13.f(null);
                        bm0Var.k(hp0D, null);
                        bm0Var.a.b(514, hp0D);
                        bm0Var.j.remove(hp0D);
                    }
                    arrayList.remove(serviceConnectionC0608et13);
                    serviceConnectionC0608et13.I = null;
                    if (serviceConnectionC0608et13.E) {
                        serviceConnectionC0608et13.E = false;
                        serviceConnectionC0608et13.k();
                    }
                }
            }
        }
    }
}
