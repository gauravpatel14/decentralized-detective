package defpackage;

import J.N;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.text.style.UpdateAppearance;
import android.view.textclassifier.TextLinks;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.chromium.base.Callback;
import org.chromium.ui.base.Clipboard;
import org.chromium.url.GURL;

/* JADX INFO: renamed from: eG, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ClipboardManagerOnPrimaryClipChangedListenerC0566eG extends Clipboard implements ClipboardManager.OnPrimaryClipChangedListener {
    public final Context c = AbstractC1499tM.a;
    public final ClipboardManager d;
    public ZF e;
    public YF f;

    public ClipboardManagerOnPrimaryClipChangedListenerC0566eG(ClipboardManager clipboardManager) {
        this.d = clipboardManager;
        clipboardManager.addPrimaryClipChangedListener(this);
    }

    public static boolean k(Spanned spanned) {
        Class[] clsArr = {CharacterStyle.class, ParagraphStyle.class, UpdateAppearance.class};
        for (int i = 0; i < 3; i++) {
            if (spanned.nextSpanTransition(-1, spanned.length(), clsArr[i]) < spanned.length()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.chromium.ui.base.Clipboard
    public final boolean a() {
        return this.d.hasPrimaryClip();
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void b(GURL gurl) {
        if (l(new ClipData(ImagesContract.URL, new String[]{"text/x-moz-url", "text/plain"}, new ClipData.Item(gurl.i())))) {
            m(AbstractC0275Wp1.link_copied);
        }
    }

    @Override // org.chromium.ui.base.Clipboard
    public final Uri c() {
        YF yfA;
        Uri uri;
        ZF zf;
        ZF zf2 = this.e;
        if (zf2 != null && (yfA = zf2.a()) != null && (uri = yfA.a) != null) {
            ClipDescription primaryClipDescription = this.d.getPrimaryClipDescription();
            long timestamp = (primaryClipDescription == null || !primaryClipDescription.hasMimeType("image/*")) ? 0L : primaryClipDescription.getTimestamp();
            if (timestamp != 0 && (zf = this.e) != null) {
                if (timestamp == yfA.b) {
                    return uri;
                }
                zf.d();
                return null;
            }
        }
        return null;
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void clear() {
        if (Build.VERSION.SDK_INT <= 28) {
            l(ClipData.newPlainText(null, null));
            return;
        }
        try {
            this.d.clearPrimaryClip();
        } catch (Exception unused) {
            l(ClipData.newPlainText(null, null));
        }
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void d(boolean z) {
        ClipDescription primaryClipDescription;
        if (!z || Build.VERSION.SDK_INT < 29 || (primaryClipDescription = this.d.getPrimaryClipDescription()) == null) {
            return;
        }
        long timestamp = primaryClipDescription.getTimestamp();
        long j = this.a;
        if (j == 0) {
            return;
        }
        N._V_JJO(15, j, timestamp, this);
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void e(ZF zf) {
        this.e = zf;
        YF yf = this.f;
        if (yf != null) {
            zf.b(yf);
            this.f = null;
        }
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void f(Uri uri) {
        g(false, uri);
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void g(boolean z, Uri uri) {
        Context context = this.c;
        if (uri == null) {
            C0064Fa2.c(context, context.getString(AbstractC0275Wp1.copy_to_clipboard_failure_message), 0).e();
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if ((i == 26 || i == 27) && this.e != null) {
            Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(0).iterator();
            while (it.hasNext()) {
                context.grantUriPermission(it.next().packageName, uri, 1);
            }
        }
        new C0516dG(this, uri, z).c(AbstractC1103mg.e);
    }

    @Override // org.chromium.ui.base.Clipboard
    public final String getCoercedText() {
        try {
            return this.d.getPrimaryClip().getItemAt(0).coerceToText(this.c).toString();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.chromium.ui.base.Clipboard
    public final String getFilenames() {
        try {
            ClipData primaryClip = this.d.getPrimaryClip();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < primaryClip.getItemCount(); i++) {
                Uri uri = primaryClip.getItemAt(i).getUri();
                if (uri != null) {
                    arrayList.add(uri.toString());
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return String.join("\r\n", arrayList);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.chromium.ui.base.Clipboard
    public final String getHTMLText() {
        String html = null;
        try {
            ClipData primaryClip = this.d.getPrimaryClip();
            ClipDescription description = primaryClip.getDescription();
            if (description.hasMimeType("text/html")) {
                html = primaryClip.getItemAt(0).getHtmlText();
            } else if (description.hasMimeType("text/plain")) {
                CharSequence text = primaryClip.getItemAt(0).getText();
                if (text instanceof Spanned) {
                    Spanned spanned = (Spanned) text;
                    if (k(spanned)) {
                        html = Html.toHtml(spanned, 0);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return html;
    }

    @Override // org.chromium.ui.base.Clipboard
    public final String getImageUriString() {
        Uri uriJ = j();
        if (uriJ == null) {
            return null;
        }
        return uriJ.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    @Override // org.chromium.ui.base.Clipboard
    public final byte[] getPng() throws Throwable {
        ?? r3;
        Uri uriJ = j();
        ?? r1 = 0;
        if (uriJ == null) {
            return null;
        }
        ContentResolver contentResolver = AbstractC1499tM.a.getContentResolver();
        if (!"image/png".equalsIgnoreCase(contentResolver.getType(uriJ))) {
            if (!hasImage()) {
                return null;
            }
            try {
                Bitmap bitmapDecodeBitmap = Build.VERSION.SDK_INT >= 28 ? ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, uriJ)) : MediaStore.Images.Media.getBitmap(contentResolver, uriJ);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapDecodeBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                if (byteArrayOutputStream.size() > 100000000) {
                    return null;
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException | OutOfMemoryError unused) {
                return null;
            }
        }
        try {
            r3 = "r";
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uriJ, "r");
            try {
                if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                    try {
                        if (assetFileDescriptorOpenAssetFileDescriptor.getLength() <= 100000000 && assetFileDescriptorOpenAssetFileDescriptor.getLength() != -1) {
                            byte[] bArr = new byte[(int) assetFileDescriptorOpenAssetFileDescriptor.getLength()];
                            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                            try {
                                fileInputStream.read(bArr);
                                assetFileDescriptorOpenAssetFileDescriptor.close();
                                KP1.a(fileInputStream);
                                return bArr;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    assetFileDescriptorOpenAssetFileDescriptor.close();
                                } catch (Throwable unused2) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                }
                return null;
            } catch (IOException unused3) {
                KP1.a(r3);
                return null;
            } catch (Throwable th3) {
                th = th3;
                r1 = "r";
                KP1.a(r1);
                throw th;
            }
        } catch (IOException unused4) {
            r3 = 0;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // org.chromium.ui.base.Clipboard
    public final String getUrl() {
        ClipData primaryClip;
        CharSequence charSequenceSubSequence;
        if (!hasUrl()) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 31) {
            return getCoercedText();
        }
        try {
            primaryClip = this.d.getPrimaryClip();
        } catch (Exception unused) {
        }
        if (!primaryClip.getDescription().hasMimeType("text/x-moz-url")) {
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            TextLinks textLinks = itemAt.getTextLinks();
            if (textLinks != null && !textLinks.getLinks().isEmpty()) {
                CharSequence text = itemAt.getText();
                TextLinks.TextLink textLinkB = AbstractC0395bG.b(textLinks.getLinks().iterator().next());
                charSequenceSubSequence = text.subSequence(textLinkB.getStart(), textLinkB.getEnd());
            }
            return null;
        }
        charSequenceSubSequence = getCoercedText();
        if (charSequenceSubSequence == null) {
            return null;
        }
        return AbstractC0058El2.a(charSequenceSubSequence.toString()).i();
        return null;
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void h(String str, String str2, boolean z) {
        if (l(ClipData.newPlainText(str, str2)) && z) {
            m(AbstractC0275Wp1.copied);
        }
    }

    @Override // org.chromium.ui.base.Clipboard
    public final boolean hasCoercedText() {
        ClipDescription primaryClipDescription = this.d.getPrimaryClipDescription();
        if (primaryClipDescription == null) {
            return false;
        }
        return Build.VERSION.SDK_INT < 28 ? !TextUtils.isEmpty(getCoercedText()) : primaryClipDescription.hasMimeType("text/plain") || primaryClipDescription.hasMimeType("text/html") || primaryClipDescription.hasMimeType("text/x-moz-url");
    }

    @Override // org.chromium.ui.base.Clipboard
    public final boolean hasFilenames() {
        try {
            ClipData primaryClip = this.d.getPrimaryClip();
            for (int i = 0; i < primaryClip.getItemCount(); i++) {
                if (primaryClip.getItemAt(i).getUri() != null) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // org.chromium.ui.base.Clipboard
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean hasHTMLOrStyledText() {
        /*
            r5 = this;
            android.content.ClipboardManager r0 = r5.d
            android.content.ClipDescription r1 = r0.getPrimaryClipDescription()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            java.lang.String r3 = "text/plain"
            boolean r3 = r1.hasMimeType(r3)
            if (r3 == 0) goto L37
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 < r4) goto L1d
            boolean r0 = defpackage.AbstractC1341qa.h(r1)
            goto L35
        L1d:
            android.content.ClipData r0 = r0.getPrimaryClip()     // Catch: java.lang.Exception -> L34
            android.content.ClipData$Item r0 = r0.getItemAt(r2)     // Catch: java.lang.Exception -> L34
            java.lang.CharSequence r0 = r0.getText()     // Catch: java.lang.Exception -> L34
            boolean r3 = r0 instanceof android.text.Spanned
            if (r3 == 0) goto L34
            android.text.Spanned r0 = (android.text.Spanned) r0
            boolean r0 = k(r0)
            goto L35
        L34:
            r0 = r2
        L35:
            if (r0 != 0) goto L3f
        L37:
            java.lang.String r0 = "text/html"
            boolean r0 = r1.hasMimeType(r0)
            if (r0 == 0) goto L40
        L3f:
            r2 = 1
        L40:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ClipboardManagerOnPrimaryClipChangedListenerC0566eG.hasHTMLOrStyledText():boolean");
    }

    @Override // org.chromium.ui.base.Clipboard
    public final boolean hasImage() {
        ClipDescription primaryClipDescription = this.d.getPrimaryClipDescription();
        return primaryClipDescription != null && primaryClipDescription.hasMimeType("image/*");
    }

    @Override // org.chromium.ui.base.Clipboard
    public final boolean hasUrl() {
        if (Build.VERSION.SDK_INT < 31) {
            return new GURL(getCoercedText()).b;
        }
        ClipDescription primaryClipDescription = this.d.getPrimaryClipDescription();
        if (primaryClipDescription == null) {
            return false;
        }
        if (primaryClipDescription.hasMimeType("text/x-moz-url")) {
            return true;
        }
        return primaryClipDescription.hasMimeType("text/*") && primaryClipDescription.getClassificationStatus() == 3 && primaryClipDescription.getConfidenceScore(ImagesContract.URL) > 0.99f;
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void i(String str) {
        h("username", str, false);
    }

    public final Uri j() {
        ClipDescription description;
        try {
            ClipData primaryClip = this.d.getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() != 0 && (description = primaryClip.getDescription()) != null && description.hasMimeType("image/*")) {
                return primaryClip.getItemAt(0).getUri();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean l(ClipData clipData) {
        try {
            LP1 lp1A = Build.MANUFACTURER.toLowerCase(Locale.US).equals("google") ? null : LP1.a();
            try {
                this.d.setPrimaryClip(clipData);
                if (lp1A == null) {
                    return true;
                }
                lp1A.close();
                return true;
            } catch (Throwable th) {
                if (lp1A != null) {
                    try {
                        lp1A.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            int i = AbstractC0275Wp1.copy_to_clipboard_failure_message;
            Context context = this.c;
            C0064Fa2.c(context, context.getString(i), 0).e();
            return false;
        }
    }

    public final void m(int i) {
        if (Build.VERSION.SDK_INT > 32) {
            return;
        }
        C0064Fa2.b(this.c, i, 0).e();
    }

    @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
    public final void onPrimaryClipChanged() {
        ZF zf;
        YF yfA;
        Uri uri;
        Hr1.a("MobileClipboardChanged");
        int i = Build.VERSION.SDK_INT;
        if ((i == 26 || i == 27) && (zf = this.e) != null && (yfA = zf.a()) != null && (uri = yfA.a) != null && !uri.equals(Uri.EMPTY) && !uri.equals(j())) {
            this.c.revokeUriPermission(uri, 1);
            this.e.d();
        }
        long j = this.a;
        if (j == 0) {
            return;
        }
        N._V_JO(281, j, this);
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void setFilenames(String str) {
        Uri uri;
        String[] strArrSplit = str != null ? str.split("\r\n") : new String[0];
        ContentResolver contentResolver = AbstractC1499tM.a.getContentResolver();
        ClipData clipDataNewUri = null;
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (strTrim.isEmpty()) {
                uri = null;
            } else {
                try {
                    uri = Uri.parse(strTrim);
                } catch (Exception unused) {
                    uri = null;
                }
            }
            if (uri != null) {
                if (clipDataNewUri == null) {
                    clipDataNewUri = ClipData.newUri(contentResolver, null, uri);
                } else {
                    clipDataNewUri.addItem(contentResolver, new ClipData.Item(uri));
                }
            }
        }
        if (clipDataNewUri != null) {
            l(clipDataNewUri);
        } else {
            clear();
        }
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void setHTMLText(String str, String str2) {
        l(ClipData.newHtmlText("html", str2, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [cG] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.chromium.ui.base.Clipboard
    public final void setImage(byte[] bArr, String str) {
        ZF zf = this.e;
        if (zf == 0) {
            return;
        }
        zf.c(bArr, str, new Callback() { // from class: cG
            @Override // org.chromium.base.Callback
            /* JADX INFO: renamed from: onResult */
            public final void a0(Object obj) {
                this.t.g(false, (Uri) obj);
            }
        });
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void setPassword(String str) {
        ClipData clipDataNewPlainText = ClipData.newPlainText("password", str);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putBoolean("android.content.extra.IS_SENSITIVE", true);
        clipDataNewPlainText.getDescription().setExtras(persistableBundle);
        l(clipDataNewPlainText);
    }

    @Override // org.chromium.ui.base.Clipboard
    public final void setText(String str) {
        h("text", str, false);
    }
}
