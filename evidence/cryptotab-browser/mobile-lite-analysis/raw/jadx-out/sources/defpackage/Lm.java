package defpackage;

import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Lm {
    public static Lm a;

    public static void a(int i, String str) {
        String next;
        Km km;
        SharedPreferences sharedPreferences = AbstractC1440sM.a;
        Set<String> stringSet = sharedPreferences.getStringSet("bts_cached_uma", new HashSet());
        if (stringSet != null && stringSet.contains(null)) {
            stringSet.remove(null);
        }
        String str2 = str + ":" + i + ":";
        Iterator<String> it = stringSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next.startsWith(str2)) {
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet(stringSet);
        if (next != null) {
            km = Km.a(next);
            if (km == null) {
                km = new Km(i, 1, str);
            }
            hashSet.remove(next);
            km.c++;
        } else {
            km = new Km(i, 1, str);
        }
        hashSet.add(km.toString());
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (hashSet.contains(null)) {
            hashSet.remove(null);
        }
        editorEdit.putStringSet("bts_cached_uma", hashSet);
        editorEdit.apply();
    }

    public static void b() {
        Set<String> stringSet = AbstractC1440sM.a.getStringSet("bts_cached_uma", new HashSet());
        if (stringSet != null && stringSet.contains(null)) {
            stringSet.remove(null);
        }
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            Km kmA = Km.a(it.next());
            if (kmA != null) {
                for (int i = 0; i < kmA.c; i++) {
                    Gr1.h(kmA.b, 33, kmA.a);
                }
            }
        }
        AbstractC1440sM.a.edit().remove("bts_cached_uma").apply();
    }

    public static String c(int i) {
        if (i == 1) {
            return "Gcm";
        }
        if (i == 2) {
            return "ComponentUpdate";
        }
        if (i == 21) {
            return "NotificationService";
        }
        if (i == 22) {
            return "FeedRefresh";
        }
        if (i == 42) {
            return "WebviewMinidumpUploading";
        }
        if (i == 43) {
            return "ChromeMinidumpUploading";
        }
        if (i == 77) {
            return "OfflinePages";
        }
        if (i == 83) {
            return "WebviewVariationsSeedFetch";
        }
        if (i == 91) {
            return "WebApkUpdate";
        }
        if (i == 110) {
            return "WebviewComponentUpdate";
        }
        if (i == 112) {
            return "SafetyHub";
        }
        if (i == 221) {
            return "NotificationServicePreUnsubscribe";
        }
        if (i == 33656) {
            return "Test";
        }
        if (i == 71300) {
            return "Omaha";
        }
        switch (i) {
            case 53:
                return "DownloadService";
            case 54:
                return "DownloadCleanup";
            case 55:
                return "DeprecatedDownloadResumption";
            case 56:
                return "DownloadAutoResumption";
            case 57:
                return "DownloadLater";
            case 58:
                return "DownloadAutoResumptionUnmetered";
            case 59:
                return "DownloadAutoResumptionAnyNetwork";
            default:
                switch (i) {
                    case 102:
                        return "BackgroundSyncOneShot";
                    case 103:
                        return "NotificationScheduler";
                    case 104:
                        return "NotificationTrigger";
                    case 105:
                        return "PeriodicBackgroundSyncChromeWakeup";
                    case 106:
                        return "QueryTile";
                    case 107:
                        return "FeedV2Refresh";
                    default:
                        return null;
                }
        }
    }

    public static Lm d() {
        if (a == null) {
            a = new Lm();
        }
        return a;
    }

    public static int e(int i) {
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 15;
        }
        if (i == 21) {
            return 3;
        }
        if (i == 22) {
            return 14;
        }
        if (i == 42) {
            return 4;
        }
        if (i == 43) {
            return 5;
        }
        if (i == 77) {
            return 6;
        }
        if (i == 83) {
            return 10;
        }
        if (i == 91) {
            return 12;
        }
        if (i == 110) {
            return 27;
        }
        if (i == 112) {
            return 32;
        }
        if (i == 221) {
            return 31;
        }
        if (i == 33656) {
            return 0;
        }
        if (i == 71300) {
            return 1;
        }
        switch (i) {
            case 53:
                return 8;
            case 54:
                return 9;
            case 55:
                return 13;
            case 56:
                return 18;
            case 57:
                return 25;
            case 58:
                return 29;
            case 59:
                return 30;
            default:
                switch (i) {
                    case 102:
                        return 19;
                    case 103:
                        return 20;
                    case 104:
                        return 21;
                    case 105:
                        return 22;
                    case 106:
                        return 23;
                    case 107:
                        return 24;
                    default:
                        return -1;
                }
        }
    }
}
