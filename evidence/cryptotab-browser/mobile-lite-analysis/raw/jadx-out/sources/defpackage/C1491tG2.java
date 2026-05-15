package defpackage;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: tG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1491tG2 {
    public final Context a;

    public C1491tG2(Context context) {
        this.a = context;
    }

    public final Set a() {
        Set<String> hashSet;
        synchronized (C1491tG2.class) {
            try {
                hashSet = this.a.getSharedPreferences("playcore_split_install_internal", 0).getStringSet("modules_to_uninstall_if_emulated", new HashSet());
            } catch (Exception unused) {
                hashSet = new HashSet<>();
            }
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
        }
        return hashSet;
    }
}
