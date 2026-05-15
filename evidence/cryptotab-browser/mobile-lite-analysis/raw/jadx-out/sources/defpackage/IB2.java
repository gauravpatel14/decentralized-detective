package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IB2 {
    public final int a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;
    public final List f;
    public final List g;
    public final PendingIntent h;
    public final ArrayList i;

    public IB2(int i, int i2, int i3, long j, long j2, List list, List list2, PendingIntent pendingIntent, ArrayList arrayList) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
        this.e = j2;
        this.f = list;
        this.g = list2;
        this.h = pendingIntent;
        this.i = arrayList;
    }

    public static IB2 a(int i, int i2, int i3, long j, long j2, List list, List list2) {
        if (i2 != 8) {
            return new IB2(i, i2, i3, j, j2, list, list2, null, null);
        }
        throw new IllegalArgumentException("REQUIRES_USER_CONFIRMATION state not supported.");
    }

    public static IB2 b(Bundle bundle) {
        return new IB2(bundle.getInt("session_id"), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IB2) {
            IB2 ib2 = (IB2) obj;
            if (this.a == ib2.a && this.b == ib2.b && this.c == ib2.c && this.d == ib2.d && this.e == ib2.e) {
                List list = ib2.f;
                List list2 = this.f;
                if (list2 != null ? list2.equals(list) : list == null) {
                    List list3 = ib2.g;
                    List list4 = this.g;
                    if (list4 != null ? list4.equals(list3) : list3 == null) {
                        PendingIntent pendingIntent = ib2.h;
                        PendingIntent pendingIntent2 = this.h;
                        if (pendingIntent2 != null ? pendingIntent2.equals(pendingIntent) : pendingIntent == null) {
                            ArrayList arrayList = ib2.i;
                            ArrayList arrayList2 = this.i;
                            if (arrayList2 != null ? arrayList2.equals(arrayList) : arrayList == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003;
        long j = this.d;
        int i2 = (i ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.e;
        int i3 = (i2 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        List list = this.f;
        int iHashCode = (i3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.g;
        int iHashCode2 = (iHashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.h;
        int iHashCode3 = (iHashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        ArrayList arrayList = this.i;
        return iHashCode3 ^ (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final String toString() {
        return "SplitInstallSessionState{sessionId=" + this.a + ", status=" + this.b + ", errorCode=" + this.c + ", bytesDownloaded=" + this.d + ", totalBytesToDownload=" + this.e + ", moduleNamesNullable=" + String.valueOf(this.f) + ", languagesNullable=" + String.valueOf(this.g) + ", resolutionIntent=" + String.valueOf(this.h) + ", splitFileIntents=" + String.valueOf(this.i) + "}";
    }
}
