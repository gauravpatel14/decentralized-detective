package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.firebase.FirebaseCommonRegistrar;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TE0 {
    public static UH a(String str, String str2) {
        C1523ti c1523ti = new C1523ti(str, str2);
        TH thA = UH.a(C1523ti.class);
        thA.d = 1;
        thA.e = new SH(c1523ti);
        return thA.b();
    }

    public static UH b(final String str, final C0541df0 c0541df0) {
        TH thA = UH.a(C1523ti.class);
        thA.d = 1;
        thA.a(new TW(1, 0, Context.class));
        thA.e = new nI() { // from class: SE0
            @Override // defpackage.nI
            public final Object a(Xv1 xv1) {
                String strValueOf;
                Context context = (Context) xv1.a(Context.class);
                switch (c0541df0.a) {
                    case 0:
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        strValueOf = applicationInfo == null ? "" : String.valueOf(applicationInfo.targetSdkVersion);
                        break;
                    case 1:
                        ApplicationInfo applicationInfo2 = context.getApplicationInfo();
                        strValueOf = applicationInfo2 == null ? "" : String.valueOf(applicationInfo2.minSdkVersion);
                        break;
                    case 2:
                        strValueOf = !context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? !context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") ? "" : "embedded" : "auto" : "watch" : "tv";
                        break;
                    default:
                        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                        strValueOf = installerPackageName == null ? "" : FirebaseCommonRegistrar.a(installerPackageName);
                        break;
                }
                return new C1523ti(str, strValueOf);
            }
        };
        return thA.b();
    }
}
