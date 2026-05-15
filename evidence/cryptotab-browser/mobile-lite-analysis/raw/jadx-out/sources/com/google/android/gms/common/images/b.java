package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {
    public final Uri t;
    public final Bitmap u;
    public final CountDownLatch v;
    public final /* synthetic */ ImageManager w;

    public b(ImageManager imageManager, Uri uri, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.w = imageManager;
        this.t = uri;
        this.u = bitmap;
        this.v = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.w.zai.remove(this.t);
        if (imageReceiver != null) {
            ArrayList arrayList = imageReceiver.u;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zag zagVar = (zag) arrayList.get(i);
                Bitmap bitmap = this.u;
                if (bitmap != null) {
                    zagVar.zac(this.w.zad, bitmap, false);
                } else {
                    this.w.zaj.put(this.t, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager = this.w;
                    zagVar.zab(imageManager.zad, imageManager.zag, false);
                }
                if (!(zagVar instanceof zaf)) {
                    this.w.zah.remove(zagVar);
                }
            }
        }
        this.v.countDown();
        synchronized (ImageManager.zaa) {
            ImageManager.zab.remove(this.t);
        }
    }
}
