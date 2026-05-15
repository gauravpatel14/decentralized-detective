package defpackage;

import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jr1 implements InterfaceC0564eF0 {
    public final vz1 t;

    public Jr1(vz1 vz1Var) {
        this.t = vz1Var;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        if (bf0 != bF0.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC0762hF0.getLifecycle().b(this);
        vz1 vz1Var = this.t;
        Bundle bundleA = vz1Var.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str, false, Jr1.class.getClassLoader()).asSubclass(rz1.class);
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        if (!(vz1Var instanceof InterfaceC0105Io2)) {
                            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                        }
                        C0094Ho2 viewModelStore = ((InterfaceC0105Io2) vz1Var).getViewModelStore();
                        tz1 savedStateRegistry = vz1Var.getSavedStateRegistry();
                        viewModelStore.getClass();
                        LinkedHashMap linkedHashMap = viewModelStore.a;
                        Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                        while (it.hasNext()) {
                            BE0.a((AbstractC1867zo2) linkedHashMap.get((String) it.next()), savedStateRegistry, vz1Var.getLifecycle());
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            savedStateRegistry.d();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(Xd0.a("Failed to instantiate ", str), e);
                    }
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                }
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException(BN0.a("Class ", str, " wasn't found"), e3);
            }
        }
    }
}
