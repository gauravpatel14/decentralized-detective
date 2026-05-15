package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.SparseArray;
import androidx.mediarouter.app.MediaRouteButton;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class kO0 extends AsyncTask {
    public final int a;
    public final Context b;
    public final /* synthetic */ MediaRouteButton c;

    public kO0(MediaRouteButton mediaRouteButton, int i, Context context) {
        this.c = mediaRouteButton;
        this.a = i;
        this.b = context;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        SparseArray sparseArray = MediaRouteButton.G;
        int i = this.a;
        if (((Drawable.ConstantState) sparseArray.get(i)) == null) {
            return AbstractC1686wb.a(i, this.b);
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public final void onCancelled(Object obj) {
        Drawable drawable = (Drawable) obj;
        if (drawable != null) {
            MediaRouteButton.G.put(this.a, drawable.getConstantState());
        }
        this.c.y = null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Drawable drawableNewDrawable = (Drawable) obj;
        int i = this.a;
        MediaRouteButton mediaRouteButton = this.c;
        if (drawableNewDrawable != null) {
            MediaRouteButton.G.put(i, drawableNewDrawable.getConstantState());
            mediaRouteButton.y = null;
        } else {
            Drawable.ConstantState constantState = (Drawable.ConstantState) MediaRouteButton.G.get(i);
            if (constantState != null) {
                drawableNewDrawable = constantState.newDrawable();
            }
            mediaRouteButton.y = null;
        }
        mediaRouteButton.c(drawableNewDrawable);
    }
}
