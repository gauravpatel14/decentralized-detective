package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.b;
import com.google.android.gms.common.internal.Asserts;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Cy2 implements Runnable {
    public final Uri t;
    public final ParcelFileDescriptor u;
    public final /* synthetic */ ImageManager v;

    public Cy2(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.v = imageManager;
        this.t = uri;
        this.u = parcelFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        Bitmap bitmapDecodeFileDescriptor = null;
        Uri uri = this.t;
        ParcelFileDescriptor parcelFileDescriptor = this.u;
        if (parcelFileDescriptor != null) {
            try {
                bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(uri)), e);
            }
            try {
                parcelFileDescriptor.close();
            } catch (IOException e2) {
                Log.e("ImageManager", "closed failed", e2);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.v;
        imageManager.zae.post(new b(imageManager, uri, bitmapDecodeFileDescriptor, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(uri)));
        }
    }
}
