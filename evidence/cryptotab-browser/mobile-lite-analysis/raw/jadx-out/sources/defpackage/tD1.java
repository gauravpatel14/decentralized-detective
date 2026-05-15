package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.chromium.ui.base.SelectFileDialog;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tD1 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        File[] fileArrListFiles;
        String[] strArr = SelectFileDialog.E;
        try {
            File fileB = AbstractC1632vj2.b(AbstractC1499tM.a);
            if (fileB.isDirectory() && (fileArrListFiles = fileB.listFiles()) != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (File file : fileArrListFiles) {
                    if (jCurrentTimeMillis - file.lastModified() > SelectFileDialog.D && !file.delete()) {
                        Log.e("cr_SelectFileDialog", "Failed to delete: " + file);
                    }
                }
            }
        } catch (IOException e) {
            Log.w("cr_SelectFileDialog", "Failed to delete captured camera files.", e);
        }
    }
}
