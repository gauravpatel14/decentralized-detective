package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Z13 {
    public static final C23 c = new C23("SplitInstallInfoProvider");
    public final Context a;
    public final String b;

    public Z13(Context context) {
        this.a = context;
        this.b = context.getPackageName();
    }

    public static boolean d(String str) {
        return str.startsWith("config.") || str.contains(".config.");
    }

    public static final HashSet e(PackageInfo packageInfo) {
        HashSet hashSet = new HashSet();
        for (String str : g(packageInfo)) {
            if (!d(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public static final HashSet g(PackageInfo packageInfo) {
        HashSet hashSet;
        Bundle bundle = packageInfo.applicationInfo.metaData;
        HashSet hashSet2 = new HashSet();
        C23 c23 = c;
        if (bundle != null) {
            String string = bundle.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                c23.getClass();
            } else {
                Collections.addAll(hashSet2, string.split(",", -1));
                hashSet2.remove("");
                hashSet2.remove("base");
            }
        }
        String[] strArr = packageInfo.splitNames;
        if (strArr != null) {
            Arrays.toString(strArr);
            c23.getClass();
            Collections.addAll(hashSet2, strArr);
        } else {
            c23.getClass();
        }
        C1536u03 c1536u03 = (C1536u03) I13.a.get();
        if (c1536u03 != null) {
            NM1 nm1 = c1536u03.a;
            synchronized (nm1.c) {
                hashSet = new HashSet(nm1.c);
            }
            hashSet2.addAll(hashSet);
        }
        return hashSet2;
    }

    public final C1032lW2 a(Bundle bundle) {
        C1032lW2 c1032lW2B = null;
        C23 c23 = c;
        if (bundle == null) {
            c23.d("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i = bundle.getInt("com.android.vending.splits");
        if (i == 0) {
            c23.d("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            XmlResourceParser xml = this.a.getResources().getXml(i);
            VT2 vt2 = new VT2();
            while (xml.next() != 1) {
                try {
                    if (xml.getEventType() == 2) {
                        if (xml.getName().equals("splits")) {
                            while (xml.next() != 3) {
                                if (xml.getEventType() == 2) {
                                    if (xml.getName().equals("module")) {
                                        String strA = EG2.a("name", xml);
                                        if (strA != null) {
                                            while (xml.next() != 3) {
                                                if (xml.getEventType() == 2) {
                                                    if (xml.getName().equals("language")) {
                                                        while (xml.next() != 3) {
                                                            if (xml.getEventType() == 2) {
                                                                if (xml.getName().equals("entry")) {
                                                                    String strA2 = EG2.a("key", xml);
                                                                    String strA3 = EG2.a("split", xml);
                                                                    EG2.b(xml);
                                                                    if (strA2 != null && strA3 != null) {
                                                                        vt2.a(strA, strA2, strA3);
                                                                    }
                                                                } else {
                                                                    EG2.b(xml);
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        EG2.b(xml);
                                                    }
                                                }
                                            }
                                        } else {
                                            EG2.b(xml);
                                        }
                                    } else {
                                        EG2.b(xml);
                                    }
                                }
                            }
                        } else {
                            EG2.b(xml);
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    Log.e("SplitInstall", "Error while parsing splits.xml", e);
                } catch (IllegalStateException e2) {
                    e = e2;
                    Log.e("SplitInstall", "Error while parsing splits.xml", e);
                } catch (XmlPullParserException e3) {
                    e = e3;
                    Log.e("SplitInstall", "Error while parsing splits.xml", e);
                }
            }
            c1032lW2B = vt2.b();
            if (c1032lW2B == null) {
                c23.d("Can't parse languages metadata.", new Object[0]);
            }
            return c1032lW2B;
        } catch (Resources.NotFoundException unused) {
            c23.d("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }

    public final HashSet b() {
        PackageInfo packageInfoF = f();
        return (packageInfoF == null || packageInfoF.applicationInfo == null) ? new HashSet() : e(packageInfoF);
    }

    public final HashSet c() {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfoF = f();
        HashSet hashSet = null;
        if (packageInfoF != null && (applicationInfo = packageInfoF.applicationInfo) != null) {
            C1032lW2 c1032lW2A = a(applicationInfo.metaData);
            if (c1032lW2A == null) {
                return null;
            }
            hashSet = new HashSet();
            HashSet hashSetG = g(packageInfoF);
            hashSetG.add("");
            HashSet hashSetE = e(packageInfoF);
            hashSetE.add("");
            for (Map.Entry entry : c1032lW2A.a(hashSetE).entrySet()) {
                if (hashSetG.containsAll((Collection) entry.getValue())) {
                    hashSet.add((String) entry.getKey());
                }
            }
        }
        return hashSet;
    }

    public final PackageInfo f() {
        try {
            return this.a.getPackageManager().getPackageInfo(this.b, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            c.a("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }
}
