package defpackage;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.chromium.base.BuildInfo;
import org.chromium.components.crash.CrashKeys;

/* JADX INFO: renamed from: On1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0174On1 {
    public boolean a;
    public HashMap b;
    public File c;
    public FileOutputStream d;
    public final String e = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    public final String f = "------------" + UUID.randomUUID() + "\r\n";
    public final boolean g = true;

    public final void a(String str) {
        try {
            this.d.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException unused) {
        }
    }

    public final void b(Throwable th) {
        LP1 lp1D = LP1.d();
        try {
            c(th);
            d();
            File file = this.c;
            if (file != null && this.a) {
                if (this.g) {
                    this.c = UI0.a(file, new C1613vO(e()));
                }
                f(this.c);
            }
            lp1D.close();
        } catch (Throwable th2) {
            try {
                lp1D.close();
            } catch (Throwable unused) {
            }
            throw th2;
        }
    }

    public final void c(Throwable th) {
        String strB = AbstractC1499tM.b();
        if (strB == null || !strB.contains(":")) {
            strB = "browser";
        }
        int i = AbstractC1872zv.a;
        BuildInfo buildInfo = Bv.a;
        HashMap map = new HashMap();
        this.b = map;
        map.put("prod", "Chrome_Android");
        this.b.put("ptype", strB);
        this.b.put("device", Build.DEVICE);
        this.b.put("ver", "128.0.6613.148");
        this.b.put("channel", "stable");
        this.b.put("android_build_id", Build.ID);
        this.b.put("model", Build.MODEL);
        this.b.put("brand", Build.BRAND);
        this.b.put("board", Build.BOARD);
        this.b.put("android_build_fp", buildInfo.j);
        HashMap map2 = this.b;
        int i2 = Build.VERSION.SDK_INT;
        map2.put("sdk", String.valueOf(i2));
        this.b.put("android-sdk-int", String.valueOf(i2));
        this.b.put("gms_core_version", buildInfo.h);
        this.b.put("installer_package_name", buildInfo.g);
        this.b.put("abi_name", buildInfo.i);
        this.b.put("exception_info", Pg1.b(Log.getStackTraceString(th)));
        this.b.put("early_java_exception", "true");
        this.b.put("package", buildInfo.d + " v260119 (" + buildInfo.f + ")");
        this.b.put("custom_themes", buildInfo.k);
        this.b.put("resources_version", buildInfo.l);
        AtomicReferenceArray atomicReferenceArray = CrashKeys.getInstance().a;
        for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
            String str = (String) atomicReferenceArray.get(i3);
            if (str != null) {
                this.b.put(CrashKeys.c[i3], str);
            }
        }
    }

    public final void d() {
        String str;
        String strD;
        try {
            String str2 = "chromium-browser-minidump-" + this.e + ".dmp";
            File file = new File(e(), "Crash Reports");
            this.a = file.exists();
            if (CH.a.get() != null && (strD = CH.c().d("breakpad-dump-location")) != null) {
                file = new File(strD);
                file.mkdirs();
            }
            this.c = new File(file, str2);
            this.d = new FileOutputStream(this.c);
            Iterator it = this.b.entrySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                str = this.f;
                if (!zHasNext) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                a(str);
                a("Content-Disposition: form-data; name=\"" + str3 + "\"");
                a("\r\n\r\n" + str4 + "\r\n");
            }
            a(str);
            FileOutputStream fileOutputStream = this.d;
            if (fileOutputStream == null) {
                return;
            }
            try {
                try {
                    fileOutputStream.flush();
                    this.d.close();
                } catch (Throwable unused) {
                    this.c = null;
                }
            } finally {
                this.d = null;
            }
        } catch (FileNotFoundException unused2) {
            this.c = null;
        }
    }

    public abstract File e();

    public abstract void f(File file);
}
