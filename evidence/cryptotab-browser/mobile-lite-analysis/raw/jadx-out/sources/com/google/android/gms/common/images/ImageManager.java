package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import defpackage.C1366rA2;
import defpackage.Cy2;
import defpackage.GA2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageManager {
    private static final Object zaa = new Object();
    private static final HashSet zab = new HashSet();
    private static ImageManager zac;
    private final Context zad;
    private final Handler zae = new GA2(Looper.getMainLooper());
    private final ExecutorService zaf;
    private final C1366rA2 zag;
    private final Map zah;
    private final Map zai;
    private final Map zaj;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @KeepName
    final class ImageReceiver extends ResultReceiver {
        public final Uri t;
        public final ArrayList u;

        public ImageReceiver(Uri uri) {
            super(new GA2(Looper.getMainLooper()));
            this.t = uri;
            this.u = new ArrayList();
        }

        public final void a() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(Constants.EXTRA_URI, this.t);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.zad.sendBroadcast(intent);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager imageManager = ImageManager.this;
            imageManager.zaf.execute(new Cy2(imageManager, this.t, parcelFileDescriptor));
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private ImageManager(Context context, boolean z) {
        this.zad = context.getApplicationContext();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zaf = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zag = new C1366rA2(10);
        this.zah = new HashMap();
        this.zai = new HashMap();
        this.zaj = new HashMap();
    }

    public static ImageManager create(Context context) {
        if (zac == null) {
            zac = new ImageManager(context, false);
        }
        return zac;
    }

    public void loadImage(ImageView imageView, int i) {
        zaj(new zae(imageView, i));
    }

    public final void zaj(zag zagVar) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new a(this, zagVar).run();
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zaj(new zae(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zae zaeVar = new zae(imageView, uri);
        zaeVar.zab = i;
        zaj(zaeVar);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zaj(new zaf(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zaf zafVar = new zaf(onImageLoadedListener, uri);
        zafVar.zab = i;
        zaj(zafVar);
    }
}
