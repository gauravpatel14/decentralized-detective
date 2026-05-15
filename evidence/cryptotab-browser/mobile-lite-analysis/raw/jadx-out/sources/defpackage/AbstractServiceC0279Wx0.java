package defpackage;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.File;

/* JADX INFO: renamed from: Wx0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractServiceC0279Wx0 extends Service {
    public static void a(Context context, RD2 rd2) {
        synchronized (rd2) {
            rd2.d.clear();
            Context context2 = rd2.b;
            File noBackupFilesDir = context2.getNoBackupFilesDir();
            if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
                Log.w("InstanceID", "noBackupFilesDir doesn't exist, using regular files directory instead");
                noBackupFilesDir = context2.getFilesDir();
            }
            for (File file : noBackupFilesDir.listFiles()) {
                if (file.getName().startsWith("com.google.InstanceId")) {
                    file.delete();
                }
            }
            rd2.a.edit().clear().commit();
        }
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra("CMD", "RST");
        intent.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
        context.sendBroadcast(intent);
    }
}
