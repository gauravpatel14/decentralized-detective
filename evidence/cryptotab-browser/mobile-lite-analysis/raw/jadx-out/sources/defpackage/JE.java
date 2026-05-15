package defpackage;

import android.os.AsyncTask;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JE extends ThreadPoolExecutor {
    public static final int t;
    public static final int u;
    public static final IE v;
    public static final ArrayBlockingQueue w;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        t = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        u = (iAvailableProcessors * 2) + 1;
        v = new IE();
        w = new ArrayBlockingQueue(128);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e) {
            HashMap map = new HashMap();
            for (Runnable runnable2 : (Runnable[]) getQueue().toArray(new Runnable[0])) {
                Class<?> cls = runnable2.getClass();
                if (cls == C0980kg.class) {
                    cls = ((C0980kg) runnable2).t.getClass();
                } else if (cls.getEnclosingClass() == AsyncTask.class) {
                    cls = AsyncTask.class;
                }
                String name = cls.getName();
                map.put(name, Integer.valueOf((map.containsKey(name) ? ((Integer) map.get(name)).intValue() : 0) + 1));
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                if (((Integer) entry.getValue()).intValue() > 32) {
                    sb.append((String) entry.getKey());
                    sb.append(' ');
                }
            }
            throw new RejectedExecutionException(Xd0.a("Prominent classes in AsyncTask: ", sb.length() == 0 ? "NO CLASSES FOUND" : sb.toString()), e);
        }
    }
}
