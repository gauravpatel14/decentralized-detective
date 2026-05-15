package org.chromium.components.crash;

import J.N;
import defpackage.xO;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class CrashKeys {
    public static final String[] c = {"loaded_dynamic_module", "active_dynamic_module", "application_status", "installed_modules", "emulated_modules", "dynamic_module_dex_name", "partner_customization_config", "first_run"};
    public final AtomicReferenceArray a = new AtomicReferenceArray(8);
    public boolean b;

    public static CrashKeys getInstance() {
        return xO.a;
    }

    public void flushToNative() {
        int i = 0;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.a;
            if (i >= atomicReferenceArray.length()) {
                this.b = true;
                return;
            } else {
                N._V_IOO(10, i, this, (String) atomicReferenceArray.getAndSet(i, null));
                i++;
            }
        }
    }

    public void set(int i, String str) {
        if (this.b) {
            N._V_IOO(10, i, this, str);
        } else {
            this.a.set(i, str);
        }
    }
}
