package defpackage;

import android.util.Log;
import com.google.android.play.core.splitinstall.internal.zzbl;
import java.io.File;

/* JADX INFO: renamed from: iG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0828iG2 implements FE2 {
    @Override // defpackage.FE2
    public final boolean a(Object obj, File file, File file2) {
        try {
            Class<?> cls = Class.forName("dalvik.system.DexFile");
            try {
                return !((Boolean) Boolean.class.cast(TG2.d(cls, "isDexOptNeeded", String.class).invoke(null, file.getPath()))).booleanValue();
            } catch (Exception e) {
                throw new zzbl("Failed to invoke static method isDexOptNeeded on type " + cls, e);
            }
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
