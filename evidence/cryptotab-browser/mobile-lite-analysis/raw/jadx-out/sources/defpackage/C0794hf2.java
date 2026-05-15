package defpackage;

import J.N;
import android.app.Activity;
import android.content.res.Resources;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.EarlyTraceEvent;
import org.chromium.base.TraceEvent;
import org.chromium.base.task.PostTask;

/* JADX INFO: renamed from: hf2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0794hf2 implements MessageQueue.IdleHandler {
    public static boolean b;
    public static C0794hf2 c;
    public long a;

    public static void a(C0489cf2 c0489cf2, int i, View view) {
        int id = view.getId();
        ArrayList arrayList = c0489cf2.b;
        boolean zIsShown = view.isShown();
        boolean zIsDirty = view.isDirty();
        String simpleName = view.getClass().getSimpleName();
        Resources resources = view.getResources();
        C0858if2 c0858if2 = new C0858if2();
        c0858if2.a = id;
        c0858if2.b = i;
        c0858if2.c = zIsShown;
        c0858if2.d = zIsDirty;
        c0858if2.e = simpleName;
        c0858if2.f = resources;
        arrayList.add(c0858if2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(c0489cf2, id, viewGroup.getChildAt(i2));
            }
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        final ArrayList arrayList;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.a;
        if (j == 0 || jElapsedRealtime - j > 1000) {
            this.a = jElapsedRealtime;
            if (TraceEvent.u && N._Z(2)) {
                TraceEvent.a("instantAndroidViewHierarchy", null);
                if (ApplicationStatus.d()) {
                    ArrayList arrayList2 = new ArrayList(2);
                    for (Activity activity : ApplicationStatus.a()) {
                        String name = activity.getClass().getName();
                        C0489cf2 c0489cf2 = new C0489cf2();
                        c0489cf2.a = name;
                        c0489cf2.b = new ArrayList(125);
                        arrayList2.add(c0489cf2);
                        a((C0489cf2) arrayList2.get(arrayList2.size() - 1), 0, activity.getWindow().getDecorView().getRootView());
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = new ArrayList();
                }
                if (arrayList.isEmpty()) {
                    TraceEvent.b("instantAndroidViewHierarchy");
                } else {
                    final long jHashCode = arrayList.hashCode();
                    PostTask.c(0, new Runnable() { // from class: bf2
                        @Override // java.lang.Runnable
                        public final void run() {
                            N._V_JO(1, jHashCode, arrayList);
                        }
                    });
                    EarlyTraceEvent.e("instantAndroidViewHierarchy", false);
                    if (TraceEvent.u) {
                        N._V_JO(0, jHashCode, null);
                    }
                }
            }
        }
        return true;
    }
}
