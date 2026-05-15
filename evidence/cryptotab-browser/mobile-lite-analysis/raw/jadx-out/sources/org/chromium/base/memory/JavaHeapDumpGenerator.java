package org.chromium.base.memory;

import android.os.Debug;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JavaHeapDumpGenerator {
    public static boolean generateHprof(String str) {
        try {
            Debug.dumpHprofData(str);
            return true;
        } catch (IOException e) {
            Log.i("cr_JavaHprofGenerator", "Error writing to file " + str + ". Error: " + e.getMessage());
            return false;
        }
    }
}
