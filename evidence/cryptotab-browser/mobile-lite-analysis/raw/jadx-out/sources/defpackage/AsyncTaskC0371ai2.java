package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: renamed from: ai2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncTaskC0371ai2 extends AsyncTask {
    public final Context a;
    public final Intent b;
    public final GJ c;

    public AsyncTaskC0371ai2(Context context, Intent intent, GJ gj) {
        this.a = context.getApplicationContext();
        this.b = intent;
        this.c = gj;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        GJ gj = this.c;
        Context context = this.a;
        try {
            if (context.bindService(this.b, gj, 4097)) {
                return null;
            }
            context.unbindService(gj);
            return new IllegalStateException("Could not bind to the service");
        } catch (SecurityException e) {
            Log.w("TWAConnectionPool", "SecurityException while binding.", e);
            return e;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Exception exc = (Exception) obj;
        if (exc != null) {
            GJ gj = this.c;
            ArrayList<C0440bx> arrayList = gj.x;
            for (C0440bx c0440bx : arrayList) {
                c0440bx.d = true;
                C0611ex c0611ex = c0440bx.b;
                if (c0611ex != null && c0611ex.u.h(exc)) {
                    c0440bx.a = null;
                    c0440bx.b = null;
                    c0440bx.c = null;
                }
            }
            arrayList.clear();
            gj.t.run();
            gj.v = 3;
            gj.y = exc;
        }
    }
}
