package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.io.File;

/* JADX INFO: renamed from: dD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0512dD2 implements BI2 {
    public final AC2 a;

    public C0512dD2(AC2 ac2) {
        this.a = ac2;
    }

    @Override // defpackage.BI2
    public final Object zza() {
        String string;
        Context context = this.a.a.a;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null && (string = bundle.getString("local_testing_dir")) != null) {
                return new File(context.getExternalFilesDir(null), string);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }
}
