package defpackage;

import J.N;
import android.os.Debug;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import org.chromium.base.EarlyTraceEvent;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;
import org.chromium.base.process_launcher.FileDescriptorInfo;
import org.chromium.content.app.ContentChildProcessServiceDelegate;

/* JADX INFO: renamed from: zA, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC1818zA implements Runnable {
    public final /* synthetic */ int t = 1;
    public final /* synthetic */ CA u;

    public /* synthetic */ RunnableC1818zA(CA ca) {
        this.u = ca;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String[] strArr;
        FileDescriptorInfo[] fileDescriptorInfoArr;
        switch (this.t) {
            case 0:
                this.u.a.getClass();
                synchronized (OE0.h.e) {
                    TraceEvent traceEventJ = TraceEvent.j("LibraryLoader.preloadAlreadyLocked", null);
                    if (traceEventJ != null) {
                        traceEventJ.close();
                    }
                    break;
                }
                return;
            default:
                CA ca = this.u;
                try {
                    synchronized (ca.i) {
                        while (true) {
                            try {
                                strArr = ca.j;
                                if (strArr == null) {
                                    ca.i.wait();
                                }
                            } finally {
                            }
                            break;
                        }
                    }
                    CH.f(strArr);
                    if (CH.c().e("renderer-wait-for-java-debugger")) {
                        Debug.waitForDebugger();
                    }
                    EarlyTraceEvent.f();
                    ca.a.a(ca.c);
                    synchronized (ca.e) {
                        ca.l = true;
                        ca.e.notifyAll();
                        break;
                    }
                    synchronized (ca.i) {
                        try {
                            ca.i.notifyAll();
                            while (true) {
                                fileDescriptorInfoArr = ca.k;
                                if (fileDescriptorInfoArr == null) {
                                    ca.i.wait();
                                }
                            }
                        } finally {
                        }
                        break;
                    }
                    SparseArray sparseArray = ca.a.e;
                    int[] iArr = new int[fileDescriptorInfoArr.length];
                    String[] strArr2 = new String[fileDescriptorInfoArr.length];
                    int[] iArr2 = new int[fileDescriptorInfoArr.length];
                    long[] jArr = new long[fileDescriptorInfoArr.length];
                    long[] jArr2 = new long[fileDescriptorInfoArr.length];
                    int i = 0;
                    while (true) {
                        FileDescriptorInfo[] fileDescriptorInfoArr2 = ca.k;
                        if (i >= fileDescriptorInfoArr2.length) {
                            N._V_OOOOO(0, strArr2, iArr, iArr2, jArr, jArr2);
                            ContentChildProcessServiceDelegate contentChildProcessServiceDelegate = ca.a;
                            N._V_IJO(38, contentChildProcessServiceDelegate.c, contentChildProcessServiceDelegate.d, contentChildProcessServiceDelegate);
                            ThreadUtils.b().post(new mL());
                            long jUptimeMillis = SystemClock.uptimeMillis() - Process.getStartUptimeMillis();
                            String str = Process.isIsolated() ? ".Isolated" : ".NotIsolated";
                            Gr1.k(jUptimeMillis, "Android.ChildProcessStartTimeV2.All");
                            Gr1.k(jUptimeMillis, "Android.ChildProcessStartTimeV2".concat(str));
                            N._V_O(49, ca.a.a);
                            N._I_Z(0, false);
                            try {
                                ca.n.f();
                                break;
                            } catch (RemoteException e) {
                                Log.e("cr_ChildProcessService", "Failed to call clean exit callback.", e);
                            }
                            N._V(9);
                            return;
                        }
                        FileDescriptorInfo fileDescriptorInfo = fileDescriptorInfoArr2[i];
                        String str2 = sparseArray != null ? (String) sparseArray.get(fileDescriptorInfo.t) : null;
                        if (str2 != null) {
                            strArr2[i] = str2;
                        } else {
                            iArr[i] = fileDescriptorInfo.t;
                        }
                        iArr2[i] = fileDescriptorInfo.u.detachFd();
                        jArr[i] = fileDescriptorInfo.v;
                        jArr2[i] = fileDescriptorInfo.w;
                        i++;
                    }
                } catch (Throwable th) {
                    try {
                        ca.n.v0(CA.class.getName() + "\n" + Log.getStackTraceString(th));
                        break;
                    } catch (RemoteException e2) {
                        Log.e("cr_ChildProcessService", "Failed to call reportExceptionInInit.", e2);
                    }
                    throw th;
                }
                break;
        }
    }

    public /* synthetic */ RunnableC1818zA(CA ca, String str) {
        this.u = ca;
    }
}
