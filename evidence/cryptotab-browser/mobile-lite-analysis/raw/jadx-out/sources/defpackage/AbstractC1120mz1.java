package defpackage;

import android.os.Bundle;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: mz1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1120mz1 {
    public static final lz1 a = new lz1();
    public static final lz1 b = new lz1();
    public static final lz1 c = new lz1();

    public static final hz1 a(C0533dW0 c0533dW0) {
        lz1 lz1Var = a;
        LinkedHashMap linkedHashMap = c0533dW0.a;
        vz1 vz1Var = (vz1) linkedHashMap.get(lz1Var);
        if (vz1Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        InterfaceC0105Io2 interfaceC0105Io2 = (InterfaceC0105Io2) linkedHashMap.get(b);
        if (interfaceC0105Io2 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(c);
        String str = (String) linkedHashMap.get(AbstractC0070Fo2.a);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        sz1 sz1VarB = vz1Var.getSavedStateRegistry().b();
        oz1 oz1Var = sz1VarB instanceof oz1 ? (oz1) sz1VarB : null;
        if (oz1Var == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        pz1 pz1VarC = c(interfaceC0105Io2);
        hz1 hz1Var = (hz1) pz1VarC.b.get(str);
        if (hz1Var != null) {
            return hz1Var;
        }
        Class[] clsArr = hz1.f;
        oz1Var.b();
        Bundle bundle2 = oz1Var.c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = oz1Var.c;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = oz1Var.c;
        if (bundle5 != null && bundle5.isEmpty()) {
            oz1Var.c = null;
        }
        hz1 hz1VarA = gz1.a(bundle3, bundle);
        pz1VarC.b.put(str, hz1VarA);
        return hz1VarA;
    }

    public static final void b(vz1 vz1Var) {
        cF0 cf0 = ((C0886jF0) vz1Var.getLifecycle()).c;
        if (cf0 != cF0.u && cf0 != cF0.v) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (vz1Var.getSavedStateRegistry().b() == null) {
            oz1 oz1Var = new oz1(vz1Var.getSavedStateRegistry(), (InterfaceC0105Io2) vz1Var);
            vz1Var.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", oz1Var);
            vz1Var.getLifecycle().a(new iz1(oz1Var));
        }
    }

    public static final pz1 c(InterfaceC0105Io2 interfaceC0105Io2) {
        return (pz1) new C0083Go2(interfaceC0105Io2.getViewModelStore(), new C0995kz1(), interfaceC0105Io2 instanceof InterfaceC1753xn0 ? ((InterfaceC1753xn0) interfaceC0105Io2).getDefaultViewModelCreationExtras() : DO.b).a(Gs1.a(pz1.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
