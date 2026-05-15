package defpackage;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dj0 {
    public long a;
    public final ArrayList b;
    public final ArrayList c;
    public final ArrayList d;
    public final HashMap e;
    public final HashMap f;

    public dj0() {
        int i = AbstractC1872zv.a;
        this.a = -1L;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.c = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.d = arrayList3;
        this.e = new HashMap();
        this.f = new HashMap();
        arrayList.add(0L);
        arrayList2.add(0L);
        arrayList3.add(0);
    }

    public static C1597vA0 a(List list, List list2, List list3) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = ((Long) list.get(i)).longValue();
        }
        long[] jArr2 = new long[list2.size()];
        for (int i2 = 0; i2 < list2.size(); i2++) {
            jArr2[i2] = ((Long) list2.get(i2)).longValue();
        }
        int[] iArr = new int[list3.size()];
        for (int i3 = 0; i3 < list3.size(); i3++) {
            iArr[i3] = ((Integer) list3.get(i3)).intValue();
        }
        return new C1597vA0(jArr, jArr2, iArr);
    }

    public static String c(int i) {
        switch (i) {
            case 1:
                return "Total";
            case 2:
                return "OmniboxFocus";
            case 3:
                return "NewTabPage";
            case 4:
                return "Startup";
            case 5:
                return "TabSwitcher";
            case 6:
                return "OpenLinkInNewTab";
            case 7:
                return "StartSurfaceHomepage";
            case 8:
                return "StartSurfaceTabSwitcher";
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                return "FeedScrolling";
            case 10:
                return "WebviewScrolling";
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                return "CombinedWebviewScrolling";
            default:
                throw new IllegalArgumentException("Invalid scenario value");
        }
    }

    public final void b() {
        HashMap map = this.e;
        boolean zIsEmpty = map.isEmpty();
        ArrayList arrayList = this.d;
        ArrayList arrayList2 = this.c;
        ArrayList arrayList3 = this.b;
        if (zIsEmpty) {
            TraceEvent.e("removeUnusedFrames", Long.toString(arrayList3.size()));
            arrayList3.subList(1, arrayList3.size()).clear();
            arrayList2.subList(1, arrayList2.size()).clear();
            arrayList.subList(1, arrayList.size()).clear();
            return;
        }
        Iterator it = map.values().iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            long jLongValue = ((Long) it.next()).longValue();
            if (jLongValue < j) {
                j = jLongValue;
            }
        }
        if (j == 0) {
            return;
        }
        int iIndexOf = arrayList3.indexOf(Long.valueOf(j));
        if (iIndexOf == -1) {
            int i = AbstractC1872zv.a;
            return;
        }
        TraceEvent.e("removeUnusedFrames", Long.toString(iIndexOf));
        arrayList3.subList(1, iIndexOf).clear();
        arrayList2.subList(1, iIndexOf).clear();
        arrayList.subList(1, iIndexOf).clear();
    }

    public final void d(BA0 ba0) {
        int i = ba0.a;
        TraceEvent traceEventJ = TraceEvent.j("startTrackingScenario: ".concat(c(i)), null);
        try {
            int i2 = AbstractC1872zv.a;
            HashMap map = this.e;
            if (map.containsKey(ba0)) {
                this.f.put(ba0, Long.valueOf(SystemClock.uptimeMillis() * 1000000));
                if (traceEventJ != null) {
                    traceEventJ.close();
                    return;
                }
                return;
            }
            TraceEvent.k(((long) i) + 84186319646187624L, "JankCUJ:".concat(c(i)));
            map.put(ba0, (Long) this.b.get(r0.size() - 1));
            if (traceEventJ != null) {
                traceEventJ.close();
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    public final C1597vA0 e(BA0 ba0, long j) {
        int i = ba0.a;
        TraceEvent traceEventJ = TraceEvent.j("finishTrackingScenario: ".concat(c(i)), Long.toString(j));
        try {
            int i2 = AbstractC1872zv.a;
            TraceEvent.c(((long) i) + 84186319646187624L, "JankCUJ:".concat(c(i)));
            Long l = (Long) this.e.remove(ba0);
            if (l == null) {
                b();
                C1597vA0 c1597vA0 = new C1597vA0();
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
                return c1597vA0;
            }
            ArrayList arrayList = this.b;
            int iIndexOf = arrayList.indexOf(l) + 1;
            if (iIndexOf >= arrayList.size()) {
                C1597vA0 c1597vA02 = new C1597vA0();
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
                return c1597vA02;
            }
            int size = arrayList.size();
            if (j > 0) {
                int iBinarySearch = Collections.binarySearch(arrayList, Long.valueOf(j));
                size = iBinarySearch < 0 ? (iBinarySearch + 1) * (-1) : Math.min(iBinarySearch + 1, arrayList.size());
                if (size <= iIndexOf) {
                    TraceEvent.d("FrameMetricsStore invalid endScenarioTimeNs");
                    size = arrayList.size();
                }
            }
            C1597vA0 c1597vA0A = a(arrayList.subList(iIndexOf, size), this.c.subList(iIndexOf, size), this.d.subList(iIndexOf, size));
            b();
            Long l2 = (Long) this.f.remove(ba0);
            if (l2 != null && l2.longValue() > j) {
                d(ba0);
            }
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return c1597vA0A;
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
